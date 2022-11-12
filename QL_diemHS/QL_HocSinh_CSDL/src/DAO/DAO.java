/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import java.sql.*;
/**
 *
 * @author minh0
 */
public interface DAO<T> {
    public int Them(T t);
    public int Sua(T t);
    public int Xoa(T t);
    public List<T> TìmKiem(T t);
    public T getT(String ma);
    public List<T> getALL();
    T getTObject(ResultSet rs);
}
