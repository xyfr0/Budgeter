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
    
    private static Connection koneksi;
    
    public static Connection connect() {
        if (koneksi == null) {
            try {
                String server = "localhost";
                String database = "MYMONEY";
                String user = "adminisme";
                String password = "123admin*";
                String url = "jdbc:sqlserver://" + server + ":1433;databaseName="
                        + database + ";encrypt=false";

                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Koneksi Berhasil!");
            } catch (ClassNotFoundException e) {
                System.out.println("Driver tidak ditemukan: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Koneksi gagal: " + e.getMessage());
            }
        }
        return koneksi;
    }
    
}
