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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import object.GiaoVien;
import object.DangKySuDung;
import object.MonHoc;
import object.PhongMay;


public class DangKySuDungController {

    //private Map<String, Class<?>> GiaoVien;
    public List<DangKySuDung> getAllDangKySuDung() {
        try {
            List<DangKySuDung> lichtruc = new ArrayList<DangKySuDung>();
            Connection conn = MySQLConnection.getConnection();
            String sql = "SELECT * FROM dangkysudung";
            String sql2 = "SELECT * FROM giaovien where magiaovien=?";
            String sql3 = "select * from phongmay where maphongmay=?";
            String sql4 = "select* from monhoc where mamonhoc=?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
            PreparedStatement preparedStatement3 = conn.prepareStatement(sql3);
            PreparedStatement preparedStatement4 = conn.prepareStatement(sql4);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                DangKySuDung lichTruc = new DangKySuDung();
                lichTruc.setMaDangKy(rs.getString("madangky"));
                //giao vien
                String maGV = rs.getString("magiaovien");
                preparedStatement2.setString(1, maGV);
                ResultSet rs2 = preparedStatement2.executeQuery();
                GiaoVien gv = null;
                if (rs2.next()) {
                    gv = new GiaoVien(rs2.getString("magiaovien"), rs2.getString("tengiaovien"), rs2.getString("hocvi"), rs2.getInt("ngaycong"));
                }
                lichTruc.setGiaoVien(gv);
                //phong may
                String maPhongMay = rs.getString("maphongmay");
                preparedStatement3.setString(1, maPhongMay);
                ResultSet rs3 = preparedStatement3.executeQuery();
                PhongMay pm = null;
                if (rs3.next()) {
                    pm = new PhongMay(rs3.getString("maphongmay"), rs3.getString("vitri"), null);
                }
                lichTruc.setPhongMay(pm);
                //mon hoc
                String maMonHoc = rs.getString("mamonhoc");
                preparedStatement4.setString(1, maMonHoc);
                ResultSet rs4 = preparedStatement4.executeQuery();
                MonHoc mh = null;
                if (rs4.next()) {
                    mh = new MonHoc(rs4.getString("mamonhoc"), rs4.getString("tenmonhoc"), null, rs4.getString("cauhinhmay"));
                }
                lichTruc.setMonHoc(mh);
                
                lichTruc.setBatDau(rs.getString("batdau"));
                lichTruc.setKeThuc(rs.getString("ketthuc"));

                lichtruc.add(lichTruc);
            }
            //System.out.println("null khi getData" + lichtruc);
            return lichtruc;
        } catch (SQLException ex) {
            Logger.getLogger(DangKySuDungController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public int addLichTruc(DangKySuDung lichTruc){
        Connection conn= MySQLConnection.getConnection();
        String sql="insert into dangkysudung values (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement= conn.prepareStatement(sql);
            preparedStatement.setString(1, lichTruc.getMaDangKy());
            preparedStatement.setString(2, lichTruc.getPhongMay().getMaPhongMay());
            preparedStatement.setString(3, lichTruc.getGiaoVien().getMaGiaoVien());
            preparedStatement.setString(4, lichTruc.getMonHoc().getMaMonHoc());
            preparedStatement.setString(5, lichTruc.getBatDau());
            preparedStatement.setString(6, lichTruc.getKeThuc());
            int rs= preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            return 1;
        }
        return 0;
    }
    public void deleteLichTruc(String malichtruc){
        Connection conn= MySQLConnection.getConnection();
        String sql="delete from dangkysudung where madangky=?";
        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, malichtruc);
            int rs= preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }                              
    }
    public int UpdateLichTruc(DangKySuDung lichTruc){
        Connection conn= MySQLConnection.getConnection();
        String sql="update dangkysudung set madangky=?, maphongmay=?, magiaovien=?, mamonhoc=?, batdau=?, ketthuc=? where madangky=?";
        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, lichTruc.getMaDangKy());
            preparedStatement.setString(2, lichTruc.getPhongMay().getMaPhongMay());
            preparedStatement.setString(3, lichTruc.getGiaoVien().getMaGiaoVien());
            preparedStatement.setString(4, lichTruc.getMonHoc().getMaMonHoc());
            preparedStatement.setString(5, lichTruc.getBatDau());
            preparedStatement.setString(6, lichTruc.getKeThuc());
            preparedStatement.setString(7, lichTruc.getMaDangKy());
            int rs= preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
    public void LoadDataCB (String sql,JComboBox cb, String bien){
        try {
            Connection conn= MySQLConnection.getConnection();
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                cb.addItem(rs.getString(bien));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public List<DangKySuDung> find(Object... objects) {
        List<DangKySuDung> lichtruc = new ArrayList<DangKySuDung>();
        try {
            Connection conn= MySQLConnection.getConnection();
            
            String sql = "select * from dangkysudung where 1=1 ";
            for (Object i : objects) {
                
                if (i instanceof PhongMay) {
                    sql += " and maphongmay like '" +  ((PhongMay) i).getMaPhongMay()+"%'";
                } else if (i instanceof GiaoVien) {
                    sql += " and magiaovien like '" + ((GiaoVien) i).getMaGiaoVien()+"%'";
                } else if (i instanceof MonHoc) {
                    sql += " and mamonhoc like '" + ((MonHoc) i).getMaMonHoc()+"%'";
                } else if (i instanceof String) {
                    sql += " and batdau= '" + (String) i+"' ";
                }
                
            }
            
            
            String sql2 = "SELECT * FROM giaovien where magiaovien=?";
            String sql3 = "select * from phongmay where maphongmay=?";
            String sql4 = "select* from monhoc where mamonhoc=?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
            PreparedStatement preparedStatement3 = conn.prepareStatement(sql3);
            PreparedStatement preparedStatement4 = conn.prepareStatement(sql4);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                DangKySuDung lichTruc = new DangKySuDung();
                lichTruc.setMaDangKy(rs.getString("madangky"));
                //giao vien
                String maGV = rs.getString("magiaovien");
                preparedStatement2.setString(1, maGV);
                ResultSet rs2 = preparedStatement2.executeQuery();
                GiaoVien gv = null;
                if (rs2.next()) {
                    gv = new GiaoVien(rs2.getString("magiaovien"), rs2.getString("tengiaovien"), rs2.getString("hocvi"), rs2.getInt("ngaycong"));
                }
                lichTruc.setGiaoVien(gv);
                //phong may
                String maPhongMay = rs.getString("maphongmay");
                preparedStatement3.setString(1, maPhongMay);
                ResultSet rs3 = preparedStatement3.executeQuery();
                PhongMay pm = null;
                if (rs3.next()) {
                    pm = new PhongMay(rs3.getString("maphongmay"), rs3.getString("vitri"), null);
                }
                lichTruc.setPhongMay(pm);
                //mon hoc
                String maMonHoc = rs.getString("mamonhoc");
                preparedStatement4.setString(1, maMonHoc);
                ResultSet rs4 = preparedStatement4.executeQuery();
                MonHoc mh = null;
                if (rs4.next()) {
                    mh = new MonHoc(rs4.getString("mamonhoc"), rs4.getString("tenmonhoc"), null, rs4.getString("cauhinhmay"));
                }
                lichTruc.setMonHoc(mh);
                
                lichTruc.setBatDau(rs.getString("batdau"));
                lichTruc.setKeThuc(rs.getString("ketthuc"));

                lichtruc.add(lichTruc);
            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(DangKySuDungController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return lichtruc;
    }
    public List<DangKySuDung> getLichbyDay(String maphongmay,String batdau){
        Connection conn= MySQLConnection.getConnection();
        String sql="select * from dangkysudung where maphongmay=? and batdau=?";
        String sql2 = "SELECT * FROM giaovien where magiaovien=?";
        String sql3 = "select * from phongmay where maphongmay=?";
        String sql4 = "select* from monhoc where mamonhoc=?";
        List<DangKySuDung> lichtruc=new ArrayList<DangKySuDung>();
        try {
            PreparedStatement preparedStatement= conn.prepareStatement(sql);
            PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
            PreparedStatement preparedStatement3 = conn.prepareStatement(sql3);
            PreparedStatement preparedStatement4 = conn.prepareStatement(sql4);
            preparedStatement.setString(1, maphongmay);
            preparedStatement.setString(2, batdau);
            ResultSet rs= preparedStatement.executeQuery();
            while (rs.next()) {
                DangKySuDung lichTruc = new DangKySuDung();
                lichTruc.setMaDangKy(rs.getString("madangky"));
                //giao vien
                String maGV = rs.getString("magiaovien");
                preparedStatement2.setString(1, maGV);
                ResultSet rs2 = preparedStatement2.executeQuery();
                GiaoVien gv = null;
                if (rs2.next()) {
                    gv = new GiaoVien(rs2.getString("magiaovien"), rs2.getString("tengiaovien"), rs2.getString("hocvi"), rs2.getInt("ngaycong"));
                }
                lichTruc.setGiaoVien(gv);
                //phong may
                String maPhongMay = rs.getString("maphongmay");
                preparedStatement3.setString(1, maPhongMay);
                ResultSet rs3 = preparedStatement3.executeQuery();
                PhongMay pm = null;
                if (rs3.next()) {
                    pm = new PhongMay(rs3.getString("maphongmay"), rs3.getString("vitri"), null);
                }
                lichTruc.setPhongMay(pm);
                //mon hoc
                String maMonHoc = rs.getString("mamonhoc");
                preparedStatement4.setString(1, maMonHoc);
                ResultSet rs4 = preparedStatement4.executeQuery();
                MonHoc mh = null;
                if (rs4.next()) {
                    mh = new MonHoc(rs4.getString("mamonhoc"), rs4.getString("tenmonhoc"), null, rs4.getString("cauhinhmay"));
                }
                lichTruc.setMonHoc(mh);
                
                lichTruc.setBatDau(rs.getString("batdau"));
                lichTruc.setKeThuc(rs.getString("ketthuc"));

                lichtruc.add(lichTruc);
                
            }
            return lichtruc;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        //return null;
    }
}
