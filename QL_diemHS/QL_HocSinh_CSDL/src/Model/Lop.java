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
public class Lop {
    private String MaLop;
    private String TenLop;

    public Lop(String MaLop, String TenLop) {
        this.MaLop = MaLop;
        this.TenLop = TenLop;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String MaLop) {
        this.MaLop = MaLop;
    }

    public String getTenLop() {
        return TenLop;
    }

    public void setTenLop(String TenLop) {
        this.TenLop = TenLop;
    }
    public static void main(String[] args) {
        
    }
    public static String getTenLop(String malop ,List<Lop> ds){
        String tenlop = "";
        for(Lop l :ds){
            if(malop.compareTo(l.getMaLop())==0){
                tenlop = l.getTenLop();
                break;
            }
        }
        return tenlop;
    }
}
