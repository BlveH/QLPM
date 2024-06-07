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
import object.GiaoVien;


public class GiaoVienController {
    public List<GiaoVien> getAllGiaoVien(){
        List<GiaoVien> giaoviens=new ArrayList<GiaoVien>();
        Connection conn = MySQLConnection.getConnection();
        String sql="Select* from giaovien ";
        try {
            PreparedStatement preparedStatement= conn.prepareStatement(sql);
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                GiaoVien giaovien=new GiaoVien();
                giaovien.setMaGiaoVien(rs.getString("magiaovien"));
                giaovien.setTenGiaoVien(rs.getString("tengiaovien"));
                giaovien.setHocVi(rs.getString("hocvi"));
                giaovien.setNgayCong(rs.getInt("ngaycong"));
                giaoviens.add(giaovien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return giaoviens;
    }
     public GiaoVien getGiaoVienbyID(String magiaovien){
        List<GiaoVien> giaoviens=new ArrayList<GiaoVien>();
        Connection conn = MySQLConnection.getConnection();
        String sql="Select* from giaovien where magiaovien=?";
        try {
            PreparedStatement preparedStatement= conn.prepareStatement(sql);
            preparedStatement.setString(1, magiaovien);
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                GiaoVien giaovien=new GiaoVien();
                giaovien.setMaGiaoVien(rs.getString("magiaovien"));
                giaovien.setTenGiaoVien(rs.getString("tengiaovien"));
                giaovien.setHocVi(rs.getString("hocvi"));
                giaovien.setNgayCong(rs.getInt("ngaycong"));
                return giaovien;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void addGiaoVien(GiaoVien giaovien){
        Connection conn= MySQLConnection.getConnection();
        String sql= "insert into giaovien(magiaovien, tengiaovien, hocvi, ngaycong) values(?,?,?,?)";
        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, giaovien.getMaGiaoVien());
            preparedStatement.setString(2, giaovien.getTenGiaoVien());
            preparedStatement.setString(3, giaovien.getHocVi());
            preparedStatement.setInt(4, giaovien.getNgayCong());
            int rs= preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
    public void updateGiaoVien(GiaoVien giaovien){
        Connection conn= MySQLConnection.getConnection();
        String sql="update giaovien set magiaovien=?, tengiaovien=?, hocvi=?, ngaycong=? where magiaovien=?";
        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, giaovien.getMaGiaoVien());
            preparedStatement.setString(2, giaovien.getTenGiaoVien());
            preparedStatement.setString(3, giaovien.getHocVi());
            preparedStatement.setInt(4, giaovien.getNgayCong());
            preparedStatement.setString(5, giaovien.getMaGiaoVien());
            
            int rs= preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteGiaoVien(String magiaovien){
        Connection conn= MySQLConnection.getConnection();
        String sql="delete from giaovien where magiaovien=?";
        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, magiaovien);
            int rs= preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
        e.printStackTrace();
        }                              
    }
    public List find(Object... objects) {
        try {
            Connection connection= MySQLConnection.getConnection();
            String sql= "select * from giaovien where 1=1 ";
            for(int i=0; i<objects.length; i++){
                if(i==0){
                    if(!((String) objects[i]).equalsIgnoreCase("")) sql+="and magiaovien like'"+(String) objects[i]+"%' ";
                }else if(i==1){
                    if(!((String) objects[i]).equalsIgnoreCase("")) sql+="and tengiaovien like'"+(String) objects[i]+"%' ";
                }else if(i==2){
                    if(!((String) objects[i]).equalsIgnoreCase("")) sql+="and hocvi like'"+(String) objects[i]+"%' ";
                }
            }
            
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            ResultSet rs= preparedStatement.executeQuery();
            List<GiaoVien> li= new ArrayList<>();
            while(rs.next()){
                GiaoVien giaoVien= new GiaoVien(rs.getString("magiaovien"), rs.getString("tengiaovien"),
                        rs.getString("hocvi"), rs.getInt("ngaycong"));
                
                li.add(giaoVien);
            }
            return li;
        } catch (SQLException ex) {
            //Logger.getLogger(MayDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
       return null;
    }
}
