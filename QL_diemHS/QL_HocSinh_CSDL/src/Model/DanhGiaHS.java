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
public class DanhGiaHS {
    private String maHS;
    private String tenHS;
    private String malop;
    private String maNH;
    private String maHK;
    private String maHanhKiem;
    private String maHocLưc;
    private float DiemTBHK;

    public DanhGiaHS(String maHS, String tenHS, String malop, String maNH, String maHK, String maHanhKiem, String maHocLưc, float DiemTBHK) {
        this.maHS = maHS;
        this.tenHS = tenHS;
        this.malop = malop;
        this.maNH = maNH;
        this.maHK = maHK;
        this.maHanhKiem = maHanhKiem;
        this.maHocLưc = maHocLưc;
        this.DiemTBHK = DiemTBHK;
    }

    public String getMaHS() {
        return maHS;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
    }

    public String getMaNH() {
        return maNH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public String getMaHK() {
        return maHK;
    }

    public void setMaHK(String maHK) {
        this.maHK = maHK;
    }

    public String getMaHanhKiem() {
        return maHanhKiem;
    }

    public void setMaHanhKiem(String maHanhKiem) {
        this.maHanhKiem = maHanhKiem;
    }

    public String getMaHocLưc() {
        return maHocLưc;
    }

    public void setMaHocLưc(String maHocLưc) {
        this.maHocLưc = maHocLưc;
    }

    public float getDiemTBHK() {
        return DiemTBHK;
    }

    public void setDiemTBHK(float DiemTBHK) {
        this.DiemTBHK = DiemTBHK;
    }

    public String getTenHS() {
        return tenHS;
    }

    public void setTenHS(String tenHS) {
        this.tenHS = tenHS;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }
    
    
    
}
