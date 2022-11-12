package Model;

public class Tongketmon {
    private String maHS;
    private String maMH;
    private String maNH;
    private String maHK;
    private float DiemTB;
    private float DiemQT;
    private int TongBH;
    private int BHphep;
    private int BHKphep;

    public Tongketmon(String maHS, String maMH, String maNH, String maHK, float DiemTB, float DiemQT, int TongBH, int BHphep, int BHKphep) {
        this.maHS = maHS;
        this.maMH = maMH;
        this.maNH = maNH;
        this.maHK = maHK;
        this.DiemTB = DiemTB;
        this.DiemQT = DiemQT;
        this.TongBH = TongBH;
        this.BHphep = BHphep;
        this.BHKphep = BHKphep;
    }

    public String getMaHS() {
        return maHS;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getMaNH() {
        return maNH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public String getMaHK() {
        return maHK;
    }

    public void setMaHK(String maHK) {
        this.maHK = maHK;
    }

    public float getDiemTB() {
        return DiemTB;
    }

    public void setDiemTB(float DiemTB) {
        this.DiemTB = DiemTB;
    }

    public float getDiemQT() {
        return DiemQT;
    }

    public void setDiemQT(float DiemQT) {
        this.DiemQT = DiemQT;
    }

    public int getTongBH() {
        return TongBH;
    }

    public void setTongBH(int TongBH) {
        this.TongBH = TongBH;
    }

    public int getBHphep() {
        return BHphep;
    }

    public void setBHphep(int BHphep) {
        this.BHphep = BHphep;
    }

    public int getBHKphep() {
        return BHKphep;
    }

    public void setBHKphep(int BHKphep) {
        this.BHKphep = BHKphep;
    }
    
    
}
