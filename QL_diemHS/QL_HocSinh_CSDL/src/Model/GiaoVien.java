package Model;

public class GiaoVien {
    private String maGV;
    private String HoTenGV;
    private String gioitinh;
    private String Diachi;
    private String ChuyenMon;
    private String TrinhDo;
    private String DienThoai;
    private String GhiChu;

    public GiaoVien(String maGV, String HoTenGV, String gioitinh, String Diachi, String ChuyenMon, String TrinhDo, String DienThoai, String GhiChu) {
        this.maGV = maGV;
        this.HoTenGV = HoTenGV;
        this.gioitinh = gioitinh;
        this.Diachi = Diachi;
        this.ChuyenMon = ChuyenMon;
        this.TrinhDo = TrinhDo;
        this.DienThoai = DienThoai;
        this.GhiChu = GhiChu;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getHoTenGV() {
        return HoTenGV;
    }

    public void setHoTenGV(String HoTenGV) {
        this.HoTenGV = HoTenGV;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getChuyenMon() {
        return ChuyenMon;
    }

    public void setChuyenMon(String ChuyenMon) {
        this.ChuyenMon = ChuyenMon;
    }

    public String getTrinhDo() {
        return TrinhDo;
    }

    public void setTrinhDo(String TrinhDo) {
        this.TrinhDo = TrinhDo;
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
