/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.another;

/**
 *
 * @author minh0
 */
public class DTB_HS {
    public String tenMH;
    public float DTB_HS;
    public int TSBH;
    public int TSBP;
    public int TSBKP;
    
    
    public DTB_HS(String tenMH, float DTB_HS) {
        this.tenMH = tenMH;
        this.DTB_HS = DTB_HS;
        
        this.TSBH = 0;
        this.TSBP = 0;
        this.TSBKP = 0;
    }

    public DTB_HS(String tenMH, float DTB_HS, int TSBH, int TSBP, int TSBKP) {
        this.tenMH = tenMH;
        this.DTB_HS = DTB_HS;
        this.TSBH = TSBH;
        this.TSBP = TSBP;
        this.TSBKP = TSBKP;
    }
    
}
