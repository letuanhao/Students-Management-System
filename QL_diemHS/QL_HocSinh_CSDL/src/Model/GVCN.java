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
public class GVCN {
    
    private String maGV;
    private String malop;
    private String maNamHoc;
    private String maHocKi;

    public GVCN(String maGV, String malop, String maNamHoc, String maHocKi) {
        this.maGV = maGV;
        this.malop = malop;
        this.maNamHoc = maNamHoc;
        this.maHocKi = maHocKi;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getMaNamHoc() {
        return maNamHoc;
    }

    public void setMaNamHoc(String maNamHoc) {
        this.maNamHoc = maNamHoc;
    }

    public String getMaHocKi() {
        return maHocKi;
    }

    public void setMaHocKi(String maHocKi) {
        this.maHocKi = maHocKi;
    }
    
    
    
}
