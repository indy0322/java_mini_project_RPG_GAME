package com.rpggame.aggregate.monsters;

public class Slime implements Monster {
    @Override
    public int damage() {
        return 15;
    }

    @Override
    public int heal() {
        return 10;
    }
}
