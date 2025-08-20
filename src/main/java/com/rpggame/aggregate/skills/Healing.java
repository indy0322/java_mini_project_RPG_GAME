package com.rpggame.aggregate.skills;

public class Healing implements Skill {
    @Override
    public int damage() {
        return 0;
    }

    @Override
    public int heal() {
        return 10;
    }

    @Override
    public String description() {
        return "회복시켰다.";
    }
}
