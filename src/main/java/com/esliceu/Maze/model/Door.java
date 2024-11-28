package com.esliceu.Maze.model;

public class Door {
    private int id;
    private int room1;
    private int room2;
    private boolean is_locked;

    @Override
    public String toString() {
        return "Door{" +
                "id=" + id +
                ", room1=" + room1 +
                ", room2=" + room2 +
                ", is_locked=" + is_locked +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom1() {
        return room1;
    }

    public void setRoom1(int room1) {
        this.room1 = room1;
    }

    public int getRoom2() {
        return room2;
    }

    public void setRoom2(int room2) {
        this.room2 = room2;
    }

    public boolean isIs_locked() {
        return is_locked;
    }

    public void setIs_locked(boolean is_locked) {
        this.is_locked = is_locked;
    }
}
