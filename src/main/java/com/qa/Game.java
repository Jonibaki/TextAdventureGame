package com.qa;

import com.qa.controller.PlayerController;
import com.qa.presistence.domain.GameMap;
import com.qa.presistence.domain.Item;
import com.qa.presistence.domain.Player;
import com.qa.presistence.domain.WildAnimal;
import com.qa.utils.Utils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Game {
    public static final Logger LOGGER = LogManager.getLogger();
    private final PlayerController playerController;
    private final GameMap map;
    private final Item items;
    private final Player player;
    private WildAnimal wildAnimal;
    private final Utils utils;
    private List<Item> playerItem = new ArrayList<>();
    private Vector<Integer> treasureLocation = new Vector<>();




    public Game() {
        utils= new Utils();
        this.wildAnimal = new WildAnimal(5,5,0);
        //TODO: change value into a separated class
        this.player = new Player(100,1000, 3, 0, true,playerItem);
        this.playerController = new PlayerController(player);
        this.map = new GameMap(100, 100,100,100,100);
        this.items = new Item();
        this.treasureLocation.add(0);
    }
    public void runGame(){
        LOGGER.info("\"Hello Player! Welcome to the adventure\\n\" +\n" +
                "                \"Follow the guideline to find the treasure in the map.\\n\" +\n" +
                "                \"Good luck in your quest...!!\"");

        do {
            LOGGER.info("Health:"+ player.getHealth() +" Items: "+player.getPlayerItem()+"  Money: "+player.getMoney());
            LOGGER.info("Navigate your player as you like");
            LOGGER.info("Navigate: 1.East 2.West 3.North 4.South");
            showMap();
            //look for challenges
            //quest: collect/use
            //wild: fight/flee
            //treasure: collect/win

        } while (player.getHealth()>=0); //or collected treasure
        LOGGER.info("Game Over.. GG!!");

    }
    public void showMap(){
        int dir = utils.getInteger();

        switch(dir){
            case 1:
                //foundTheTreasure();
                playerController.moveEast();
                map.setEast(map.getEast()-5);
                map.setWest(map.getWest()+5);
                //check animal
                foundAnimals();
                //check quest/task
                //check item
                LOGGER.info(map.toString());
                break;
            case 2:
                playerController.moveWest();
                map.setWest(map.getWest()-5);
                map.setEast(map.getEast()+5);
                LOGGER.info(map.toString());
                break;
            case 3:
                playerController.moveNorth();
                map.setNorth(map.getNorth()-5);
                map.setSouth(map.getSouth()+5);
                LOGGER.info(map.toString());
                break;
            case 4:
                playerController.moveSouth();
                map.setSouth(map.getSouth()-5);
                map.setNorth(map.getNorth()+5);
                LOGGER.info(map.toString());
                break;
        }


    }

    private void foundTheTreasure() {
        if(player.getSpawnPoint()==treasureLocation.firstElement()){
            LOGGER.info("YOU HAVE FOUND THE HIDDEN TREASURE!!!");
            LOGGER.info("____@_____@____");
        }
    }

    public void generateWildAnimal(){

    }
    public void generateItems(){

    }
    public void foundAnimals(){
        if(wildAnimal.getSpawnPoint()==player.getSpawnPoint()) {
            LOGGER.info("you are facing wild animal on your path");
            boolean leftTheScene = false;
            do {
                LOGGER.info("Decide now  1.Fight  2.Flee");
                int dic = utils.getInteger();
                switch (dic) {
                    case 1:
                        LOGGER.info("Animal roars and Attacked!!");
                        wildAnimal.doDamage(player);
                        LOGGER.info("You took damage: " + wildAnimal.getDamageDeals());
                        wildAnimal.setStrength(wildAnimal.getStrength()-player.getPower());
                        if(wildAnimal.getStrength()<=0){ leftTheScene=true; LOGGER.info("You defeated the wild animal"); break;}
                        LOGGER.info("Animal took damage: " + player.getPower() + " Animal health bar: "+ wildAnimal.getStrength());
                        break;
                    case 2:
                        LOGGER.info("you are running away");
                        leftTheScene=true;
                        break;
                }
            }while (!leftTheScene);

        }

    }
}
