/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crudapp1;

import java.util.List;

/**
 *
 * @author k2
 */
public interface PlayerDAO {
    void insertPlayer(String name, double time);
    Player getPlayerById(int id);
    List<Player> getAllPlayers();
    void updateRow(Player p);
    void updateName(int id, String new_name);
    void updateTime(int id, double new_time);
    void deleteRow(int id);
}
