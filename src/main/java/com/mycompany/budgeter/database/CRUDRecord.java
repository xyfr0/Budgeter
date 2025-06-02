/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.budgeter.database;

import java.sql.*;
import java.util.Date;

/**
 *
 * @author jabba
 */
public class CRUDRecord {

    private static final String SQL_QUERY = "USE MYMONEY ";

    /**
     *
     * @param transactionID
     * @param amount
     * @param transactionDate
     * @param transactionType
     * @param description
     */
    public void insertTransaction(int transactionID, double amount, Date transactionDate, String transactionType, String description) {

        try (Connection conn = Koneksi.connect(); PreparedStatement ps = conn.prepareStatement(SQL_QUERY
                + "INSERT INTO TransactionHistory (TransactionID, Amount, TransactionDate, TransactionType, Description) "
                + "VALUES (?, ?, ?, ?, ?);"
        )) {
            ps.setInt(1, transactionID);
            ps.setDouble(2, amount);
            ps.setDate(3, new java.sql.Date(transactionDate.getTime()));
            ps.setString(4, transactionType);
            ps.setString(5, description);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException sce) {
            sce.printStackTrace();
        }
    }

    public void deleteTransaction(String transactionID) {
        try (Connection conn = Koneksi.connect(); PreparedStatement ps = conn.prepareStatement(SQL_QUERY + "DELETE FROM TransactionHistory WHERE TransactionID = ?")) {
            ps.setString(1, transactionID);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException sce) {
            sce.printStackTrace();
        }
    }

}
