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
public class HocKi {
    
    private String maHK;
    private String HK;
    private int heso;

    public HocKi(String maHK, String HK,int heso) {
        this.maHK = maHK;
        this.HK = HK;
        this.heso =heso;
    }

    public String getMaHK() {
        return maHK;
    }

    public void setMaHK(String maHK) {
        this.maHK = maHK;
    }

    public String getHK() {
        return HK;
    }

    public void setHK(String HK) {
        this.HK = HK;
    }

    public int getHeso() {
        return heso;
    }

    public void setHeso(int heso) {
        this.heso = heso;
    }
    public static String getTen(String ma ,List<HocKi> ds){
        String tenlop = "";
        for(HocKi l :ds){
            if(ma.compareTo(l.getMaHK())==0){
                tenlop = l.getHK();
                break;
            }
        }
        return tenlop;
    }
    public static void main(String[] args) {
        
    }
}
