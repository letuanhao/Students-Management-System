/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.DatabaseConn;
import Model.MonHoc;
import Model.NamHoc;
import View.DataStatic;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minh0
 */
public class NamHoc_DAO implements DAO<NamHoc>{
    private static final String ma = "MaNamHoc";
    private static final String ten ="NamHoc";
    
    private static String them="INSERT INTO NamHoc VALUES( ? , ? )";
    private static String getall ="SELECT * FROM NamHoc";
    

    @Override
    public int Them(NamHoc t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Sua(NamHoc t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Xoa(NamHoc t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NamHoc> TìmKiem(NamHoc t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NamHoc getT(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NamHoc> getALL() {
        List<NamHoc> ds = new ArrayList<>();
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
    public NamHoc getTObject(ResultSet rs) {
        try {
            return new NamHoc(rs.getString(ma), rs.getString(ten));
        } catch (Exception e) {
        }
        return null;
    }
    
    public static void main(String[] args) {
        NamHoc_DAO nh = new NamHoc_DAO();
        DataStatic.dsNH= nh.getALL();
        System.out.println(DataStatic.dsNH.size());
    }
}
