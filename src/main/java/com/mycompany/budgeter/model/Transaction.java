package com.mycompany.budgeter.model;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.time.LocalDate;

/**
 *
 * @author MSIG6
 */
import java.util.Date;

public class Transaction {
private int id;
private double amount;
private Date date;
private String transactionType;
private String description;

    public Transaction(int id, double amount, Date date, String transactionType, String description) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.transactionType = transactionType;
        this.description = description;        
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}


