/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

//import dao.LichTrucDAO;
import controller.LichTrucController;
import java.util.List;
import object.LichTruc;

/**
 *
 * @author Truong
 */
public class LichTrucService{
    private LichTrucController lichTrucController;

    public LichTrucService() {
        lichTrucController= new LichTrucController();
    }

   
    public List<LichTruc> getAll() {
        return lichTrucController.getAll();
    }

    
    public Object getById(String id) {
       return null; 
    }

    
    public int insert(Object object) {
        return lichTrucController.insert(object);
    }

    
    public int update(Object object) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return lichTrucController.update(object);
    }

    
    public int delete(Object object) {
        return lichTrucController.delete(object);
    }

    
    public List<LichTruc> find(Object... objects) {
        return lichTrucController.find(objects);
    }
    public int count(Object... objects){
        return lichTrucController.count(objects);
    }
    
    
}
