/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author minh0
 */
public class HocSinhDiem {
    private String maHS;
    private String malop;
    private String tenHS;
    private String maMH;
    private String maNH;
    private String maHK;
    private List<DiemHocSinh> DiemMieng;
    private List<DiemHocSinh> Diem15;
    private List<DiemHocSinh> DiemGK;
    private List<DiemHocSinh> DiemHK;
    private List<DiemHocSinh> DiemThiLai;
    private Tongketmon TKmon;

    public String getMaHS() {
        return maHS;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenHS() {
        return tenHS;
    }

    public void setTenHS(String tenHS) {
        this.tenHS = tenHS;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
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

    public List<DiemHocSinh> getDiemMieng() {
        return DiemMieng;
    }

    public void setDiemMieng(List<DiemHocSinh> DiemMieng) {
        this.DiemMieng = DiemMieng;
    }

    public List<DiemHocSinh> getDiem15() {
        return Diem15;
    }

    public void setDiem15(List<DiemHocSinh> Diem15) {
        this.Diem15 = Diem15;
    }

    public List<DiemHocSinh> getDiemGK() {
        return DiemGK;
    }

    public void setDiemGK(List<DiemHocSinh> DiemGK) {
        this.DiemGK = DiemGK;
    }

    public List<DiemHocSinh> getDiemHK() {
        return DiemHK;
    }

    public void setDiemHK(List<DiemHocSinh> DiemHK) {
        this.DiemHK = DiemHK;
    }

    public List<DiemHocSinh> getDiemThiLai() {
        return DiemThiLai;
    }

    public void setDiemThiLai(List<DiemHocSinh> DiemThiLai) {
        this.DiemThiLai = DiemThiLai;
    }

    public Tongketmon getTKmon() {
        return TKmon;
    }

    public void setTKmon(Tongketmon TKmon) {
        this.TKmon = TKmon;
    }
    

    public HocSinhDiem(String maHS, String malop, String tenHS, String maMH, String maNH, String maHK, List<DiemHocSinh> DiemMieng, List<DiemHocSinh> Diem15, List<DiemHocSinh> DiemGK, List<DiemHocSinh> DiemHK, List<DiemHocSinh> DiemThiLai , Tongketmon TKMon) {
        this.maHS = maHS;
        this.malop = malop;
        this.tenHS = tenHS;
        this.maMH = maMH;
        this.maNH = maNH;
        this.maHK = maHK;
        this.DiemMieng = DiemMieng;
        this.Diem15 = Diem15;
        this.DiemGK = DiemGK;
        this.DiemHK = DiemHK;
        this.DiemThiLai = DiemThiLai;
        this.TKmon = TKMon;
    }

    public HocSinhDiem(String maHS, String malop, String tenHS, String maMH, String maNH, String maHK) {
        this.maHS = maHS;
        this.malop = malop;
        this.tenHS = tenHS;
        this.maMH = maMH;
        this.maNH = maNH;
        this.maHK = maHK;
    }

    
    
    public static String getDiemList(List<DiemHocSinh> ds){
        String diems ="";
        if (ds!=null) {
            for (int i = 0; i < ds.size(); i++) {
                if (i==0) {
                    diems = diems + String.valueOf(ds.get(i).getDiemSo());
                }else{
                    diems = diems + " , "+String.valueOf(ds.get(i).getDiemSo());
                }
            }
        }
        return diems;
    }
}
