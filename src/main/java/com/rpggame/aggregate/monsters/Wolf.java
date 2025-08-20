package com.rpggame.aggregate.monsters;

public class Wolf implements Monster {

    @Override
    public int damage() {
        return 20;
    }

    @Override
    public int heal() {
        return 0;
    }
}
