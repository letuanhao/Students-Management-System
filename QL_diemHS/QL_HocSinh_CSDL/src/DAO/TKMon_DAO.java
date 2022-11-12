/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.DatabaseConn;
import Model.Tongketmon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minh0
 */
public class TKMon_DAO implements DAO<Tongketmon>{
    private static final String maHS ="MaHS";
    private static final String maMH ="MaMonHoc";
    private static final String maNH ="maNH";
    private static final String maHK ="maHK";
    private static final String DTBHK ="DiemTongKet";
    private static final String DTBQT ="TBthanhPhan";
    private static final String tsBH="TS_buoi_hoc";
    private static final String tsBP="TS_buoi_P";
    private static final String tsBKP="TS_buoi_KP";
    
    private static String getTT ="EXEC [dbo].[sp_dsTKmon]\n" +
"		@MaNamhoc = ? ,\n" +
"		@MaHocki = ? ,\n" +
"		@MaHS = ? ,\n" +
"		@MaMon = ? ";
    private static String suaTKmon ="EXEC [dbo].[sp_TKmon_update]\n" +
"		@MaNamhoc = ? ,\n" +
"		@MaHocki = ? ,\n" +
"		@MaHS = ? ,\n" +
"		@MaMon = ? ,\n" +
"		@tongBH = ? ,\n" +
"		@tongBP = ? ,\n" +
"		@tongBKP = ? ";
    @Override
    public int Them(Tongketmon t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Sua(Tongketmon t) {
        int check =0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(suaTKmon);
            add.setString(1, t.getMaNH());
            add.setString(2, t.getMaHK());
            add.setString(3, t.getMaHS());
            add.setString(4, t.getMaMH());
            add.setInt(5, t.getTongBH());
            add.setInt(6, t.getBHphep());
            add.setInt(7, t.getBHKphep());
            if (add.executeUpdate() > 0) {
                check =1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int Xoa(Tongketmon t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tongketmon> TìmKiem(Tongketmon t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tongketmon getT(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tongketmon> getALL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tongketmon getTObject(ResultSet rs) {
        Tongketmon tongketmon = new Tongketmon("", "", "", "", -1, -1, -1, -1, -1);
        try {
            tongketmon = new Tongketmon(rs.getString(maHS)
                    , rs.getString(maMH)
                    , rs.getString(maNH)
                    , rs.getString(maHK)
                    , rs.getFloat(DTBHK)
                    , rs.getFloat(DTBQT)
                    , rs.getInt(tsBH)
                    , rs.getInt(tsBP)
                    , rs.getInt(tsBKP));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return tongketmon;
    }
    public Tongketmon getTKMon(Tongketmon t){
        Tongketmon tongketmon = new Tongketmon("", "", "", "", -1, -1, -1, -1, -1);
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(getTT);
            add.setString(1, t.getMaNH());
            add.setString(2, t.getMaHK());
            add.setString(3, t.getMaHS());
            add.setString(4, t.getMaMH());
            ResultSet rs = add.executeQuery();
            if (rs.next()) {
                tongketmon = getTObject(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tongketmon;
    }
}
