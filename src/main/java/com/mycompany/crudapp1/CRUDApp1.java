/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crudapp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author k2
 */
public class CRUDApp1 {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/k2";
        String user = "k2";
        String password = "k20518";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to database!");
        }
    }
}
