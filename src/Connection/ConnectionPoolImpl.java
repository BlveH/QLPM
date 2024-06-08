package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class ConnectionPoolImpl implements ConnectionPool {
    private String driver;
    private String url;
    private String username;
    private String password;
    private Stack<Connection> pools;

    public ConnectionPoolImpl() {
        this.driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(this.driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.url = "jdbc:mysql://localhost:3306/QLPM";
        this.username = "root";
        this.password = "blue000";
    }

    @Override
    public Connection getConnection() {
        if (pools == null) {
            pools = new Stack<>();
        }
        if (pools.isEmpty()) {
            try {
                pools.push(DriverManager.getConnection(url, username, password));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return pools.pop();
    }
    @Override
    public void releaseConnection(Connection connection) {
        pools.push(connection);
    }
    protected void finalize() throws Throwable {
        for (Connection connection : pools) {
            connection.close();
        }
        this.pools.clear();
        this.pools = null;
    }
}
