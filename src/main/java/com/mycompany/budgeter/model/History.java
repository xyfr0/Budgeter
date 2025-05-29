/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.budgeter.model;

/**
 *
 * @author MSIG6
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class History {    
    private List<Transaction> transactionHistory = new ArrayList<>();
    private LocalDate monthHistory;
    
    
    
    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
    
    public void setTransactionHistory(List<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }
    
    public LocalDate getMonthHistory() {
        return monthHistory;
    }
    
    public void setMonthHistory(LocalDate monthHistory) {
        this.monthHistory = monthHistory;
    }
    
    public List<Transaction> getMonthlyTransaction() {
        return null;
    }
}

