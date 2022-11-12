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
public class DiemChiTiet {
    private String MaDiem;
    private String DiemChiTiet;
    private int heso;

    public DiemChiTiet(String MaDiem, String DiemChiTiet, int heso) {
        this.MaDiem = MaDiem;
        this.DiemChiTiet = DiemChiTiet;
        this.heso = heso;
    }

    public String getMaDiem() {
        return MaDiem;
    }

    public void setMaDiem(String MaDiem) {
        this.MaDiem = MaDiem;
    }

    public String getDiemChiTiet() {
        return DiemChiTiet;
    }

    public void setDiemChiTiet(String DiemChiTiet) {
        this.DiemChiTiet = DiemChiTiet;
    }

    public int getHeso() {
        return heso;
    }

    public void setHeso(int heso) {
        this.heso = heso;
    }
    public static String getTenDCT(String maDCT , List<DiemChiTiet> ds){
        String dct = "";
        for (DiemChiTiet d : ds) {
            if(maDCT.compareTo(d.getMaDiem())==0){
                dct = d.getDiemChiTiet();
                break;
            }
        }
        return dct;
    }
    public static void main(String[] args) {
        
    }
}
