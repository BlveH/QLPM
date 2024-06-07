/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Connection.MySQLConnection;
import object.MonHoc;
import java.sql.*;
import object.PhanMem;


public class MonHocController {
    public static MonHoc getMonHoc(String ma){
        MonHoc mh=new MonHoc();
        Connection con=null;
        ResultSet rs=null;
        PreparedStatement ps=null;
        try{
            con= MySQLConnection.getConnection();
            
            String selectSql= "select * from monhoc where mamonhoc=?";
            ps=con.prepareStatement(selectSql);
            ps.setString(1, ma);
            rs=ps.executeQuery();
            if(rs.next()){
                mh.setCauHinhMay(rs.getString("cauhinhmay"));
                mh.setMaMonHoc(ma);
                PhanMem pm= new PhanMem();
                pm.setMaPhanMem(rs.getString("maphanmem"));
                mh.setPhanMem(pm);
                mh.setTenMonHoc(rs.getString("tenmonhoc"));
                con.close();
            }
           
                
        }catch(SQLException e){
            e.printStackTrace();
        }
        return mh;
        
    }
}
