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
public class DienChinhSach {
    private String maChinhsach;
    private String tenChinhSach;
    private int muchotro;

    public DienChinhSach(String maChinhsach, String tenChinhSach, int muchotro) {
        this.maChinhsach = maChinhsach;
        this.tenChinhSach = tenChinhSach;
        this.muchotro = muchotro;
    }

    public String getMaChinhsach() {
        return maChinhsach;
    }

    public void setMaChinhsach(String maChinhsach) {
        this.maChinhsach = maChinhsach;
    }

    public String getTenChinhSach() {
        return tenChinhSach;
    }

    public void setTenChinhSach(String tenChinhSach) {
        this.tenChinhSach = tenChinhSach;
    }

    public int getMuchotro() {
        return muchotro;
    }

    public void setMuchotro(int muchotro) {
        this.muchotro = muchotro;
    }
    public static void main(String[] args) {
        
    }
    public static String getTen(String ma ,List<DienChinhSach> ds){
        String tenlop = "";
        for(DienChinhSach l :ds){
            if(ma.compareTo(l.getMaChinhsach())==0){
                tenlop = l.getTenChinhSach();
                break;
            }
        }
        return tenlop;
    }
    
    public static int getHotro(String ma ,List<DienChinhSach> ds){
        int tenlop = 0;
        for(DienChinhSach l :ds){
            if(ma.compareTo(l.getMaChinhsach())==0){
                tenlop = l.getMuchotro();
                break;
            }
        }
        return tenlop;
    }
}
