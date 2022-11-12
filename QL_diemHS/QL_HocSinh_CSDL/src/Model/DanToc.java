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
public class DanToc {
    private String MaDanToc;
    private String DanToc;

    public DanToc(String MaDanToc, String DanToc) {
        this.MaDanToc = MaDanToc;
        this.DanToc = DanToc;
    }

    public String getMaDanToc() {
        return MaDanToc;
    }

    public void setMaDanToc(String MaDanToc) {
        this.MaDanToc = MaDanToc;
    }

    public String getDanToc() {
        return DanToc;
    }

    public void setDanToc(String DanToc) {
        this.DanToc = DanToc;
    }
    public static void main(String[] args) {
        
    }
    
    public static String getTenDT(String maDT ,List<DanToc> ds){
        String tenlop = "";
        for(DanToc l :ds){
            if(maDT.compareTo(l.getMaDanToc())==0){
                tenlop = l.getDanToc();
                break;
            }
        }
        return tenlop;
    }
}
