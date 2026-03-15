/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crudapp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author k2
 */
public class CRUDApp1 {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/k2";
        String user = "k2";
        String password = "k20518";

        Connection conn = DriverManager.getConnection(url, user, password);
        Statement statement =  conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM players");
        
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println(id + " " + name);
        }
        
        
    }
}
