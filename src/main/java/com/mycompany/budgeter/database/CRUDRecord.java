/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.budgeter.database;

import com.mycompany.budgeter.model.Transaction;
import com.mycompany.budgeter.view.MyMoneyGUI;
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

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
    public void insertTransaction(Transaction transaction) {

        try (Connection conn = Koneksi.connect(); PreparedStatement ps = conn.prepareStatement(SQL_QUERY
                + "INSERT INTO TransactionHistory (TransactionID, Amount, TransactionDate, TransactionType, Description) "
                + "VALUES (?, ?, ?, ?, ?);"
        )) {            
            ps.setInt(1, transaction.getId());
            ps.setDouble(2, transaction.getAmount());
            ps.setObject(3, transaction.getDate());
            ps.setString(4, transaction.getTransactionType());
            ps.setString(5, transaction.getDescription());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException sce) {
            sce.printStackTrace();
        }
    }

    public void deleteTransaction(int transactionID) {
        try (Connection conn = Koneksi.connect(); PreparedStatement ps = conn.prepareStatement(SQL_QUERY + "DELETE FROM TransactionHistory WHERE TransactionID = ?")) {
            ps.setInt(1, transactionID);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException sce) {
            sce.printStackTrace();
        }
    }
    
    public void readTable(){   
        DefaultTableModel dtm = (DefaultTableModel) MyMoneyGUI.getHistoryTable().getModel();
        try(Connection conn = Koneksi.connect(); PreparedStatement ps = conn.prepareStatement(SQL_QUERY + "SELECT * FROM TransactionHistory")){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){ 
                int id = rs.getInt("TransactionID");
                Date date = rs.getDate("TransactionDate");
                String transactionType = rs.getString("TransactionType");
                double amount = rs.getDouble("Amount");
                String description = rs.getString("Description");
                dtm.addRow(new Object[]{id, date, transactionType, amount, description});
            }
        } catch(SQLException | ClassNotFoundException sce){
            sce.printStackTrace();
        }
        
    }
    
    public void updateBalance(double balance){                
        List<Double> amountList = new ArrayList<>();
        List<String> transactionTypeList = new ArrayList<>();
        try(Connection conn = Koneksi.connect(); PreparedStatement ps = conn.prepareStatement(SQL_QUERY + "SELECT amount, TransactionType FROM TransactionHistory")){
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                double amount = rs.getDouble("amount");    
                amountList.add(amount);
                String transactionType = rs.getString("TransactionType");                
                transactionTypeList.add(transactionType);
            }            
        }catch(SQLException | ClassNotFoundException sce){
            sce.printStackTrace();
        }
        for(int i = 0; i < amountList.size(); i++){
            if(transactionTypeList.get(i).equalsIgnoreCase("Income")){
                balance += amountList.get(i);
            } else{
                balance -= amountList.get(i);
            }
        }
    }

}
