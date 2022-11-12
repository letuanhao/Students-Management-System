/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.DatabaseConn;
import Model.NamHoc;
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
public class TonGiao_DAO implements DAO<TonGiao>{
    private static final String ma ="MaTonGiao";
    private static final String ten ="TenTonGiao";
    
    private static String getall="SELECT * FROM TonGiao";

    @Override
    public int Them(TonGiao t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Sua(TonGiao t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Xoa(TonGiao t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TonGiao> TìmKiem(TonGiao t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TonGiao getT(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TonGiao> getALL() {
        List<TonGiao> ds = new ArrayList<>();
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
    public TonGiao getTObject(ResultSet rs) {
        try {
            return new TonGiao(rs.getString(ma), rs.getString(ten));
        } catch (Exception e) {
        }
        return null;
    }
    
    public static void main(String[] args) {
        TonGiao_DAO tg = new TonGiao_DAO();
        DataStatic.dsTG = tg.getALL();
        System.out.println(DataStatic.dsTG.size());
    }
}
