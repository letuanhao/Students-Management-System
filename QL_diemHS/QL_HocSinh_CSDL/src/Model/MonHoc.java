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
public class MonHoc {
    private String MaMonHoc;
    private String MonHoc;
    private int heso;

    public MonHoc(String MaMonHoc, String MonHoc, int heso) {
        this.MaMonHoc = MaMonHoc;
        this.MonHoc = MonHoc;
        this.heso = heso;
    }

    public String getMaMonHoc() {
        return MaMonHoc;
    }

    public String getMonHoc() {
        return MonHoc;
    }

    public int getHeso() {
        return heso;
    }

    public void setHeso(int heso) {
        this.heso = heso;
    }

    public void setMaMonHoc(String MaMonHoc) {
        this.MaMonHoc = MaMonHoc;
    }

    public void setMonHoc(String MonHoc) {
        this.MonHoc = MonHoc;
    }
    
    public static String getTen(String ma ,List<MonHoc> ds){
        String tenlop = "";
        for(MonHoc l :ds){
            if(ma.compareTo(l.getMaMonHoc())==0){
                tenlop = l.getMonHoc();
                break;
            }
        }
        return tenlop;
    }
    
    public static void main(String[] args) {
        
    }
}
