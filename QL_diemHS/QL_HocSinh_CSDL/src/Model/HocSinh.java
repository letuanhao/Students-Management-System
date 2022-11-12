/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author minh0
 */
public class HocSinh {
    private String MaHS;
    private String SoHieu;
    private String HotenHS;
    private String MaDanToc;
    private String MaChinhSach;
    private String MaTonGiao;
    private String GioiTinh;
    private String DiaChi;
    private String DienThoai;
    private String GhiChu;
    private String TrangThai;
    

    public HocSinh(String MaHS, String SoHieu, String MaDanToc, String MaChínhach, String MaTonGiao, String GioiTinh, String DiaChi, String DienThoai, String GhiChu) {
        this.MaHS = MaHS;
        this.SoHieu = SoHieu;
        this.MaDanToc = MaDanToc;
        this.MaChinhSach = MaChínhach;
        this.MaTonGiao = MaTonGiao;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.DienThoai = DienThoai;
        this.GhiChu = GhiChu;
    }

    public HocSinh(String MaHS, String SoHieu, String MaDanToc, String MaChínhach, String MaTonGiao, String GioiTinh, String DiaChi, String DienThoai, String GhiChu, String TrangThai) {
        this.MaHS = MaHS;
        this.SoHieu = SoHieu;
        this.MaDanToc = MaDanToc;
        this.MaChinhSach = MaChínhach;
        this.MaTonGiao = MaTonGiao;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.DienThoai = DienThoai;
        this.GhiChu = GhiChu;
        this.TrangThai = TrangThai;
    }

    public HocSinh(String MaHS, String SoHieu, String HotenHS, String MaDanToc, String MaChinhSach, String MaTonGiao, String GioiTinh, String DiaChi, String DienThoai, String GhiChu, String TrangThai) {
        this.MaHS = MaHS;
        this.SoHieu = SoHieu;
        this.HotenHS = HotenHS;
        this.MaDanToc = MaDanToc;
        this.MaChinhSach = MaChinhSach;
        this.MaTonGiao = MaTonGiao;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.DienThoai = DienThoai;
        this.GhiChu = GhiChu;
        this.TrangThai = TrangThai;
    }

    public String getHotenHS() {
        return HotenHS;
    }

    public void setHotenHS(String HotenHS) {
        this.HotenHS = HotenHS;
    }

    public String getMaChinhSach() {
        return MaChinhSach;
    }

    public void setMaChinhSach(String MaChinhSach) {
        this.MaChinhSach = MaChinhSach;
    }
    
    
    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
    
    public String getMaHS() {
        return MaHS;
    }

    public void setMaHS(String MaHS) {
        this.MaHS = MaHS;
    }

    public String getSoHieu() {
        return SoHieu;
    }

    public void setSoHieu(String SoHieu) {
        this.SoHieu = SoHieu;
    }

    public String getMaDanToc() {
        return MaDanToc;
    }

    public void setMaDanToc(String MaDanToc) {
        this.MaDanToc = MaDanToc;
    }

    public String getMaTonGiao() {
        return MaTonGiao;
    }

    public void setMaTonGiao(String MaTonGiao) {
        this.MaTonGiao = MaTonGiao;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
}
