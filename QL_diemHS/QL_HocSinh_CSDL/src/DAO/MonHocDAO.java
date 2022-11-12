/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.DatabaseConn;
import Model.HanhKiem;
import Model.HocLuc;
import Model.HocPhi;
import Model.MonHoc;
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
public class MonHocDAO implements DAO<MonHoc>{
    private static final String ma = "MaMonHoc";
    private static final String ten ="TenMonHoc";
    private static final String heso ="heso";
    
    private static final String maHL = "MaHocLuc";
    private static final String tenHL ="HocLuc";
    
    private static final String maHK = "MaHanhKiem";
    private static final String tenHK ="HanhKiem";
    
    private static final String maHP = "MaHocPhi";
    private static final String tenHP ="HocPhi";
    
    private static String getall="SELECT * FROM MonHoc";
    private static String getallHL="SELECT * FROM HocLuc";
    private static String getallHK="SELECT * FROM HanhKiem";
    private static String getallHP="SELECT * FROM HocPhi";
    @Override
    public int Them(MonHoc t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Sua(MonHoc t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Xoa(MonHoc t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MonHoc> TìmKiem(MonHoc t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MonHoc getT(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MonHoc> getALL() {
        List<MonHoc> ds = new ArrayList<>();
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
    public MonHoc getTObject(ResultSet rs) {
        try {
            return  new MonHoc(rs.getString(ma), rs.getString(ten), rs.getInt(heso));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<HocLuc> getAllHocLuc(){
        List<HocLuc> ds = new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(getallHL);
            while(rs.next()){
                ds.add(getHLRS(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ds;
    }
    public HocLuc getHLRS(ResultSet rs){
        try {
            return  new HocLuc(rs.getString(maHL), rs.getString(tenHL));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<HanhKiem> getAllHanhKiem(){
        List<HanhKiem> ds = new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(getallHK);
            while(rs.next()){
                ds.add(getHKRS(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ds;
    }
    public HanhKiem getHKRS(ResultSet rs){
        try {
            return new HanhKiem(rs.getString(maHK),rs.getString(tenHK));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<HocPhi> getAllHocPhi(){
        List<HocPhi> ds = new ArrayList<>();
        try {
            Connection c = DatabaseConn.getDBConn().getconn();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(getallHP);
            while(rs.next()){
                ds.add(getHPRS(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ds;
    }
    public HocPhi getHPRS(ResultSet rs){
        try {
            return new HocPhi(rs.getString(maHP),rs.getFloat(tenHP));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        MonHocDAO mh = new MonHocDAO();
        DataStatic.dsMH = mh.getALL();
        DataStatic.dsHanhKiem = mh.getAllHanhKiem();
        DataStatic.dsHocLuc = mh.getAllHocLuc();
        System.out.println(DataStatic.dsMH.size());
        System.out.println(DataStatic.dsHanhKiem.size());
        System.out.println(DataStatic.dsHocLuc.size());
        System.out.println(mh.getAllHocPhi().get(1).getHocPhi());
    }
}
