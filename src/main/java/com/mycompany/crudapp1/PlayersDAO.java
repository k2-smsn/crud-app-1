/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudapp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author k2
 */
public class PlayersDAO {
    private final String url = "jdbc:postgresql://localhost:5432/k2";
    private final String user = "k2";
    private final String password = "k20518";
    
    public void insertPlayer(String name, double time_in_sec) {
        try (
            Connection conn = DriverManager.getConnection(url, user, password); 
            PreparedStatement ps = conn.prepareStatement("INSERT INTO players(name, time_in_sec) VALUES(?, ?)")) { 
           
            ps.setString(1, name);
            ps.setDouble(2, time_in_sec);
            ps.executeUpdate();
        } 
        catch (Exception e) {
        }
    }
    
    public Player getPLayerById(int id) {
        Player player = null;
        try (
            Connection conn = DriverManager.getConnection(url, user, password); 
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM players WHERE id = ?")) { 
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                player = new Player(rs.getInt("id"), rs.getString("name"), rs.getDouble("time_in_sec"));
            }
            catch(Exception e) {
                System.out.println("entity with that id does not exist");
            }
            
        } 
        catch (Exception e) {}
        
        return player;
    }
    
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        
        try (
            Connection conn = DriverManager.getConnection(url, user, password); 
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM players")) { 
           
            try (ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    players.add(new Player(rs.getInt("id"), rs.getString("name"), rs.getDouble("time_in_sec")));
                }
            }
        } 
        catch (Exception e) {
        }
        
        return players;
    }
    
    public void updateName(int id, String new_name) {
        try (
            Connection conn = DriverManager.getConnection(url, user, password); 
            PreparedStatement ps = conn.prepareStatement("UPDATE players SET name = ? WHERE id = ?")) {
            ps.setString(1, new_name);
            ps.setInt(2, id);
            ps.executeUpdate();
        } 
        catch (Exception e) {}
    }
    
    public void updateTime(int id, double new_time) {
        try (
            Connection conn = DriverManager.getConnection(url, user, password); 
            PreparedStatement ps = conn.prepareStatement("UPDATE players SET time_in_sec = ? WHERE id = ?")) {
            ps.setDouble(1, new_time);
            ps.setInt(2, id);
            ps.executeUpdate();
        } 
        catch (Exception e) {}
    }
    
    
    
}
