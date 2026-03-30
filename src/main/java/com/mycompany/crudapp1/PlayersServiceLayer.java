/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudapp1;

/**
 *
 * @author k2
 */
public class PlayersServiceLayer {
    private PlayersDAOImp dao;

    public PlayersServiceLayer(PlayersDAOImp dao) {
        this.dao = dao;
    }
    
    public String insertNewPlayer(String name, double time_in_sec) {
        if (name.equals("")) {
            return "Name cannot be empty.";
        }
        
        if (time_in_sec <= 0) {
            return "Time cannot be below zero.";
        }
        
        dao.insertPlayer(name, time_in_sec);
        return "Player inserted.";
    }
    
    public Player getPlayerById(String id) {
        checkId(id);
        return dao.getPlayerById(Integer.parseInt(id));
    }
    
    private void checkId(String id) {
        try {
            Integer.valueOf(id);
        }
        catch (NumberFormatException e){
            throw new NumberFormatException();
        }
    }
}
