package com.rpggame.aggregate;

import com.rpggame.aggregate.skills.Skill;

import java.util.ArrayList;

public class Player {
    private int hp;
    private int maxHp;
    private int mp;
    private int maxMp;
    private int level;
    private ArrayList<Skill> skill = new ArrayList<>();

    public Player() {
        this.hp = 100;
        this.maxHp = 100;
        this.mp = 100;
        this.maxMp = 100;
        this.level = 1;
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
}
