/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.DatabaseConn;
import Model.DiemChiTiet;
import  java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minh0
 */
public class DiemChiTiet_DAO implements DAO<DiemChiTiet>{
    
    private static final String ma ="MaDiem";
    private static final String ten ="DiemChiTiet";
    private static final String heso ="heso";
    
    private static String getall ="SELECT * FROM DiemChiTiet order by MaDiem";
    
    
    
    @Override
    public int Them(DiemChiTiet t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Sua(DiemChiTiet t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Xoa(DiemChiTiet t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DiemChiTiet> TìmKiem(DiemChiTiet t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DiemChiTiet getT(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DiemChiTiet> getALL() {
        List<DiemChiTiet> ds = new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(getall);
            while(rs.next()){
                ds.add(getDiemChiTiet(rs));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    
    private DiemChiTiet getDiemChiTiet(ResultSet rs) throws SQLException{
        DiemChiTiet dct = new DiemChiTiet(rs.getString(ma), rs.getString(ten), rs.getInt(heso));
        return dct;
    }
    
    public static void main(String[] args) {
        DiemChiTiet_DAO dctdao = new DiemChiTiet_DAO();
        List<DiemChiTiet> ds = dctdao.getALL();
        for (DiemChiTiet d : ds) {
            System.out.println(d.getDiemChiTiet());
        }
        
    }

    @Override
    public DiemChiTiet getTObject(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
