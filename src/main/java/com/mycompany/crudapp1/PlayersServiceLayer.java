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
    
    public void insertNewPlayer(String name, double time_in_sec) {
        if (name.equals("") || time_in_sec <= 0) {
            throw new IllegalArgumentException("Fields cannot be empty");
        }
        
        dao.insertPlayer(name, time_in_sec);
    }
    
    public void getPlayerById(String id) {
        checkId(id);
        dao.getPlayerById(Integer.parseInt(id));
    }
    
    public void deleteRow(String id) {
        checkId(id);
        dao.deleteRow(Integer.valueOf(id));     
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
