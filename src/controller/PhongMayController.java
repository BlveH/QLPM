/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Connection.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.May;
import object.PhongMay;


public class PhongMayController {
    public List<PhongMay> getAllPhongMay(){
        try {
            List<PhongMay> phongmay=new ArrayList<PhongMay>();
            Connection conn= MySQLConnection.getConnection();
            String sql="select * from phongmay";
            String sql2="select * from may where mamay=?";
            PreparedStatement preparedStatement= conn.prepareStatement(sql);
            PreparedStatement preparedStatement2=conn.prepareStatement(sql2);
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                PhongMay phongMay=new PhongMay();
                phongMay.setMaPhongMay(rs.getString("maphongmay"));
                phongMay.setViTri(rs.getString("vitri"));
                String mamay= rs.getString("mamay");
                preparedStatement2.setString(1, mamay);
                ResultSet rs2= preparedStatement2.executeQuery();
                May m=null;
                if(rs2.next()){
                    m=new May(rs2.getString("mamay"),rs2.getString("cauhinhmay"),rs2.getString("tinhtrangmay"),rs2.getString("maphanmem"));
                }
                phongMay.setMay(m);
                phongmay.add(phongMay);
            }
            return phongmay;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<PhongMay> getPhongMayTheoCauHinh(String cauhinh, String maPM){
        ArrayList<PhongMay> li=new ArrayList<PhongMay>();
        try {
            
            Connection conn= MySQLConnection.getConnection();
            String sql="select maphongmay,vitri,may.mamay from phongmay inner join may on may.mamay=phongmay.mamay where cauhinhmay=? and maphanmem=?";
            PreparedStatement preparedStatement= conn.prepareStatement(sql);
            preparedStatement.setString(1, cauhinh);
            preparedStatement.setString(2, maPM);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                /*create table phongmay(
	maphongmay char(5) not null primary key,
    vitri nvarchar(20) not null,
    mamay char(5) not null, 
	constraint FK_phongmay_may foreign key (mamay) references may(mamay)
);
                
                */
                PhongMay phongMay=new PhongMay();
                phongMay.setMaPhongMay(rs.getString("maphongmay"));
                /*
                phongMay.setViTri(rs.getString("vitri"));
                May may = new May();
                may.setMaMay(rs.getString("may.mamay"));
                
              phongMay.setMay(may);*/
                li.add(phongMay);
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return li;
    }
    public void addPhongMay(PhongMay phongMay){
        Connection conn=MySQLConnection.getConnection();
        String sql="insert into phongmay values(?,?,?) ";
        try {
            PreparedStatement preparedStatement= conn.prepareStatement(sql);
            preparedStatement.setString(1, phongMay.getMaPhongMay());
            preparedStatement.setString(2, phongMay.getViTri());
            preparedStatement.setString(3, phongMay.getMay().getMaMay());
            int rs= preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updatePhongMay(PhongMay phongMay){
        Connection conn=MySQLConnection.getConnection();
        String sql="update phongmay set maphongmay=?,vitri=?,mamay=? where maphongmay=?";
        try {
            PreparedStatement preparedStatement= conn.prepareStatement(sql);
            preparedStatement.setString(1, phongMay.getMaPhongMay());
            preparedStatement.setString(2, phongMay.getViTri());
            preparedStatement.setString(3, phongMay.getMay().getMaMay());
            preparedStatement.setString(4, phongMay.getMaPhongMay());
            int rs= preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deletePhongMay(String maphongmay){
        Connection conn= MySQLConnection.getConnection();
        String sql="delete from phongmay where maphongmay=?";
        try {
            PreparedStatement preparedStatement= conn.prepareStatement(sql);
            preparedStatement.setString(1, maphongmay);
            int rs= preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
