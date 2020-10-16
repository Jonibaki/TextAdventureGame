package com.qa.controller;

import com.qa.presistence.domain.Item;
import com.qa.presistence.domain.Player;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;


public class PlayerController {
    private final Logger LOGGER = LogManager.getLogger();

    Player player;
    public PlayerController(Player player) {
        this.player = player;
    }
    public void collectItem(Item anItem){
        List<Item> newItem = player.getPlayerItem();
        newItem.add(anItem);
        player.setPlayerItem(newItem);
        newItem.clear();
    }
    public void moveEast(){
        LOGGER.info("You are going East");
        //subtract radius

    }
    public void moveWest(){
        LOGGER.info("You are going West");

    }
    public void moveNorth(){
        LOGGER.info("You are going North");

    }
    public void moveSouth(){
        LOGGER.info("You are going South");

    }
    public void currentPosition(){

    }


}
