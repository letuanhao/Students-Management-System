
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
public class HocPhi {
    private String MaHocPhi;
    private float HocPhi;

    public HocPhi(String MaHocPhi, float HocPhi) {
        this.MaHocPhi = MaHocPhi;
        this.HocPhi = HocPhi;
    }

    public String getMaHocPhi() {
        return MaHocPhi;
    }

    public void setMaHocPhi(String MaHocPhi) {
        this.MaHocPhi = MaHocPhi;
    }

    public float getHocPhi() {
        return HocPhi;
    }

    public void setHocPhi(float HocPhi) {
        this.HocPhi = HocPhi;
    }
    
    public static float getHocPhi(String maHP,List<HocPhi> ds){
        float hp =0;
        for (HocPhi d : ds) {
            if(maHP.compareTo(d.MaHocPhi)==0){
                hp = d.HocPhi;
                break;
            }
        }
        return hp;
    }
    
}
