/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.DatabaseConn;
import Model.DiemHocSinh;
import Model.HocSinhDiem;
import Model.Tongketmon;
import View.DataStatic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minh0
 */
public class HSDiem_DAO implements DAO<HocSinhDiem>{
    private static final String maHS ="MaHS";
    private static final String hoten ="HoTenHS";
    private static final String malop ="Malop";
    private static final String maMH ="MaMonHoc";
    private static final String maNH="MaNamhoc";
    private static final String maHK="MaHocki";
    private static String hsdiemlist ="EXEC [dbo].[sp_HocSinhDiem_list]\n" +
"		@MaNamhoc = ? ,\n" +
"		@MaHocki = ? ,\n" +
"		@MaMon = ? ,\n" +
"		@malop = ? ";
    private DiemHS_DAO dao = new DiemHS_DAO();
    
    @Override
    public int Them(HocSinhDiem t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Sua(HocSinhDiem t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Xoa(HocSinhDiem t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HocSinhDiem> TìmKiem(HocSinhDiem t) {
        List<HocSinhDiem> ds = new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(hsdiemlist);
            add.setString(1, t.getMaNH());
            add.setString(2, t.getMaHK());
            add.setString(3, t.getMaMH());
            add.setString(4, t.getMalop());
            ResultSet rs = add.executeQuery();
            while (rs.next()) {
                HocSinhDiem hsd = getTObject(rs);
                DiemHocSinh dhs = new DiemHocSinh(0, maHS, hsd.getMaMH(), hsd.getMaHS(), hsd.getMaHK(), hsd.getMaNH(), 0);
                //điểm miệng
                dhs.setMadiem(DataStatic.DIEMMIENG);
                List<DiemHocSinh> dsmieng = dao.TìmKiem(dhs);
                hsd.setDiemMieng(dsmieng);
                //điểm 15p
                dhs.setMadiem(DataStatic.DIEM15P);
                List<DiemHocSinh> ds15p = dao.TìmKiem(dhs);
                hsd.setDiem15(ds15p);
                //điểm GK
                dhs.setMadiem(DataStatic.DIEMGK);
                List<DiemHocSinh> dsGK = dao.TìmKiem(dhs);
                hsd.setDiemGK(dsGK);
                //điểm CK
                dhs.setMadiem(DataStatic.DIEMCK);
                List<DiemHocSinh> dsCK = dao.TìmKiem(dhs);
                hsd.setDiemHK(dsCK);
                //điểm thi lại
                dhs.setMadiem(DataStatic.DIEMTHILAI);
                List<DiemHocSinh> dsThilai = dao.TìmKiem(dhs);
                hsd.setDiemThiLai(dsThilai);
                //Tổng kết môn
                TKMon_DAO mon_DAO = new TKMon_DAO();
                Tongketmon tkmon = mon_DAO.getTKMon(new Tongketmon(hsd.getMaHS(), hsd.getMaMH(), hsd.getMaNH(), hsd.getMaHK(), 0, 0, 0, 0, 0));
                hsd.setTKmon(tkmon);
                
                ds.add(hsd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Override
    public HocSinhDiem getT(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HocSinhDiem> getALL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HocSinhDiem getTObject(ResultSet rs) {
        HocSinhDiem hsd = new HocSinhDiem("", "", "","", "", "");
        try {
            hsd = new HocSinhDiem(rs.getString(maHS), rs.getString(malop), rs.getString(hoten),rs.getString(maMH), rs.getString(maNH), rs.getString(maHK));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hsd;
    }
    
}
