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
public class HocLuc {
    private String maHocLuc;
    private String HocLuc;

    public HocLuc(String maHocLuc, String HocLuc) {
        this.maHocLuc = maHocLuc;
        this.HocLuc = HocLuc;
    }

    public String getMaHocLuc() {
        return maHocLuc;
    }

    public void setMaHocLuc(String maHocLuc) {
        this.maHocLuc = maHocLuc;
    }

    public String getHocLuc() {
        return HocLuc;
    }

    public void setHocLuc(String HocLuc) {
        this.HocLuc = HocLuc;
    }
    
    public static String getTenDCT(String ma , List<HocLuc> ds){
        String dct = "";
        for (HocLuc d : ds) {
            if(ma.compareTo(d.getMaHocLuc())==0){
                dct = d.getHocLuc();
                break;
            }
        }
        return dct;
    }
    public static void main(String[] args) {
        
    }
}
