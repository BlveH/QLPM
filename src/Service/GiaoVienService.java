/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import controller.GiaoVienController;
import java.util.List;
import object.GiaoVien;



public class GiaoVienService {
    private GiaoVienController giaoVienController;
    public GiaoVienService(){
        giaoVienController=new GiaoVienController();
    }
    public List<GiaoVien> getAllGiaoVien(){
        return giaoVienController.getAllGiaoVien();
    }
    public void addGiaoVien(GiaoVien giaovien){
        giaoVienController.addGiaoVien(giaovien);
    }
    public void deleteGiaoVien(String magiaovien){
        giaoVienController.deleteGiaoVien(magiaovien);
    }
    public GiaoVien getUserByID(String magiaovien){
        return giaoVienController.getGiaoVienbyID(magiaovien);
    }
    public void updateGiaoVien(GiaoVien giaovien){
        giaoVienController.updateGiaoVien(giaovien);
    }
    public List find(Object... objects){
        return giaoVienController.find(objects);
    }
}
