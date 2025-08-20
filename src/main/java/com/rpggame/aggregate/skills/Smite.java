package com.rpggame.aggregate.skills;

public class Smite implements Skill {
    @Override
    public int damage() {
        return 10;
    }

    @Override
    public int heal() {
        return 0;
    }

    @Override
    public String description() {
        return "강하게 내려찍었다.";
    }

}
