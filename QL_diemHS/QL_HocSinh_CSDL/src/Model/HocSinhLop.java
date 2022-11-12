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
public class HocSinhLop {
    private String maHS;
    private String maNamHoc;
    private String maHocKy;
    private String maLop;

    public HocSinhLop(String maHS, String maNamHoc, String maHocKy, String maLop) {
        this.maHS = maHS;
        this.maNamHoc = maNamHoc;
        this.maHocKy = maHocKy;
        this.maLop = maLop;
    }

    public String getMaHS() {
        return maHS;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
    }

    public String getMaNamHoc() {
        return maNamHoc;
    }

    public void setMaNamHoc(String maNamHoc) {
        this.maNamHoc = maNamHoc;
    }

    public String getMaHocKy() {
        return maHocKy;
    }

    public void setMaHocKy(String maHocKy) {
        this.maHocKy = maHocKy;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }
}
