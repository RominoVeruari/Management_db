/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author User
 */
public class Conndb {

    public static Connection getConnection() throws Exception {

        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "db_client";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";

        Class.forName(driver).newInstance();
        Connection conn = DriverManager.getConnection(url + dbName, userName,password);
        System.out.println(conn);
        return conn;
        
    }
}
