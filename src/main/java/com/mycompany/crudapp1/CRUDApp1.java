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
        PlayersDAO dao = new PlayersDAO();
        
        dao.insertPlayer("tibsidy", 23.7);
    }
}
