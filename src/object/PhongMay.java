/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.util.List;

/**
 *
 * @author Truong
 */
public class PhongMay {
    private String maPhongMay;
    private String viTri;
    private May may;

    public PhongMay() {
    }

    public PhongMay(String maPhongMay, String viTri, May may) {
        this.maPhongMay = maPhongMay;
        this.viTri = viTri;
        this.may = may;
    }

    public String getMaPhongMay() {
        return maPhongMay;
    }

    public void setMaPhongMay(String maPhongMay) {
        this.maPhongMay = maPhongMay;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public May getMay() {
        return may;
    }

    public void setMay(May may) {
        this.may = may;
    }
    
    
}
