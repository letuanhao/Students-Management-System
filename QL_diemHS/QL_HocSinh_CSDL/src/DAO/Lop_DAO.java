/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.DatabaseConn;
import Model.Lop;
import View.DataStatic;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minh0
 */
public class Lop_DAO implements DAO<Lop>{
    private static final String ma ="Malop";
    private static final String ten ="Tenlop";
    
    private static String getall = "SELECT * FROM Lop";
    

    @Override
    public int Them(Lop t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Sua(Lop t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Xoa(Lop t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Lop> TìmKiem(Lop t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Lop getT(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Lop> getALL() {
        List<Lop> ds = new ArrayList<>();
        try {
            java.sql.Connection c = DatabaseConn.getDBConn().getconn();
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
    public Lop getTObject(ResultSet rs) {
        try {
            return new Lop(rs.getString(ma), rs.getString(ten));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        Lop_DAO l = new Lop_DAO();
        DataStatic.dsLop = l.getALL();
        System.out.println(DataStatic.dsLop.get(8).getTenLop());
    }
}
