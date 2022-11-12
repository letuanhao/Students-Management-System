/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.DatabaseConn;
import Model.DongHocPhi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minh0
 */
public class DongHP_DAO implements DAO<DongHocPhi>{
    private static final String maNH = "MaNamHoc";
    private static final String maHK = "MaHocKi";
    private static final String maHS = "MaHS";
    private static final String maLop = "Malop";
    private static final String maHP = "MaHocPhi";
    private static final String HP = "HocPhi";
    private static final String dadong="DaDongTien";
    
    private static String themHP="EXEC [dbo].[sp_DongHocPhi_insert]\n" +
"		@MaLop = ? ,\n" +
"		@MaNamhoc = ? ,\n" +
"		@MaHocKi = ? ,\n" +
"		@MaHocPhi = ? ";
    private static String themsuaHP="EXEC [dbo].[sp_themsuaHP_lop]\n" +
"		@MaNamhoc = ? ,\n" +
"		@MaHocki = ? ,\n" +
"		@maHocPhi = ? ,\n" +
"		@MaHocSinh = ? ,\n" +
"		@dadong = ? ";
    private static String dsDongHP="EXEC [dbo].[sp_dsDongHP]\n" +
"		@MaNamhoc = ? ,\n" +
"		@MaHocki = ? ,\n" +
"		@MaLop = ? ";
    private static String xoaHP="EXEC [dbo].[sp_xoaHP]\n" +
"		@MaNamhoc = ? ,\n" +
"		@MaHocki = ? ,\n" +
"		@maHocPhi = ? ,\n" +
"		@MaHocSinh = ? ";

    @Override
    public int Them(DongHocPhi t) {
        int check =0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(themHP);
            add.setString(1, t.getMaNamHoc());
            add.setString(2, t.getMaHocKi());
            add.setString(3, t.getMaHocPhi());
            add.setString(4, t.getMaHS());
            
            if (add.executeUpdate()>0) {
                check =1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int Sua(DongHocPhi t) {
        int check =0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(themsuaHP);
            add.setString(1, t.getMaNamHoc());
            add.setString(2, t.getMaHocKi());
            add.setString(3, t.getMaHocPhi());
            add.setString(4, t.getMaHS());
            add.setBoolean(5, t.isDaDong());
            if (add.executeUpdate()>0) {
                check =1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int Xoa(DongHocPhi t) {
        int check =0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(xoaHP);
            add.setString(1, t.getMaNamHoc());
            add.setString(2, t.getMaHocKi());
            add.setString(3, t.getMaHocPhi());
            add.setString(4, t.getMaHS());
            if (add.executeUpdate()>0) {
                check =1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public List<DongHocPhi> TìmKiem(DongHocPhi t) {
        List<DongHocPhi> ds = new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(dsDongHP);
            add.setString(1, t.getMaNamHoc());
            add.setString(2, t.getMaHocKi());
            add.setString(3, t.getMalop());
            ResultSet rs = add.executeQuery();
            while (rs.next()) {                
                ds.add(getTObject(rs));
            }
        } catch (Exception e) {
        }
        return ds;
    }

    @Override
    public DongHocPhi getT(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DongHocPhi> getALL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DongHocPhi getTObject(ResultSet rs) {
        DongHocPhi dhp = new DongHocPhi("", "", "", "", "", 0, false);
        try {
            dhp = new DongHocPhi(rs.getString(maNH), rs.getString(maHK), rs.getString(maHS), rs.getString(maHP), rs.getString(maLop), rs.getFloat(HP), rs.getBoolean(dadong));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dhp;
    }
    
}
