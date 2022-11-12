package DAO;

import Connection.DatabaseConn;
import Model.HocSinh;
import Model.HocSinhLop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class XepLop_DAO implements DAO<HocSinhLop>{

    private static final String maHS="MaHS";
    private static final String sohieu="SoHieu";
    private static final String hoten ="HoTenHS";
    private static final String dantoc="MaDanToc";
    private static final String chinhsach="MaChinhSach";
    private static final String tongiao="MaTonGiao";
    private static final String gioitinh="GioiTinh";
    private static final String diachi="DiaChi";
    private static final String dienthoai="DienThoai";
    private static final String ghichu="GhiChu";
    private static final String trangthai="trangthai";
    
    private static String tk_hs_lop ="EXEC [dbo].[sp_tk_xeplop]\n" +
"		@hschuacolop = ? ,\n" +
"		@maNamHoc = ? ,\n" +
"		@maHK = ? ,\n" +
"		@malop = ? ,\n" +
"		@tangdan = ? ,\n" +
"		@loaiHS = ? ,\n" +
"		@maNamHoc2 = ? ,\n" +
"		@maHK2 = ? ";
    private static String themsuahslop= "EXEC [dbo].[sp_capnhat_dslop]\n" +
"		@MaHS = ? ,\n" +
"		@MaLop = ? ,\n" +
"		@MaNamhoc = ? ,\n" +
"		@MaHocKi = ? ";
    private static String xoaHSlop ="EXEC [dbo].[sp_Xoa_dslop]\n" +
"		@MaHS = ? ,\n" +
"		@MaNamhoc = ? ,\n" +
"		@MaHocKi = ? ";
    
    @Override
    public int Them(HocSinhLop t) {
        int check =0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(themsuahslop);
            add.setString(1, t.getMaHS());
            add.setString(2, t.getMaLop());
            add.setString(3, t.getMaNamHoc());
            add.setString(4, t.getMaHocKy());
            
            if (add.executeUpdate()>0) {
                check =1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int Sua(HocSinhLop t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Xoa(HocSinhLop t) {
        int check =0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(xoaHSlop);
            add.setString(1, t.getMaHS());
            add.setString(2, t.getMaNamHoc());
            add.setString(3, t.getMaHocKy());
            
            if (add.executeUpdate()>0) {
                check =1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public List<HocSinhLop> TìmKiem(HocSinhLop t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HocSinhLop getT(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HocSinhLop> getALL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HocSinhLop getTObject(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<HocSinh> tkHSlop(boolean hschuacolop, String maNamHoc, String maHK, String malop,
            boolean tangdan, boolean loaiHS, String maNamHoc2, String maHK2){
        List<HocSinh> dshs = new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(tk_hs_lop);
            add.setBoolean(1, hschuacolop);
            add.setString(2, maNamHoc);
            add.setString(3, maHK);
            add.setString(4, malop);
            add.setBoolean(5, tangdan);
            add.setBoolean(6, loaiHS);
            add.setString(7, maNamHoc2);
            add.setString(8, maHK2);
            ResultSet rs = add.executeQuery();
            while (rs.next()) {                
                dshs.add(getHocSinh(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dshs;
    }
    private HocSinh getHocSinh(ResultSet rs) throws SQLException{
        HocSinh hs = new HocSinh(
                rs.getString(maHS)
                , rs.getString(sohieu)
                , rs.getString(hoten)
                , rs.getString(dantoc)
                , rs.getString(chinhsach)
                , rs.getString(tongiao)
                , rs.getString(gioitinh)
                , rs.getString(diachi)
                , rs.getString(dienthoai)
                , rs.getString(ghichu)
                , rs.getString(trangthai));
        return  hs;
    }
}
