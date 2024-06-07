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


public class MayController {
    public List<May> getAll() {
        try {
            Connection connection= MySQLConnection.getConnection();
            String sql = "select * from may";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<May> dsMay = new ArrayList<>();
            while (rs.next()) {
                May temp = new May();
                temp.setMaMay(rs.getString("mamay"));
                temp.setCauHinh(rs.getString("cauhinhmay"));
                temp.setTinhTrang(rs.getString("tinhtrangmay"));
                temp.setPhanMem(rs.getString("maphanmem"));
                //temp.setGhiChu(rs.getString("ghichu"));
                dsMay.add(temp);
            }
            return dsMay;

        } catch (SQLException ex) {
           // Logger.getLogger(MayDAO.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
        return null;
    }

  
    public May getById(String maMay) {
        try {
            Connection connection= MySQLConnection.getConnection();
            String sql = "select * from may where mamay=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maMay);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                May may = new May();
                may.setMaMay(rs.getString("mamay"));
                may.setCauHinh(rs.getString("cauhinhmay"));
                may.setTinhTrang(rs.getString("tinhtrangmay"));
                may.setPhanMem(rs.getString("maphanmem"));
               // may.setGhiChu(rs.getString("ghichu"));
                return may;
            }

        } catch (SQLException ex) {
            //Logger.getLogger(MayDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return null;
    }

    public List<May> getByMaPhongMay(String maPhongMay) {

        try {
            Connection connection= MySQLConnection.getConnection();
            String sql = "select * from may where maphongmay=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maPhongMay);
            ResultSet rs = preparedStatement.executeQuery();
            List<May> dsMay = new ArrayList<>();
            while (rs.next()) {
                May temp = new May();
                temp.setMaMay(rs.getString("mamay"));
                temp.setCauHinh(rs.getString("cauhinhmay"));
                temp.setTinhTrang(rs.getString("tinhtrangmay"));
                temp.setPhanMem(rs.getString("maphanmem"));
                //temp.setGhiChu(rs.getString("ghichu"));
                dsMay.add(temp);
            }
            return dsMay;

        } catch (SQLException ex) {
            //Logger.getLogger(MayDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return null;
    }

    
    public int insert(Object object) {
        try {
            Connection connection= MySQLConnection.getConnection();
            May may = (May) object;
            String sql = "insert into May values(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, may.getMaMay());
            preparedStatement.setString(2, may.getCauHinh());
            preparedStatement.setString(3, may.getTinhTrang());
            preparedStatement.setString(4, may.getPhanMem());
            //preparedStatement.setString(5, may.getGhiChu());

            return preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            //Logger.getLogger(MayDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return 0;
    }

    
    public int delete(Object object) {
        try {
            Connection connection= MySQLConnection.getConnection();
            May may = (May) object;
            String sql = "delete from may where mamay=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, may.getMaMay());

            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(MayDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return 0;
    }

    
    public int update(Object object) {
        try {
            Connection connection= MySQLConnection.getConnection();
            May may = (May) object;
            String sql = "update May set cauhinhmay=?, tinhtrangmay=?, maphanmem=? where mamay=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(4, may.getMaMay());
            preparedStatement.setString(1, may.getCauHinh());
            preparedStatement.setString(2, may.getTinhTrang());
            preparedStatement.setString(3, may.getPhanMem());
            //preparedStatement.setString(4, may.getGhiChu());

            return preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            //Logger.getLogger(MayDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return 0;
    }

//    public static void main(String[] args) {
//        MayDAO quanLyMayDAO = new MayDAO();
//        System.out.println(quanLyMayDAO.getAll());
//        System.out.println(quanLyMayDAO.getById("M01PM8").getCauHinh());
//        System.out.println(quanLyMayDAO.getByMaPhongMay("PM8"));
//        May may= new May("M03PM7", "Thap", "Hong", "PM7", "Mới hỏng");
//        System.out.println(quanLyMayDAO.insert(may));
//        may.setGhiChu("Không chạy. sắp thanh lý");
//        System.out.println(quanLyMayDAO.update(may));
//        System.out.println(quanLyMayDAO.delete(may));
//    }

    
    public List find(Object... objects) {
        try {
            Connection connection= MySQLConnection.getConnection();
            String sql= "select * from may where 1=1 ";
            for(int i=0; i<objects.length; i++){
                if(i==0){
                    if(!((String) objects[i]).equalsIgnoreCase("")) sql+="and mamay like'"+(String) objects[i]+"%' ";
                }else if(i==1){
                    if(!((String) objects[i]).equalsIgnoreCase("")) sql+="and cauhinhmay like'"+(String) objects[i]+"%' ";
                }else if(i==2){
                    if(!((String) objects[i]).equalsIgnoreCase("")) sql+="and tinhtrangmay like'"+(String) objects[i]+"%' ";
                }else if(i==3){
                    if(!((String) objects[i]).equalsIgnoreCase("")) sql+="and maphanmem like'"+(String) objects[i]+"%' ";
                }
            }
            
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            ResultSet rs= preparedStatement.executeQuery();
            List<May> listMay= new ArrayList<>();
            while(rs.next()){
                May may= new May(rs.getString("mamay"), rs.getString("cauhinhmay"),
                        rs.getString("tinhtrangmay"), rs.getString("maphanmem"));
                
                listMay.add(may);
            }
            return listMay;
        } catch (SQLException ex) {
            //Logger.getLogger(MayDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
       return null;
    }
}
