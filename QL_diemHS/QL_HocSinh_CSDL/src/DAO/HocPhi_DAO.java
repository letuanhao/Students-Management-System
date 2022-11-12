package DAO;

import Connection.DatabaseConn;
import Model.HocPhi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HocPhi_DAO implements DAO<HocPhi>{
    private static final String ma ="MaHocPhi";
    private static final String HP ="HocPhi";
    
    private static String getall="SELECT * FROM HocPhi";

    @Override
    public int Them(HocPhi t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Sua(HocPhi t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Xoa(HocPhi t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HocPhi> TìmKiem(HocPhi t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HocPhi getT(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HocPhi> getALL() {
        List<HocPhi> ds = new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(getall);
            while(rs.next()){
                ds.add(getTObject(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Override
    public HocPhi getTObject(ResultSet rs) {
        HocPhi hp = new HocPhi("", 0);
        try {
            hp = new HocPhi(rs.getString(ma), rs.getFloat(HP));
        } catch (Exception e) {
        }
        return hp;
    }
    
    
}
