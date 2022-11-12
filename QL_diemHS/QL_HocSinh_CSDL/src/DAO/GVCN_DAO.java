/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.DatabaseConn;
import Model.GVBM;
import Model.GVCN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minh0
 */
public class GVCN_DAO implements DAO<GVCN>{
    private static final String maGV ="MaGV";
    private static final String maNH ="MaNamHoc";
    private static final String maHK ="MaHocKi";
    private static final String malop ="Malop";
    
    private static String timkiempc="EXEC [dbo].[sp_pcGVCN]\n" +
"		@maNamHoc = ? ,\n" +
"		@maHK = ? ";
    private static String themsuapc="EXEC [dbo].[sp_themsuaGVCN]\n" +
"		@maNamHoc = ? ,\n" +
"		@maHocki = ? ,\n" +
"		@malop = ? ,\n" +
"		@maGV = ? ";
    private static String xoapc="EXEC [dbo].[sp_xoapcGVCN]\n" +
"		@maNamHoc = ? ,\n" +
"		@maHocki = ? ,\n" +
"		@malop = ? ,\n" +
"		@maGV = ? ";
    
    @Override
    public int Them(GVCN t) {
        int check =0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(themsuapc);
            add.setString(1, t.getMaNamHoc());
            add.setString(2, t.getMaHocKi());
            add.setString(3, t.getMalop());
            add.setString(4, t.getMaGV());
            if (add.executeUpdate()>0) {
                check =1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int Sua(GVCN t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Xoa(GVCN t) {
        int check =0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(xoapc);
            add.setString(1, t.getMaNamHoc());
            add.setString(2, t.getMaHocKi());
            add.setString(3, t.getMalop());
            add.setString(4, t.getMaGV());
            if (add.executeUpdate()>0) {
                check =1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public List<GVCN> TìmKiem(GVCN t) {
        List<GVCN> ds=  new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(timkiempc);
            add.setString(1, t.getMaNamHoc());
            add.setString(2, t.getMaHocKi());
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
    public GVCN getT(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GVCN> getALL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GVCN getTObject(ResultSet rs) {
        GVCN gvcn = null;
        try {
            gvcn = new GVCN(rs.getString(maGV), rs.getString(malop), rs.getString(maNH), rs.getString(maHK));
        } catch (Exception e) {
        }
        return gvcn;
    }
    
}
