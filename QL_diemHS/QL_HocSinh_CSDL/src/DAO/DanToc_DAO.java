/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.DatabaseConn;
import Model.DanToc;
import View.DataStatic;
import com.sun.jdi.connect.spi.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minh0
 */
public class DanToc_DAO implements DAO<DanToc>{
    
    
    private static final String ma = "MaDanToc";
    private static final String ten ="TenDanToc";
    
    private static String getall="SELECT * FROM DanToc";

    @Override
    public int Them(DanToc t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Sua(DanToc t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Xoa(DanToc t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DanToc> TìmKiem(DanToc t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DanToc getT(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DanToc> getALL() {
        List<DanToc> ds = new ArrayList<>();
        try {
            java.sql.Connection c = DatabaseConn.getDBConn().getconn();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(getall);
            while(rs.next()){
                ds.add(getDTRS(rs));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    private DanToc getDTRS(ResultSet rs) throws SQLException{
        DanToc dt = new DanToc(rs.getString(ma), rs.getString(ten));
        return dt;
    }
    
    @Override
    public DanToc getTObject(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        DanToc_DAO dt = new DanToc_DAO();
        DataStatic.dsDT = dt.getALL();
        System.out.println(DataStatic.dsDT.size());
    }
}
