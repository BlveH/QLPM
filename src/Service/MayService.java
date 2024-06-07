/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import controller.MayController;
import java.util.List;
import object.May;


public class MayService {
    MayController controller=new MayController();
    public List<May> getAll(){
        return controller.getAll();
    }

    
    public May getById(String id) {
        return controller.getById(id);
    }
    
    public List<May> getByMaPhongMay(String maPhongMay){
        return controller.getByMaPhongMay(maPhongMay);
    }

    
    public int insert(Object object) {
        return controller.insert(object);
    }

    
    public int update(Object object) {
        return controller.update(object);
    }

    
    public int delete(Object object) {
        return controller.delete(object);
    }

    
    public List find(Object... objects) {
        return controller.find(objects);
    }
}
