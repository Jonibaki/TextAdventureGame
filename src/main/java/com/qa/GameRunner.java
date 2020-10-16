package com.qa;


import com.qa.presistence.domain.GameMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameRunner {
    private static Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) {
        Game run = new Game();
        run.runGame();
        LOGGER.info("GAME OVER");
    }

}
