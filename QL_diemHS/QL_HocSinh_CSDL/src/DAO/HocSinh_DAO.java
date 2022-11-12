/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.DatabaseConn;
import Model.HocSinh;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author minh0
 */
public class HocSinh_DAO implements DAO<HocSinh>{
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
    
    private static String themHS="EXEC [dbo].[sp_HocSinh_insert]\n" +
"		@MaHocSinh = ? ,\n" +
"		@Sohieu = ? ,\n" +
"		@HotenHS = ? ,\n" +
"		@MaDT = ? ,\n" +
"		@MaCS = ? ,\n" +
"		@MaTG = ? ,\n" +
"		@Gioitinh = ?,\n" +
"		@Diachi = ? ,\n" +
"		@SDT = ? ,\n" +
"		@GhiChu = ? ,\n" +
"		@TrangThai = ? ";
    
    private static String suaHS="EXEC [dbo].[sp_HocSinh_update]\n" +
"		@MaHocSinh = ? ,\n" +
"		@Sohieu = ? ,\n" +
"		@HotenHS = ? ,\n" +
"		@MaDT = ? ,\n" +
"		@MaCS = ? ,\n" +
"		@MaTG = ? ,\n" +
"		@Gioitinh = ? ,\n" +
"		@Diachi = ? ,\n" +
"		@SDT = ? ,\n" +
"		@GhiChu = ? ,\n" +
"		@TrangThai = ? ";
    private static String xoaHS=" DELETE FROM HocSinh WHERE "+maHS+" = ? ";
    private static String timHS="";
    private static String getAllHS=" SELECT * FROM HocSinh ";
    private static String getHS =" SELECT * FROM HocSinh WHERE MaHS = ? ";
    private static String getmaHSmax ="SELECT [dbo].[fn_getmax_maHS]( ? ) as maxHS";
    public int getmaHSmax(String maNH){
        int so =0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(getmaHSmax);
            add.setString(1, maNH);
            ResultSet rs = add.executeQuery();
            while (rs.next()) {                
                so = rs.getInt("maxHS");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return so;
    }
    @Override
    public int Them(HocSinh t) {
        int check =0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(themHS);
            add.setString(1, t.getMaHS());
            add.setString(2, t.getSoHieu());
            add.setString(3, t.getHotenHS());
            add.setString(4, t.getMaDanToc());
            add.setString(5, t.getMaChinhSach());
            add.setString(6, t.getMaTonGiao());
            add.setString(7, t.getGioiTinh());
            add.setString(8, t.getDiaChi());
            add.setString(9, t.getDienThoai());
            add.setString(10, t.getGhiChu());
            add.setString(11, t.getTrangThai());
            if (add.executeUpdate()>0) {
                check =1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int Sua(HocSinh t) {
        int check =0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(suaHS);
            add.setString(1, t.getMaHS());
            add.setString(2, t.getSoHieu());
            add.setString(3, t.getHotenHS());
            add.setString(4, t.getMaDanToc());
            add.setString(5, t.getMaChinhSach());
            add.setString(6, t.getMaTonGiao());
            add.setString(7, t.getGioiTinh());
            add.setString(8, t.getDiaChi());
            add.setString(9, t.getDienThoai());
            add.setString(10, t.getGhiChu());
            add.setString(11, t.getTrangThai());
            if (add.executeUpdate()>0) {
                check =1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int Xoa(HocSinh t) {
        int check =0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(xoaHS);
            add.setString(1, t.getMaHS());
            if (add.executeUpdate()>0) {
                check =1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public List<HocSinh> TìmKiem(HocSinh t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HocSinh getT(String ma) {
        HocSinh hs = new HocSinh("", "", "", "","", "", "", "", "", "", "");
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(getHS);
            add.setString(1, ma);
            ResultSet rs = add.executeQuery();
            if (rs.next()) {                
                hs = getHocSinh(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hs;
    }

    @Override
    public List<HocSinh> getALL() {
        List<HocSinh> dshs = new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(getAllHS);
            ResultSet rs = add.executeQuery();
            while (rs.next()) {                
                dshs.add(getHocSinh(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dshs;
    }

    @Override
    public HocSinh getTObject(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
