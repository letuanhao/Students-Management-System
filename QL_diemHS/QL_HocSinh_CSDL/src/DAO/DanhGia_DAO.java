/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.DatabaseConn;
import Model.DanhGiaHS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minh0
 */
public class DanhGia_DAO implements DAO<DanhGiaHS> {

    private static final String mahs = "MaHS";
    private static final String mahanhkiem = "MaHanhKiem";
    private static final String mahocluc = "MaHocLuc";
    private static final String dtbhk = "DiemTB_HK";
    private static final String tenHS ="HoTenHS";
    
    
    private static String dshslop = "EXEC [dbo].[sp_dsHSlop]\n"
            + "		@MaNamhoc = ? ,\n"
            + "		@MaHocki = ? ,\n"
            + "		@malop = ? ";
    private static String ttdanhgia = "EXEC [dbo].[sp_TTDanhgia]\n"
            + "		@MaNamhoc = ? ,\n"
            + "		@MaHocki = ? ,\n"
            + "		@maHS = ? ";
    private static String sua = "EXEC [dbo].[sp_danhgiaHSlop_update]\n"
            + "		@MaNamhoc = ? , \n"
            + "		@MaHocki = ? , \n"
            + "		@maHS = ? , \n"
            + "		@maHanhKiem = ? ";

    @Override
    public int Them(DanhGiaHS t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Sua(DanhGiaHS t) {
        int check =0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(sua);
            add.setString(1, t.getMaNH());
            add.setString(2, t.getMaHK());
            add.setString(3, t.getMaHS());
            add.setString(4, t.getMaHanhKiem());
            
            if ( add.executeUpdate() > 0) {
                check =1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int Xoa(DanhGiaHS t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DanhGiaHS> TìmKiem(DanhGiaHS t) {
        List<DanhGiaHS> ds=  new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(dshslop);
            add.setString(1, t.getMaNH());
            add.setString(2, t.getMaHK());
            add.setString(3, t.getMalop());
            ResultSet rs = add.executeQuery();
            while (rs.next()) {
                DanhGiaHS dghs = getDanhGiaHS(new DanhGiaHS(rs.getString(mahs), rs.getString(tenHS),t.getMalop(), t.getMaNH(), t.getMaHK(), mahanhkiem, mahocluc, 0));
                dghs.setMaHS(rs.getString(mahs));
                dghs.setTenHS(rs.getString(tenHS));
                dghs.setMalop(t.getMalop());
                dghs.setMaNH(t.getMaNH());
                dghs.setMaHK(t.getMaHK());
                
                ds.add(dghs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Override
    public DanhGiaHS getT(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DanhGiaHS> getALL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DanhGiaHS getTObject(ResultSet rs) {
        DanhGiaHS danhGiaHS = new DanhGiaHS("", "", "", "", "", "", "", 0);
        try {
            danhGiaHS = new DanhGiaHS(rs.getString(mahs), "", "", "", "", rs.getString(mahanhkiem), rs.getString(mahocluc), rs.getFloat(dtbhk));
        } catch (Exception e) {
        }
        return danhGiaHS;
    }
    
    public DanhGiaHS getDanhGiaHS(DanhGiaHS t){
        DanhGiaHS danhGiaHS = new DanhGiaHS("", "", "", "", "", "", "", 0);
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(ttdanhgia);
            add.setString(1, t.getMaNH());
            add.setString(2, t.getMaHK());
            add.setString(3, t.getMaHS());
            ResultSet rs = add.executeQuery();
            if (rs.next()) {
                danhGiaHS = getTObject(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhGiaHS;
    }
}
