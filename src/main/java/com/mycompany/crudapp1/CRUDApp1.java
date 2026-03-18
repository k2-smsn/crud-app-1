/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crudapp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        
        int column = 1;

        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement statement =  conn.prepareStatement("SELECT * FROM players WHERE id = ?");
        
        //Handle placeholders (?)
        statement.setInt(1, column);
        
        //Execute query
        ResultSet resultSet = statement.executeQuery();
        
        
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println(id + " " + name);
        }
        
        resultSet.close();
        statement.close();
        conn.close();
        
    }
}
