/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.crudapp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author k2
 */
public class CRUDApp1 {
    
    public static void main(String[] args) throws SQLException {
        PlayersDAOImp dao = new PlayersDAOImp();
        
        List<Player> ps = dao.getAllPlayers();
        
        System.out.println("ID  NAME     TIME_IN_SEC");
        for (Player p : ps) {
            System.out.println(p.getId() + "   " + p.getName() + " " + p.getTime_in_sec());
        }
        
    }
}
