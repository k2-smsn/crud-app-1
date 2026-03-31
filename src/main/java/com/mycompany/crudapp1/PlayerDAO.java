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
    int insertPlayer(String name, double time);
    Player getPlayerById(int id);
    List<Player> getAllPlayers();
    int updateRow(int id, String new_name, double time_in_sec);
    int updateName(int id, String new_name);
    int updateTime(int id, double new_time);
    int deleteRow(int id);
}
