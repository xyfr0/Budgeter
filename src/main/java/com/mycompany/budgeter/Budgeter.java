package com.mycompany.budgeter;

import com.mycompany.budgeter.database.Koneksi;
import com.mycompany.budgeter.view.MyMoneyGUI;
import java.sql.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author jabba
 */
public class Budgeter {

    public static void main(String[] args) {        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyMoneyGUI().setVisible(true);
            }
        });

    }

}
