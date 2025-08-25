package com.rpggame.aggregate;

import java.util.Random;

public enum Monster {
    SLIME("슬라임",100,10),
    SPIDER("거미",80,15),
    WOLF("늑대",100,10),
    LIZARD("도마뱀",150,15),


    private String name;
    private int hp;
    private int maxHp;
    private int deal;

    Monster() {
    }

    Monster(String name, int hp, int deal) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.deal = deal;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDeal(int deal) {
        this.deal = deal;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getDeal() {
        return deal;
    }

    @Override
    public String toString() {
        return "몬스터명: " + name + " hp: " + hp + " 딜: " + deal;
    }
}
