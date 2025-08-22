package com.rpggame.aggregate;

import com.rpggame.aggregate.items.Item;
import com.rpggame.aggregate.skills.Skill;

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
    private ArrayList<Skill> skill = new ArrayList<>();
    private ArrayList<Item> Item = new ArrayList<>();

    public Character() {
    }

    public Character(String name, String id) {
        this.hp = 100;
        this.maxHp = 100;
        this.mp = 100;
        this.maxMp = 100;
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

    public ArrayList<Skill> getSkill() {
        return this.skill;
    }

    public void addSkill(Skill skill) {
        this.skill.add(skill);
    }

    public void deleteSkill(Skill skill) {
        this.skill.remove(skill);
    }

    public ArrayList<Item> getItem() {
        return this.Item;
    }

    public void addItem(Item item) {
        this.Item.add(item);
    }

    public void deleteItem(Item item) {
        this.Item.remove(item);
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
}
