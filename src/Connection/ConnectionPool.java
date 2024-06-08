package Connection;
import java.sql.*;

public interface ConnectionPool {
    public Connection getConnection() throws  SQLException;
    public void releaseConnection(Connection connection) throws  SQLException;
}
