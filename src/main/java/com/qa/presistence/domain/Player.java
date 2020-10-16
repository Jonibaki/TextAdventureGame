package com.qa.presistence.domain;

import java.util.List;

public class Player {

    private int health;
    private int money;
    private boolean hasHealth;
    private int power;

    public int getSpawnPoint() {
        return spawnPoint;
    }

    public void setSpawnPoint(int spawnPoint) {
        this.spawnPoint = spawnPoint;
    }

    private int spawnPoint;

    public List<Item> getPlayerItem() {
        return playerItem;
    }

    public void setPlayerItem(List<Item> playerItem) {
        this.playerItem = playerItem;
    }

    private List<Item> playerItem;
    public Player(int health, int money, int power, int spawnPoint, boolean hasHealth, List<Item> playerItem) {
        this.power = power;
        this.hasHealth= hasHealth;
        this.health = health;
        this.spawnPoint = spawnPoint;
        this.money = money;
        this.playerItem = playerItem;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public boolean isHasHealth(int damage){
        this.health-=damage;
        if(health<=0){
            this.hasHealth=false;
            return this.hasHealth;
        }
        return true;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
