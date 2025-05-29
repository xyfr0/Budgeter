package com.mymoney.app;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String username;
    private String email;
    private String password;
    private List<String> transactionHistoryIds;
    
    public User(String username, String email, String password) {
        this.userId = generateUserId();
        this.username = username;
        this.email = email;
        this.password = password;
        this.transactionHistoryIds = new ArrayList<>();
    }
    
    // Generate unique user ID
    private String generateUserId() {
        return "USR-" + System.currentTimeMillis() + "-" + (int)(Math.random() * 1000);
    }
    
    // Getters and setters
    public String getUserId() {
        return userId;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
    
    public void addTransaction(String transactionId) {
        transactionHistoryIds.add(transactionId);
    }
    
    public List<String> getTransactionHistory() {
        return new ArrayList<>(transactionHistoryIds); 
    }
    
    public boolean authenticate(String inputPassword) {
        return this.password.equals(inputPassword);
    }
    
    @Override
    public String toString() {
        return "User ID: " + userId + "\n" +
               "Username: " + username + "\n" +
               "Email: " + email + "\n" +
               "Total Transactions: " + transactionHistoryIds.size();
    }
}