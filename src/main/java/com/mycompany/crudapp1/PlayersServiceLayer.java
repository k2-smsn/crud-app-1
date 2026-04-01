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
    
    public void insertNewPlayer(String name, String time_in_sec) {
        double time;
        
        if (name.isBlank() || time_in_sec.isBlank()) {
            throw new IllegalArgumentException("Fields cannot be empty.");
        }
        
        try {
            time = Double.parseDouble(time_in_sec);
        }
        catch(Exception e) {
            throw new IllegalArgumentException("time must be a decimal.");
        }
        
        if (time <= 0) {
            throw new IllegalArgumentException("time must be greater than zero.");
        }
        
        dao.insertPlayer(name, time);
    }
    
    public void updateRow(String id, String name, String time_in_sec) {
        double time;
        int i = 0;
        
        checkId(id);
        
        if (name.isBlank() && time_in_sec.isBlank()) {
            throw new IllegalArgumentException("All fields cannot be blank.");
        }
        
        if (!name.isBlank() && !time_in_sec.isBlank()) {
            try {
                time = Double.parseDouble(time_in_sec);
            } catch (Exception e) {
                throw new IllegalArgumentException("Time must be a decimal");
            }
            
            if (time <= 0) {
                throw new IllegalArgumentException("time must be greater than zero.");
            }
            
            i = dao.updateRow(Integer.parseInt(id), name, time);
        }
        else if (!name.isBlank()) {
            i = dao.updateName(Integer.parseInt(id), name);
        }
        else if (!time_in_sec.isBlank()) {
            try {
                time = Double.parseDouble(time_in_sec);
            } catch (Exception e) {
                throw new IllegalArgumentException("Time must be a decimal");
            }
            
            if (time <= 0) {
                throw new IllegalArgumentException("time must be greater than zero.");
            }
            
            i = dao.updateTime(Integer.parseInt(id), time);
        }
        
        if (i == 0) {
            throw new IllegalArgumentException("PLayer with that id does not exist.");
        }   

    }
    
    /*
    public void updateRow(String id, String name) {
        checkId(id);
        
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank,");
        }
        
        int i = dao.updateName(Integer.parseInt(id), name);
        
        if (i == 0) {
            throw new IllegalArgumentException("PLayer with that id does not exist.");
        }
    }
    
    public void updateRow(String id, String time_in_sec, boolean timeOnly) {
        double time;
        
        checkId(id);
        
        try {
            time = Double.parseDouble(time_in_sec);
        } catch (Exception e) {
            throw new IllegalArgumentException("Time must be a decimal.");
        }
        
        if (time <= 0) {
            throw new IllegalArgumentException("Time must be greater than zero");
        }
        
        int i = dao.updateTime(Integer.parseInt(id), time);
        
        if (i == 0) {
            throw new IllegalArgumentException("PLayer with that id does not exist.");
        }
    }
    */
    
    public void getPlayerById(String id) {
        checkId(id);
        dao.getPlayerById(Integer.parseInt(id));
    }
    
    public void deleteRow(String id) {
        checkId(id);
        dao.deleteRow(Integer.parseInt(id));     
    }
    
    private void checkId(String id) {
        try {
            Integer.valueOf(id);
        }
        catch (NumberFormatException e){
            throw new NumberFormatException("Invalid id");
        }
    
    }
}
