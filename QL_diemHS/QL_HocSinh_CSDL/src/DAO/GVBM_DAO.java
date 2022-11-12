/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.DatabaseConn;
import Model.GVBM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minh0
 */
public class GVBM_DAO implements DAO<GVBM>{
    private static final String maGV ="MaGV";
    private static final String maNH ="MaNamHoc";
    private static final String maHK ="MaHocKi";
    private static final String malop ="Malop";
    private static final String mamon ="MaMonHoc";
    
    private static String themsua="EXEC [dbo].[sp_themsuaGVBM]\n" +
"		@maNamHoc = ? ,\n" +
"		@maHK = ? ,\n" +
"		@malop = ? ,\n" +
"		@maMonHoc = ? ,\n" +
"		@maGV = ? ";
    private static String timgvbm="EXEC [dbo].[sp_pcGVBM]\n" +
"		@maNamHoc = ? ,\n" +
"		@maHK = ? ,\n" +
"		@malop = ? ";
    private static String xoagvbm="EXEC [dbo].[sp_xoapcGVBM]\n" +
"		@maNamHoc = ? ,\n" +
"		@maHK = ? ,\n" +
"		@malop = ? ,\n" +
"		@maMonHoc = ? ,\n" +
"		@maGV = ? ";
    

    @Override
    public int Them(GVBM t) {
        int check =0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(themsua);
            add.setString(1, t.getMaNamHoc());
            add.setString(2, t.getMaHocKi());
            add.setString(3, t.getMalop());
            add.setString(4, t.getMaMonHoc());
            add.setString(5, t.getMaGV());
            if (add.executeUpdate()>0) {
                check =1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int Sua(GVBM t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Xoa(GVBM t) {
        int check =0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(xoagvbm);
            add.setString(1, t.getMaNamHoc());
            add.setString(2, t.getMaHocKi());
            add.setString(3, t.getMalop());
            add.setString(4, t.getMaMonHoc());
            add.setString(5, t.getMaGV());
            if (add.executeUpdate()>0) {
                check =1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public List<GVBM> TìmKiem(GVBM t) {
        List<GVBM> ds=  new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(timgvbm);
            add.setString(1, t.getMaNamHoc());
            add.setString(2, t.getMaHocKi());
            add.setString(3, t.getMalop());
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
    public GVBM getT(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GVBM> getALL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GVBM getTObject(ResultSet rs) {
        GVBM gvbm = null;
        try {
            gvbm = new GVBM(rs.getString(malop), rs.getString(maNH),rs.getString(maHK),rs.getString(maGV) ,rs.getString(mamon));
        } catch (Exception e) {
        }
        return gvbm;
    }
    
}
