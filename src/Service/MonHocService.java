/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import controller.MonHocController;
import object.MonHoc;


public class MonHocService {
     public static MonHoc getMonHoc(String ma){
         return MonHocController.getMonHoc(ma);
     }
}
