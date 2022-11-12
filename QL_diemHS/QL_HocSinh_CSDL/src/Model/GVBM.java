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
public class GVBM {
    private String Malop;
    private String MaNamHoc;
    private String MaHocKi;
    private String MaGV;
    private String MaMonHoc;

    public GVBM(String Malop, String MaNamHoc, String MaHocKi, String MaGV, String MaMonHoc) {
        this.Malop = Malop;
        this.MaNamHoc = MaNamHoc;
        this.MaHocKi = MaHocKi;
        this.MaGV = MaGV;
        this.MaMonHoc = MaMonHoc;
    }

    public String getMalop() {
        return Malop;
    }

    public void setMalop(String Malop) {
        this.Malop = Malop;
    }

    public String getMaNamHoc() {
        return MaNamHoc;
    }

    public void setMaNamHoc(String MaNamHoc) {
        this.MaNamHoc = MaNamHoc;
    }

    public String getMaHocKi() {
        return MaHocKi;
    }

    public void setMaHocKi(String MaHocKi) {
        this.MaHocKi = MaHocKi;
    }

    public String getMaGV() {
        return MaGV;
    }

    public void setMaGV(String MaGV) {
        this.MaGV = MaGV;
    }

    public String getMaMonHoc() {
        return MaMonHoc;
    }

    public void setMaMonHoc(String MaMonHoc) {
        this.MaMonHoc = MaMonHoc;
    }
    
}
