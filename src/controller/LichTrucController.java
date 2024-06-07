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
import object.GiaoVien;
import object.LichTruc;


public class LichTrucController {
    public List<LichTruc> getAll() {
        try {
            Connection connection= MySQLConnection.getConnection();
            String sql="select * from lichtruc";
            String sql2="select * from giaovien where magiaovien=?";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            ResultSet rs= preparedStatement.executeQuery();
            List<LichTruc> listLichTruc= new ArrayList<>();
            while(rs.next()){
                LichTruc lichTruc= new LichTruc();
                String maGV = rs.getString("magiaovien");
                preparedStatement2.setString(1, maGV);
                ResultSet rs2 = preparedStatement2.executeQuery();
                GiaoVien gv = null;
                if (rs2.next()) {
                    gv = new GiaoVien(rs2.getString("magiaovien"), rs2.getString("tengiaovien"), rs2.getString("hocvi"), rs2.getInt("ngaycong"));
                }
                lichTruc.setGiaoVien(gv);
                //lichTruc.setGiaoVien(new GiaoVienDAO(connection).getById(rs.getString("magiaovien")));
                lichTruc.setNgayTruc(rs.getString("ngaytruc"));
                lichTruc.setGhiChu(rs.getString("ghichu"));
                
                listLichTruc.add(lichTruc);
            }
            
            return listLichTruc;
        } catch (SQLException ex) {
            //Logger.getLogger(LichTrucDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        
        return null;
    }
    public Object getById(String id) {
        return null;
    }

    
    public int insert(Object object) {
        try {
            Connection connection= MySQLConnection.getConnection();
            LichTruc lichTruc= (LichTruc) object;
            String sql="insert into lichtruc values(?, ?, ?)";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, lichTruc.getGiaoVien().getMaGiaoVien());
            preparedStatement.setString(2, lichTruc.getNgayTruc());
            preparedStatement.setString(3, lichTruc.getGhiChu());
            
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(LichTrucDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        
        return 0;
    }

    
    public int delete(Object object) {
        try {
            Connection connection= MySQLConnection.getConnection();
            LichTruc lichTruc= (LichTruc) object;
            String sql="delete from lichtruc where ngaytruc=?";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            //preparedStatement.setString(1, lichTruc.getGiaoVien().getMaGiaoVien());
            preparedStatement.setString(1, lichTruc.getNgayTruc());
            
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(LichTrucDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return 0;
    }

    
    public int update(Object object) {
        try {
            Connection connection= MySQLConnection.getConnection();
            LichTruc lichTruc= (LichTruc) object;
            String sql="update lichtruc set ghichu=? , magiaovien=? where ngaytruc=?";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, lichTruc.getGhiChu());
            preparedStatement.setString(2, lichTruc.getGiaoVien().getMaGiaoVien());
            preparedStatement.setString(3, lichTruc.getNgayTruc());
            int rs= preparedStatement.executeUpdate();
            System.out.println(rs);
            //return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(LichTrucDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return 1;
        }
        return 0;
    }
    
//    public static void main(String[] args) {
//        LichTrucDAO lichTrucDAO= new LichTrucDAO();
//        System.out.println(lichTrucDAO.getAll());
//        System.out.println(lichTrucDAO.getById(""));
//        LichTruc lichTruc= new LichTruc(new GiaoVien("GV01", "", "", 0, ""), "2020-06-05", "");
//        System.out.println(lichTrucDAO.insert(lichTruc));
//        lichTruc.setGhiChu("Buổi trực thứ 2");
//        System.out.println(lichTrucDAO.update(lichTruc));
//        System.out.println(lichTrucDAO.delete(lichTruc));
//    }

   
    public List<LichTruc> find(Object... objects) {
        try {
            Connection connection= MySQLConnection.getConnection();
            String sql="select * from lichtruc where 1=1 ";
            String sql2="select * from giaovien where magiaovien=?";                       
            for(Object i: objects){
                if(i instanceof GiaoVien){
                    sql+="and magiaovien like'"+((GiaoVien) i).getMaGiaoVien()+"%' ";
                }else if(i instanceof String){
                    sql+="and ngaytruc like'"+i+"%' ";
                }
            }
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            ResultSet rs=preparedStatement.executeQuery();
            List<LichTruc> listLichTruc= new ArrayList<>();
            while(rs.next()){
                LichTruc lichTruc= new LichTruc();
                String maGV = rs.getString("magiaovien");
                preparedStatement2.setString(1, maGV);
                ResultSet rs2 = preparedStatement2.executeQuery();
                GiaoVien gv = null;
                if (rs2.next()) {
                    gv = new GiaoVien(rs2.getString("magiaovien"), rs2.getString("tengiaovien"), rs2.getString("hocvi"), rs2.getInt("ngaycong"));
                }
                lichTruc.setGiaoVien(gv);
                //lichTruc.setGiaoVien(new GiaoVienDAO(connection).getById(rs.getString("magiaovien")));
                lichTruc.setNgayTruc(rs.getString("ngaytruc"));
                lichTruc.setGhiChu(rs.getString("ghichu"));
                
                listLichTruc.add(lichTruc);
            }
            return listLichTruc;
        } catch (SQLException ex) {
            //Logger.getLogger(LichTrucDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return null;
    }
    public int count(Object... objects) {
        try {
            Connection connection= MySQLConnection.getConnection();
            String sql="select count(magiaovien) as cong from lichtruc where magiaovien=? and month(ngaytruc)=? and year(ngaytruc)=?";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            for(int i=0; i<objects.length; i++){
                preparedStatement.setString(i+1, (String) objects[i]);
            }
            ResultSet rs= preparedStatement.executeQuery();
            if(rs.next()) 
            return rs.getInt("cong");
            
        } catch (SQLException ex) {
            //Logger.getLogger(LichTrucDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return 0;
    }

}
