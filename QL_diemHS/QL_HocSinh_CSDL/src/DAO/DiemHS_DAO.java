package DAO;

import Connection.DatabaseConn;
import Model.DiemHocSinh;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DiemHS_DAO implements DAO<DiemHocSinh>{
    private static final String stt="STT";
    private static final String madiem="MaDiem";
    private static final String maMH ="MaMonHoc";
    private static final String maHS= "MaHS";
    private static final String maNH="MaNamhoc";
    private static final String maHK="MaHocki";
    private static final String diem="DiemSo";
    private static String them= "EXEC [dbo].[sp_DiemHocSinh_insert]\n" +
"		@MaNamhoc = ?,\n" +
"		@MaHocki = ? ,\n" +
"		@MaHocSinh = ? ,\n" +
"		@MaDiem = ? ,\n" +
"		@MaMon = ? ,\n" +
"		@DiemSo = ? ";
    
    private static String sua ="EXEC [dbo].[sp_DiemHocSinh_update]\n" +
"		@STT = ? ,\n" +
"		@DiemSo = ? ";
    private static String xoa ="EXEC [dbo].[sp_DiemHocSinh_delete]\n" +
"		@STT = ? ";
    private static String diemlist = "EXEC [dbo].[sp_DiemHocSinh_list]\n" +
"		@MaNamhoc = ? ,\n" +
"		@MaHocki = ? ,\n" +
"		@MaHocSinh = ? ,\n" +
"		@MaDiem = ? ,\n" +
"		@MaMon = ? ";

    @Override
    public int Them(DiemHocSinh t) {
        int check =0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(them);
            add.setString(1, t.getMaNH());
            add.setString(2, t.getMaHK());
            add.setString(3, t.getMaHocSinh());
            add.setString(4, t.getMadiem());
            add.setString(5, t.getMamon());
            add.setFloat(6, t.getDiemSo());
            if (add.executeUpdate()>0) {
                check =1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int Sua(DiemHocSinh t) {
        int check =0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(sua);
            add.setInt(1, t.getSTT());
            add.setFloat(2, t.getDiemSo());
            if (add.executeUpdate()>0) {
                check =1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int Xoa(DiemHocSinh t) {
        int check =0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(xoa);
            add.setInt(1, t.getSTT());
            if (add.executeUpdate()>0) {
                check =1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public List<DiemHocSinh> TìmKiem(DiemHocSinh t) {
        List<DiemHocSinh> ds = new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(diemlist);
            add.setString(1, t.getMaNH());
            add.setString(2, t.getMaHK());
            add.setString(3, t.getMaHocSinh());
            add.setString(4, t.getMadiem());
            add.setString(5, t.getMamon());
            ResultSet rs = add.executeQuery();
            while (rs.next()) {                
                ds.add(getTObject(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Override
    public DiemHocSinh getT(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DiemHocSinh> getALL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DiemHocSinh getTObject(ResultSet rs) {
        DiemHocSinh dhs = new DiemHocSinh(0, 0);
        try {
            dhs = new DiemHocSinh(rs.getInt(stt), rs.getString(madiem), rs.getString(maMH)
                    , rs.getString(maHS), rs.getString(maHK), rs.getString(maNH), rs.getFloat(diem));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dhs;
    }
    
}
