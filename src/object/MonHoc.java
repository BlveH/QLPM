/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author Truong
 */
public class MonHoc {
    private String maMonHoc;
    private String tenMonHoc;
    private PhanMem phanMem;
    private String cauHinhMay;

    public MonHoc() {
    }

    public MonHoc(String maMonHoc, String tenMonHoc, PhanMem phanMem, String cauHinhMay) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.phanMem = phanMem;
        this.cauHinhMay = cauHinhMay;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public PhanMem getPhanMem() {
        return phanMem;
    }

    public void setPhanMem(PhanMem phanMem) {
        this.phanMem = phanMem;
    }

    public String getCauHinhMay() {
        return cauHinhMay;
    }

    public void setCauHinhMay(String cauHinhMay) {
        this.cauHinhMay = cauHinhMay;
    }
    
    
    
}
