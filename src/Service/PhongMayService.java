/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import controller.PhongMayController;
import java.util.ArrayList;
import java.util.List;
import object.PhongMay;


public class PhongMayService {
    PhongMayController phongMayController;
    public PhongMayService(){
        phongMayController=new PhongMayController();
    }
    public List<PhongMay> getAllPhongMay(){
        return phongMayController.getAllPhongMay();
    }
    public void UpdatePhongMay(PhongMay phongMay){
        phongMayController.updatePhongMay(phongMay);
    }
    public void DelelePhongMay(String maphongmay){
        phongMayController.deletePhongMay(maphongmay);
    }
    public void addPhongMay(PhongMay phongMay)
    {
        phongMayController.addPhongMay(phongMay);
    }
    public static ArrayList<PhongMay> getPhongMayTheoCauHinh(String cauhinh, String maPM){
        return PhongMayController.getPhongMayTheoCauHinh(cauhinh, maPM);
    }
    
}
