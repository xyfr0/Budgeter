/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.budgeter.database;

import java.sql.*;

/**
 *
 * @author jabba
 */
public class Koneksi {

    Connection con = null;
    static String server = "Tenma";
    static String port = "1691";
    static String databaseName = "MYMONEY";

    public static Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = String.format("jdbc:sqlserver://%s:%s;databaseName=%s;encrypt=true;trustServerCertificate=true;user=irhamjab;password=basdatOke123;", server, port, databaseName);
        Connection con = DriverManager.getConnection(connectionUrl);
        return con;
    }

    public Connection getCon() {
        return con;
    }        

}
