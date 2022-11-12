/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.HocKi;
import java.util.List;
import java.sql.*;
import Connection.DatabaseConn;
import View.DataStatic;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author minh0
 */
public class HocKi_DAO implements DAO<HocKi>{
    private static final String ma ="MaHocKi";
    private static final String HocKi="HocKi";
    private static final String heso = "heso";
    
    private static String getall="SELECT * FROM HocKi order by MaHocKi";
    

    @Override
    public int Them(HocKi t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Sua(HocKi t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Xoa(HocKi t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HocKi> TìmKiem(HocKi t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HocKi getT(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HocKi> getALL() {
        List<HocKi> ds = new ArrayList<>();
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
    public HocKi getTObject(ResultSet rs) {
        
        try {
            HocKi hk = new HocKi(rs.getString(ma), rs.getString(HocKi), rs.getInt(heso));
            return hk;
        } catch (SQLException ex) {
            Logger.getLogger(HocKi_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args) {
        HocKi_DAO hk = new HocKi_DAO();
        DataStatic.dsHK = hk.getALL();
        System.out.println(DataStatic.dsHK.get(0).getHK());
    }
    
}
