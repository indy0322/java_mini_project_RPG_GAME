package com.rpggame.aggregate;


import java.io.Serializable;
import java.util.ArrayList;

public class Character implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private int hp;
    private int maxHp;
    private int mp;
    private int maxMp;
    private int level;
    private int deal;

    public Character() {
    }

    public Character(String name, String id) {
        this.hp = 100;
        this.maxHp = 100;
        this.mp = 100;
        this.maxMp = 100;
        this.deal = 90;
        this.level = 1;
        this.name = name;
        this.id = id;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDeal() {
        return deal;
    }

    public void setDeal(int deal) {
        this.deal = deal;
    }
}
