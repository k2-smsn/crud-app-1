/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crudapp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement pStatement1 = conn.prepareStatement("INSERT INTO players (name, time_in_sec) VALUES (?, ?)");
        PreparedStatement statement =  conn.prepareStatement("SELECT * FROM players");
        
        //Handle placeholders (?)
        pStatement1.setString(1, "frince");
        pStatement1.setDouble(2, 24.2);
        //statement.setInt(1, column);
        
        //Execute query
        pStatement1.executeUpdate();
        ResultSet resultSet = statement.executeQuery();
        
        System.out.println("id Name time_in_sec");
        System.out.println("-----------------------------");
        
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double time_in_sec = resultSet.getDouble("time_in_sec");
            System.out.println(id + " " + name + " " + time_in_sec);
        }
        
        resultSet.close();
        statement.close();
        conn.close();
        
    }
}
