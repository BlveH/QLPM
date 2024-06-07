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
public class PhanMem {
    private String maPhanMem;
    private String tenPhanMem;

    public PhanMem() {
    }

    public PhanMem(String maPhanMem, String tenPhanMem) {
        this.maPhanMem = maPhanMem;
        this.tenPhanMem = tenPhanMem;
    }

    public String getMaPhanMem() {
        return maPhanMem;
    }

    public void setMaPhanMem(String maPhanMem) {
        this.maPhanMem = maPhanMem;
    }

    public String getTenPhanMem() {
        return tenPhanMem;
    }

    public void setTenPhanMem(String tenPhanMem) {
        this.tenPhanMem = tenPhanMem;
    }
    
    
}
