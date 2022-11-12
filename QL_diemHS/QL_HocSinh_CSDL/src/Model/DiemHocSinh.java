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
public class DiemHocSinh {
    private int STT;
    private String madiem;
    private String mamon;
    private String maHocSinh;
    private String maHK;
    private String maNH;
    private float DiemSo;

    public DiemHocSinh(int STT, float DiemSo) {
        this.STT = STT;
        this.DiemSo = DiemSo;
    }

    public DiemHocSinh(int STT, String madiem, String mamon, String maHocSinh, String maHK, String maNH, float DiemSo) {
        this.STT = STT;
        this.madiem = madiem;
        this.mamon = mamon;
        this.maHocSinh = maHocSinh;
        this.maHK = maHK;
        this.maNH = maNH;
        this.DiemSo = DiemSo;
    }
    
    
    
    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public float getDiemSo() {
        return DiemSo;
    }

    public void setDiemSo(float DiemSo) {
        this.DiemSo = DiemSo;
    }

    public String getMadiem() {
        return madiem;
    }

    public void setMadiem(String madiem) {
        this.madiem = madiem;
    }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    public String getMaHocSinh() {
        return maHocSinh;
    }

    public void setMaHocSinh(String maHocSinh) {
        this.maHocSinh = maHocSinh;
    }

    public String getMaHK() {
        return maHK;
    }

    public void setMaHK(String maHK) {
        this.maHK = maHK;
    }

    public String getMaNH() {
        return maNH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }
    
}
