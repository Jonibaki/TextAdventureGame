package com.qa.presistence.domain;

public class GameMap {
    private int radius;
    private Integer east;
    private Integer west;
    private Integer north;
    private Integer south;

    public GameMap(int radius, Integer east, Integer west, Integer north, Integer south) {
        this.radius = radius;
        this.east = east;
        this.west = west;
        this.north = north;
        this.south = south;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Integer getEast() {
        return east;
    }

    public void setEast(Integer east) {
        this.east = east;
    }

    public Integer getWest() {
        return west;
    }

    public void setWest(Integer west) {
        this.west = west;
    }

    @Override
    public String toString() {
        return "Your location in the map {" +
                "radius=" + radius +
                ", east='" + east + '\'' +
                ", west='" + west + '\'' +
                ", north='" + north + '\'' +
                ", south='" + south + '\'' +
                '}';
    }

    public Integer getNorth() {
        return north;
    }

    public void setNorth(Integer north) {
        this.north = north;
    }

    public Integer getSouth() {
        return south;
    }

    public void setSouth(Integer south) {
        this.south = south;
    }
}
