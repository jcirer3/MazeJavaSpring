package com.esliceu.Maze.model;

import java.util.List;

public class Map {
    private int id;
    private String name;
    private int firstRoom;
    private int lastRoom;

    @Override
    public String toString() {
        return "Map{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstRoom=" + firstRoom +
                ", lastRoom=" + lastRoom +
                '}';
    }

    public Map() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFirstRoom() {
        return firstRoom;
    }

    public void setFirstRoom(int firstRoom) {
        this.firstRoom = firstRoom;
    }

    public int getLastRoom() {
        return lastRoom;
    }

    public void setLastRoom(int lastRoom) {
        this.lastRoom = lastRoom;
    }
}
