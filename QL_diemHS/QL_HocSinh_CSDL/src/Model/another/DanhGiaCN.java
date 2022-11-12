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
public class DanhGiaCN {
    public String maHS;
    public String maNH;
    public String tenHs;
    public String maHanhKiem;
    public String maHocLuc;
    public float diemTB;
    public String nhanxet;
    public String trangthai;

    public DanhGiaCN(String maHS, String maNH, String tenHs, String maHanhKiem, String maHocLuc, float diemTB, String nhanxet) {
        this.maHS = maHS;
        this.maNH = maNH;
        this.tenHs = tenHs;
        this.maHanhKiem = maHanhKiem;
        this.maHocLuc = maHocLuc;
        this.diemTB = diemTB;
        this.nhanxet = nhanxet;
    }

    public DanhGiaCN(String maHS, String maNH, String tenHs, String maHanhKiem, String maHocLuc, float diemTB, String nhanxet, String trangthai) {
        this.maHS = maHS;
        this.maNH = maNH;
        this.tenHs = tenHs;
        this.maHanhKiem = maHanhKiem;
        this.maHocLuc = maHocLuc;
        this.diemTB = diemTB;
        this.nhanxet = nhanxet;
        this.trangthai = trangthai;
    }
}
