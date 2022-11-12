/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.DatabaseConn;
import Model.GiaoVien;
import Model.HocSinh;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minh0
 */
public class GiaoVien_DAO implements DAO<GiaoVien>{
    private static final String maGV ="MaGV";
    private static final String hoten="HoTenGV";
    private static final String gioitinh="GioiTinh";
    private static final String diachi="DiaChi";
    private static final String chuyenmon ="ChuyenMon";
    private static final String trinhdo ="TrinhDo";
    private static final String dienthoai="DienThoai";
    private static final String ghichu="GhiChu";

    private static String themGV =" EXEC [dbo].[sp_themTTGV]\n" +
"		@maGV = ?,\n" +
"		@HoTenGV = ? ,\n" +
"		@gioitinh = ? ,\n" +
"		@Diachi = ? ,\n" +
"		@TrinhDo = ? ,\n" +
"		@ChuyenMon = ? ,\n" +
"		@SDT = ? ,\n" +
"		@GhiChu = ? ";
    private static String suaGV=" EXEC [dbo].[sp_SuaTTGV]\n" +
"		@maGV = ? ,\n" +
"		@HoTenGV = ? ,\n" +
"		@gioitinh = ? ,\n" +
"		@Diachi = ? ,\n" +
"		@TrinhDo = ? ,\n" +
"		@ChuyenMon = ? ,\n" +
"		@SDT = ? ,\n" +
"		@GhiChu = ? ";
    private static String xoaGV=" EXEC [dbo].[sp_XoaGiaoVien] @maGV = ? ";
    
    private static String timkiem="EXEC [dbo].[sp_timkiemGV]\n" +
"		@maGV = ? ,\n" +
"		@hotenGV = ? ,\n" +
"		@chuyenmon = ? ,\n" +
"		@trinhdo = ? ";
    private static String getone=" SELECT * FROM GiaoVien WHERE MaGV = ? ";
    private static String getall=" SELECT * FROM GiaoVien ";
    private static String maGVmax =" SELECT [dbo].[fn_getmax_maGV]() as sttGV ";
    @Override
    public int Them(GiaoVien t) {
        int check =0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(themGV);
            add.setString(1, t.getMaGV());
            add.setString(2, t.getHoTenGV());
            add.setString(3, t.getGioitinh());
            add.setString(4, t.getDiachi());
            add.setString(5, t.getTrinhDo());
            add.setString(6, t.getChuyenMon());
            add.setString(7, t.getDienThoai());
            add.setString(8, t.getGhiChu());
            if (add.executeUpdate()>0) {
                check =1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int Sua(GiaoVien t) {
        int check =0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(suaGV);
            add.setString(1, t.getMaGV());
            add.setString(2, t.getHoTenGV());
            add.setString(3, t.getGioitinh());
            add.setString(4, t.getDiachi());
            add.setString(5, t.getTrinhDo());
            add.setString(6, t.getChuyenMon());
            add.setString(7, t.getDienThoai());
            add.setString(8, t.getGhiChu());
            if (add.executeUpdate()>0) {
                check =1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int Xoa(GiaoVien t) {
        int check =0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(xoaGV);
            add.setString(1, t.getMaGV());
            if (add.executeUpdate()>0) {
                check =1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public List<GiaoVien> TìmKiem(GiaoVien t) {
        List<GiaoVien> dshs = new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(timkiem);
            add.setString(1, "%"+t.getMaGV()+"%");
            add.setString(2, "%"+t.getHoTenGV()+"%");
            add.setString(3, "%"+t.getChuyenMon()+"%");
            add.setString(4, "%"+t.getTrinhDo()+"%");
            ResultSet rs = add.executeQuery();
            while (rs.next()) {                
                dshs.add(getTObject(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dshs;
    }

    @Override
    public GiaoVien getT(String ma) {
        GiaoVien gv = new GiaoVien("", "", "", "", "", "", "", "");
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(getone);
            add.setString(1, ma);
            ResultSet rs = add.executeQuery();
            if (rs.next()) {                
                gv = getTObject(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gv;
    }

    @Override
    public List<GiaoVien> getALL() {
        List<GiaoVien> dshs = new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(getall);
            ResultSet rs = add.executeQuery();
            while (rs.next()) {                
                dshs.add(getTObject(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dshs;
    }

    @Override
    public GiaoVien getTObject(ResultSet rs) {
        GiaoVien gv = null;
        try {
            gv = new GiaoVien(rs.getString(maGV), rs.getString(hoten), rs.getString(gioitinh), 
                    rs.getString(diachi), rs.getString(chuyenmon), rs.getString(trinhdo),
                    rs.getString(dienthoai) ,rs.getString(ghichu));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gv;
    }
    
    public int getmaGVmax(){
        int so =0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(maGVmax);
            ResultSet rs = add.executeQuery();
            while (rs.next()) {                
                so = rs.getInt("sttGV");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return so;
    }
    
}
