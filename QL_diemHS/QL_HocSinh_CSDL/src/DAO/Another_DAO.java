package DAO;

import Connection.DatabaseConn;
import Model.DiemTKMHnam;
import Model.GVBM;
import Model.GVCN;
import Model.HanhKiem;
import Model.HocLuc;
import Model.another.DTB_HS;
import Model.another.DanhGiaCN;
import Model.another.ThongkeHK;
import Model.another.ThongkeHL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Another_DAO {

    private static final String maHL = "MaHocLuc";
    private static final String maHK = "MaHanhKiem";
    private static final String HL = "HocLuc";
    private static final String HK = "HanhKiem";
    private static String getallHL = "SELECT * FROM HocLuc";
    private static String getallHK = "SELECT * FROM HanhKiem";

    private static String dsdiemTKMHnam = "EXEC [dbo].[sp_dsdiemTKCN]\n"
            + "		@MaNamhoc = ? ,\n"
            + "		@malop = ? ,\n"
            + "		@MaMon = ? ";

    private static String dsDTBHStheoHK = "EXEC [dbo].[sp_dsDTBHStheoHK]\n"
            + "		@maNH = ? ,\n"
            + "		@maHK = ? ,\n"
            + "		@maHS = ? ";
    private static String dsDTBHStheoNH = "EXEC [dbo].[sp_dsDTBHStheoNH]\n"
            + "		@maNH = ? ,\n"
            + "		@maHS = ? ";

    private static String dsTKCN = "EXEC [dbo].[sp_dsTK_CN]\n"
            + "		@maNH = ? ,\n"
            + "		@malop = ? ";

    private static String suaTKCN = "EXEC [dbo].[sp_suadanhgiaCN]\n"
            + "		@MaNamhoc = ? ,\n"
            + "		@MaHocki = '02' ,\n"
            + "		@maHS = ? ,\n"
            + "		@maHanhKiem = ? ,\n"
            + "		@nhanxet = ? ,\n"
            + "		@trangthai = ? ";

    public List<HocLuc> getAllHocLuc() {
        List<HocLuc> ds = new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(getallHL);
            while (rs.next()) {
                ds.add(new HocLuc(rs.getString(maHL), rs.getString(HL)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public List<HanhKiem> getAllHanhKiem() {
        List<HanhKiem> ds = new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(getallHK);
            while (rs.next()) {
                ds.add(new HanhKiem(rs.getString(maHK), rs.getString(HK)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public List<DiemTKMHnam> dsDiemTKMHnam(String maNH, String malop, String mamon) {
        List<DiemTKMHnam> ds = new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(dsdiemTKMHnam);
            add.setString(1, maNH);
            add.setString(2, malop);
            add.setString(3, mamon);
            ResultSet rs = add.executeQuery();

            while (rs.next()) {
                //System.out.println(rs.getString(1));
                ds.add(new DiemTKMHnam(rs.getString(1), rs.getString(2), rs.getFloat(4)));
            }
        } catch (Exception e) {
        }
        return ds;
    }

    public List<DTB_HS> dsDTBHStheoHK(String maHS, String maNH, String maHK) {
        List<DTB_HS> ds = new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(dsDTBHStheoHK);
            add.setString(1, maNH);
            add.setString(2, maHK);
            add.setString(3, maHS);
            ResultSet rs = add.executeQuery();

            while (rs.next()) {
                //System.out.println(rs.getString(1));
                ds.add(new DTB_HS(rs.getString(1), rs.getFloat(2),rs.getInt(3),rs.getInt(4),rs.getInt(5)));
            }
        } catch (Exception e) {
        }
        return ds;
    }

    public List<DTB_HS> dsDTBHStheoNH(String maNH, String maHS) {
        List<DTB_HS> ds = new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(dsDTBHStheoNH);
            add.setString(1, maNH);
            add.setString(2, maHS);
            ResultSet rs = add.executeQuery();

            while (rs.next()) {
                //System.out.println(rs.getString(1));
                ds.add(new DTB_HS(rs.getString(1), rs.getFloat(2)));
            }
        } catch (Exception e) {
        }
        return ds;
    }

    public List<DanhGiaCN> danhGiaCNs(String malop, String maNH) {
        List<DanhGiaCN> ds = new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(dsTKCN);
            add.setString(1, maNH);
            add.setString(2, malop);
            ResultSet rs = add.executeQuery();

            while (rs.next()) {
                //System.out.println(rs.getString(1));
                ds.add(new DanhGiaCN(rs.getString(1), rs.getString(2), rs.getString(8), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return ds;
    }

    public int SuaDGHSCN(DanhGiaCN t) {
        int check = 0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(suaTKCN);
            add.setString(1, t.maNH);
            add.setString(2, t.maHS);
            add.setString(3, t.maHanhKiem);
            add.setString(4, t.nhanxet);
            add.setString(5, t.trangthai);
            if (add.executeUpdate() > 0) {
                check = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    private static String checkGVBM = "SELECT [dbo].[check_GV_MH]( ? , ? , ? , ? , ? ) as checkgv";

    public int checkGVBM(String maGV, String maNH, String maHK, String maMH, String malop) {
        int check = 0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(checkGVBM);
            add.setString(1, maGV);
            add.setString(2, maNH);
            add.setString(3, maHK);
            add.setString(4, maMH);
            add.setString(5, malop);
            ResultSet rs = add.executeQuery();
            if (rs.next()) {
                check = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    private static String dsGVBMgv = "EXEC [dbo].[sp_dspcMH_GV]\n"
            + "		@maGV = ? ,\n"
            + "		@maNH = ? ,\n"
            + "		@maHK = ? ";
    public List<GVBM> dspcGV_MH(String maGV,String maNH,String maHK){
        List<GVBM> ds = new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(dsGVBMgv);
            add.setString(1, maGV);
            add.setString(2, maNH);
            add.setString(3, maHK);
            ResultSet rs = add.executeQuery();

            while (rs.next()) {
                ds.add(new GVBM(rs.getString("Malop"), maNH, maHK, rs.getString("MaGV"),rs.getString("MaMonHoc")));
            }
        } catch (Exception e) {
        }
        return ds;
    }
    private static String dsGVCNgv = "EXEC [dbo].[sp_dsGVCN_GV]\n"
            + "		@maGV = ? ,\n"
            + "		@maNH = ? ,\n"
            + "		@maHK = ? ";
    
    public List<GVCN> pcgvcn(String maGV,String maNH,String maHK){
        List<GVCN> ds = new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(dsGVCNgv);
            add.setString(1, maGV);
            add.setString(2, maNH);
            add.setString(3, maHK);
            ResultSet rs = add.executeQuery();

            while (rs.next()) {
                ds.add(new GVCN(rs.getString("MaGV"), rs.getString("Malop"), maNH, maHK));
            }
        } catch (Exception e) {
        }
        return ds;
    }
    
    
    
    private static String checkGVCN = "SELECT [dbo].[checkGVCN]( ? , ? , ? , ? ) as checkgv";
    public int checkGVCN(String maGV,String maNH,String maHK,String malop){
        int check = 0;
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(checkGVCN);
            add.setString(1, maGV);
            add.setString(2, maNH);
            add.setString(3, maHK);
            add.setString(4, malop);
            ResultSet rs = add.executeQuery();
            if (rs.next()) {
                check = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    
    ////////////////thống kê
    private static String thongkeHL ="EXEC [sp_thongkeHL]\n" +
"		@maNamhoc = ? ,\n" +
"		@maHocki = ? ,\n" +
"		@canam = ? ";
    public List<ThongkeHL> thongkeHLs(String maNH,String maHK,boolean canam){
        List<ThongkeHL> ds = new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(thongkeHL);
            add.setString(1, maNH);
            add.setString(2, maHK);
            add.setBoolean(3, canam);
            ResultSet rs = add.executeQuery();

            while (rs.next()) {
                ds.add(new ThongkeHL(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6),rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return ds;
    }
    private static String thongkeHK="EXEC [dbo].[sp_thongkeHK]\n" +
"		@maNamhoc = ? ,\n" +
"		@maHocki = ? ,\n" +
"		@canam = ? ";
    public List<ThongkeHK> dsThongkeHK(String maNH,String maHK,boolean canam){
        List<ThongkeHK> ds = new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            PreparedStatement add = c.prepareStatement(thongkeHK);
            add.setString(1, maNH);
            add.setString(2, maHK);
            add.setBoolean(3, canam);
            ResultSet rs = add.executeQuery();

            while (rs.next()) {
                ds.add(new ThongkeHK(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
            }
        } catch (Exception e) {
        }
        return ds;
    }
    public static void main(String[] args) {
        Another_DAO dao = new Another_DAO();
        List<DanhGiaCN> ds = dao.danhGiaCNs("101", "1920");
        System.out.println(ds.size());

    }
}
