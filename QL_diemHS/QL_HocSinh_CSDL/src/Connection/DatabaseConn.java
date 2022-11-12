/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author minh0
 */
public class DatabaseConn {
    private Connection conn;
    static DatabaseConn DBconn;
    public static final String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=QL_hoc_sinh;";
    public static final String dbUser = "username=minh;";
    public static final String dbPass = "password=minh";

    public DatabaseConn() {
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(dbURL+dbUser+dbPass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static DatabaseConn getDBConn(){
        if(DBconn==null){
            DBconn = new DatabaseConn();
        }
        return DBconn;
    }
    
    public Connection getconn(){
        return conn;
    }
    
    public static void main(String[] args) {
        getDBConn().getconn();
    }
}
