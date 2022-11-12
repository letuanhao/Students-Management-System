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
public class NamHoc {
    private String MaNH;
    private String NamHoc;

    public NamHoc(String MaNH, String NamHoc) {
        this.MaNH = MaNH;
        this.NamHoc = NamHoc;
    }

    public String getMaNH() {
        return MaNH;
    }

    public void setMaNH(String MaNH) {
        this.MaNH = MaNH;
    }

    public String getNamHoc() {
        return NamHoc;
    }

    public void setNamHoc(String NamHoc) {
        this.NamHoc = NamHoc;
    }
    
    public static String getNamHoc(String ma,List<NamHoc> ds){
        String tenlop = "";
        for(NamHoc l :ds){
            if(ma.compareTo(l.getMaNH())==0){
                tenlop = l.getNamHoc();
                break;
            }
        }
        return tenlop;
    }
    public static void main(String[] args) {
        
    }
}
