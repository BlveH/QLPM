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
import object.Account;


public class AccountController {
    public Account getByMaGiaoVien(String maGiaoVien){
        try {
            String sql="select * from accounts where magiaovien=?";
            Connection conn = MySQLConnection.getConnection();
            PreparedStatement preparedStatement= conn.prepareStatement(sql);
            preparedStatement.setString(1, maGiaoVien);
            ResultSet resultSet= preparedStatement.executeQuery();
            
            if(resultSet.next()){
                return new Account(resultSet.getInt("id") ,resultSet.getString("maGiaoVien"), resultSet.getString("passwords"), resultSet.getString("roles"));
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<Account> getAllAccount(){
        Connection conn = MySQLConnection.getConnection();
        List<Account> li=new ArrayList<Account>();       
        String sql="Select * from accounts ";
        try {
            PreparedStatement preparedStatement= conn.prepareStatement(sql);
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                Account a=new Account();
                a.setId(rs.getInt("id"));
                a.setMaGiaoVien(rs.getString("magiaovien"));
                a.setPassword(rs.getString("passwords"));
                a.setRole(rs.getString("roles"));
                li.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
    public void updateAccount(Account account){
        Connection conn= MySQLConnection.getConnection();
        String sql="update accounts set passwords=?, roles=? where magiaovien=?";
        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, account.getPassword());
            preparedStatement.setString(2, account.getRole());
            preparedStatement.setString(3, account.getMaGiaoVien());           
            int rs= preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void deleteAccount(String magiaovien){
        Connection conn= MySQLConnection.getConnection();
        String sql="delete from accounts where magiaovien=?";
        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, magiaovien);
            int rs= preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }                              
    }
    public int addAccount(Account account){
        Connection conn= MySQLConnection.getConnection();
        String sql="insert into accounts values (?,?,?,?)";
        try {
            PreparedStatement preparedStatement= conn.prepareStatement(sql);
            preparedStatement.setInt(1, account.getId());
            preparedStatement.setString(2, account.getMaGiaoVien());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setString(4, account.getRole());
            int rs= preparedStatement.executeUpdate();
            System.out.println(rs);
        }catch (SQLException e) {
            return 1;
        }
        return 0;
    }
}
