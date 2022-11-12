/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author minh0
 */
public class DongHocPhi {
    private String MaNamHoc;
    private String maHocKi;
    private String MaHS;
    private String MaHocPhi;
    private String malop;
    private float HocPhi;
    private boolean DaDong;

    public DongHocPhi(String MaNamHoc, String maHocKi, String MaHS, String MaHocPhi, String malop, float HocPhi, boolean DaDong) {
        this.MaNamHoc = MaNamHoc;
        this.maHocKi = maHocKi;
        this.MaHS = MaHS;
        this.MaHocPhi = MaHocPhi;
        this.malop = malop;
        this.HocPhi = HocPhi;
        this.DaDong = DaDong;
    }

    public String getMaNamHoc() {
        return MaNamHoc;
    }

    public void setMaNamHoc(String MaNamHoc) {
        this.MaNamHoc = MaNamHoc;
    }

    public String getMaHocKi() {
        return maHocKi;
    }

    public void setMaHocKi(String maHocKi) {
        this.maHocKi = maHocKi;
    }

    public String getMaHS() {
        return MaHS;
    }

    public void setMaHS(String MaHS) {
        this.MaHS = MaHS;
    }

    public String getMaHocPhi() {
        return MaHocPhi;
    }

    public void setMaHocPhi(String MaHocPhi) {
        this.MaHocPhi = MaHocPhi;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public float getHocPhi() {
        return HocPhi;
    }

    public void setHocPhi(float HocPhi) {
        this.HocPhi = HocPhi;
    }

    public boolean isDaDong() {
        return DaDong;
    }

    public void setDaDong(boolean DaDong) {
        this.DaDong = DaDong;
    }
    
}
