package com.qa.presistence.domain;

public class WildAnimal {
    public int getDamageDeals() {
        return damageDeals;
    }

    public void setDamageDeals(int damageDeals) {
        this.damageDeals = damageDeals;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public WildAnimal(int damageDeals, int strength, int spawnPoint) {
        this.damageDeals = damageDeals;
        this.spawnPoint = spawnPoint;
        this.strength = strength;
    }

    private int damageDeals;
    private int strength;

    public int getSpawnPoint() {
        return spawnPoint;
    }

    public void setSpawnPoint(int spawnPoint) {
        this.spawnPoint = spawnPoint;
    }
    public void doDamage(Player player){
        player.setHealth(player.getHealth()-this.damageDeals);
    }

    private  int spawnPoint;
}
