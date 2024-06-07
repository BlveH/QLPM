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
public class May {
    private String maMay;
    
    private String cauHinh;
    private String tinhTrang;
    private String phanMem;

    public May() {
    }

    public May(String maMay, String cauHinh, String tinhTrang, String phanMem) {
        this.maMay = maMay;
        
        this.cauHinh = cauHinh;
        this.tinhTrang = tinhTrang;
        this.phanMem = phanMem;
    }

    public String getMaMay() {
        return maMay;
    }

    public void setMaMay(String maMay) {
        this.maMay = maMay;
    }

    

    public String getCauHinh() {
        return cauHinh;
    }

    public void setCauHinh(String cauHinh) {
        this.cauHinh = cauHinh;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getPhanMem() {
        return phanMem;
    }

    public void setPhanMem(String phanMem) {
        this.phanMem = phanMem;
    }
    
    
    
}
