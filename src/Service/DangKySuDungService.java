/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import controller.DangKySuDungController;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import object.DangKySuDung;


public class DangKySuDungService {
    DangKySuDungController lichDangKyController=null; 

    public DangKySuDungService() {
        
        lichDangKyController= new DangKySuDungController();
    }
    
    
    public List<DangKySuDung> getAllDangKySuDung(){
        
        return lichDangKyController.getAllDangKySuDung();
        
    }
    
    public int addLichTruc(DangKySuDung lichsudung){
        List<DangKySuDung> listdksd=getAllDangKySuDung();
        for(DangKySuDung i: listdksd){
            if(i.getBatDau().equals(lichsudung.getBatDau())){
                if(i.getGiaoVien().getMaGiaoVien().equals(lichsudung.getGiaoVien().getMaGiaoVien())){
                    return 1;
                }
                if(i.getPhongMay().getMaPhongMay().equals(lichsudung.getPhongMay().getMaPhongMay())) return 1;
            }
        }
        
        return lichDangKyController.addLichTruc(lichsudung);
    }
    public void DeleteDangKy(String malichtruc){
        lichDangKyController.deleteLichTruc(malichtruc);
    }
    public int UpdateDangKy(DangKySuDung lichsudung){
        List<DangKySuDung> listdksd=getAllDangKySuDung();
        for(DangKySuDung i: listdksd){
            if(!i.getMaDangKy().equals(lichsudung.getMaDangKy())){
            if(i.getBatDau().equals(lichsudung.getBatDau())){
                if(i.getGiaoVien().getMaGiaoVien().equals(lichsudung.getGiaoVien().getMaGiaoVien())){
                    return 1;
                }
                if(i.getPhongMay().getMaPhongMay().equals(lichsudung.getPhongMay().getMaPhongMay())) return 1;
            }
        }
        }
        return lichDangKyController.UpdateLichTruc(lichsudung);
    }
    public void LoadDataCB(String sql,JComboBox cb, String bien){
        lichDangKyController.LoadDataCB(sql, cb, bien);
    }
    public List<DangKySuDung> find(Object... objects){
        return lichDangKyController.find(objects);
    }
    public List<DangKySuDung> getLichbyDay(String maphongmay,String batdau){
        return lichDangKyController.getLichbyDay(maphongmay, batdau);
    }
}

