/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudapp1;

/**
 *
 * @author k2
 */
public class Player {
    private int id;
    private String name;
    private double time_in_sec;
    
    Player(int id, String name, double time_in_sec) {
        this.id = id;
        this.name = name;
        this.time_in_sec = time_in_sec;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getTime_in_sec() {
        return time_in_sec;
    }
    
    
}
