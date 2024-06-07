/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.util.Date;

/**
 *
 * @author Truong
 */
public class DangKySuDung {
    private String maDangKy;
    private PhongMay phongMay;
    private GiaoVien giaoVien;
    private MonHoc monHoc;
    private String batDau;
    private String keThuc;

    public DangKySuDung() {
    }

    public DangKySuDung(String maDangKy, PhongMay phongMay, GiaoVien giaoVien, MonHoc monHoc, String batDau, String keThuc) {
        this.maDangKy = maDangKy;
        this.phongMay = phongMay;
        this.giaoVien = giaoVien;
        this.monHoc = monHoc;
        this.batDau = batDau;
        this.keThuc = keThuc;
    }

    public String getMaDangKy() {
        return maDangKy;
    }

    public void setMaDangKy(String maDangKy) {
        this.maDangKy = maDangKy;
    }

    public PhongMay getPhongMay() {
        return phongMay;
    }

    public void setPhongMay(PhongMay phongMay) {
        this.phongMay = phongMay;
    }

    public GiaoVien getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(GiaoVien giaoVien) {
        this.giaoVien = giaoVien;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public String getBatDau() {
        return batDau;
    }

    public void setBatDau(String batDau) {
        this.batDau = batDau;
    }

    public String getKeThuc() {
        return keThuc;
    }

    public void setKeThuc(String keThuc) {
        this.keThuc = keThuc;
    }

    
    
}
