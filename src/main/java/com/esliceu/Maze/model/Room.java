package com.esliceu.Maze.model;

public class Room {
    private int id;
    private int north;
    private int south;
    private int east;
    private int west;
    private int keyId;
    private int coin;
    private int mapId;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", north=" + north +
                ", south=" + south +
                ", east=" + east +
                ", west=" + west +
                ", keyId=" + keyId +
                ", coin=" + coin +
                ", mapId=" + mapId +
                '}';
    }

    public Room(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNorth() {
        return north;
    }

    public void setNorth(int north) {
        this.north = north;
    }

    public int getSouth() {
        return south;
    }

    public void setSouth(int south) {
        this.south = south;
    }

    public int getEast() {
        return east;
    }

    public void setEast(int east) {
        this.east = east;
    }

    public int getWest() {
        return west;
    }

    public void setWest(int west) {
        this.west = west;
    }

    public int getKeyId() {
        return keyId;
    }

    public void setKeyId(int keyId) {
        this.keyId = keyId;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }
}
