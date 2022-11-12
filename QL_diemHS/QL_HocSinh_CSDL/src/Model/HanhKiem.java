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
public class HanhKiem {
    private String maHanhKiem;
    private String HanhKiem;

    public HanhKiem(String maHanhKiem, String HanhKiem) {
        this.maHanhKiem = maHanhKiem;
        this.HanhKiem = HanhKiem;
    }

    public String getMaHanhKiem() {
        return maHanhKiem;
    }

    public void setMaHanhKiem(String maHanhKiem) {
        this.maHanhKiem = maHanhKiem;
    }

    public String getHanhKiem() {
        return HanhKiem;
    }

    public void setHanhKiem(String HanhKiem) {
        this.HanhKiem = HanhKiem;
    }
    public static String getTenDCT(String ma , List<HanhKiem> ds){
        String dct = "";
        for (HanhKiem d : ds) {
            if(ma.compareTo(d.getMaHanhKiem())==0){
                dct = d.getHanhKiem();
                break;
            }
        }
        return dct;
    }
    public static void main(String[] args) {
        
    }
}
