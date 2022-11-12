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
public class TonGiao {
    private String maTonGiao;
    private String TonGiao;

    public TonGiao(String maTonGiao, String TonGiao) {
        this.maTonGiao = maTonGiao;
        this.TonGiao = TonGiao;
    }

    public String getMaTonGiao() {
        return maTonGiao;
    }

    public void setMaTonGiao(String maTonGiao) {
        this.maTonGiao = maTonGiao;
    }

    public String getTonGiao() {
        return TonGiao;
    }

    public void setTonGiao(String TonGiao) {
        this.TonGiao = TonGiao;
    }
    public static void main(String[] args) {
        
    }
    
    public static String getTen(String ma ,List<TonGiao> ds){
        String tenlop = "";
        for(TonGiao l :ds){
            if(ma.compareTo(l.getMaTonGiao())==0){
                tenlop = l.getTonGiao();
                break;
            }
        }
        return tenlop;
    }
}

