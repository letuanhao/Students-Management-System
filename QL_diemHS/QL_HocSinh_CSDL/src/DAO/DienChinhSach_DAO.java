/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.DatabaseConn;
import Model.DienChinhSach;
import Model.TonGiao;
import java.sql.ResultSet;
import java.util.List;
import View.DataStatic;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author minh0
 */
public class DienChinhSach_DAO implements DAO<DienChinhSach>{
    
    private static final String ma ="MaChinhSach";
    private static final String ten ="TenChinhSach";
    private static final String hotro ="MucHoTro";
    
    private static String getall=" SELECT * FROM DienChinhSach ";
    private static String getDSC=" SELECT * FROM DienChinhSach WHERE MaChinhSach = ? ";
    
    @Override
    public int Them(DienChinhSach t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Sua(DienChinhSach t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Xoa(DienChinhSach t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DienChinhSach> TìmKiem(DienChinhSach t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DienChinhSach getT(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DienChinhSach> getALL() {
        List<DienChinhSach> ds = new ArrayList<>();
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
    public DienChinhSach getTObject(ResultSet rs) {
        try {
            return new DienChinhSach(rs.getString(ma), rs.getString(ten), rs.getInt(hotro));
        } catch (Exception e) {
        }
        return null;
    }
    public static void main(String[] args) {
        
    }
}
