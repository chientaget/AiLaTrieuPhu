/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import dao.PlayerDAO;
import entity.Person;
import entity.Player;
import entity.Question;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author LENOVO
 */
public class test {
    public static void main(String[] args) {
        
        PlayerDAO pdao = new PlayerDAO();
        Player player = new Player();
        player.setFullName("test");
        player.setEmail("test");
        player.setUsername("test");
        player.setPassword("123");
        pdao.addPlayer(player);
        
//        
//        List<Player> pList = pdao.getAllPlayers();
//      
//        for(Player p : pList) {
//            System.out.println(p);
//        }
    }
}
