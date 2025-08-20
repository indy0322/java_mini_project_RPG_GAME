package com.rpggame.aggregate.items;

import com.rpggame.aggregate.monsters.Monster;

public class HealPotion implements Item {
    @Override
    public int damage() {
        return 0;
    }

    @Override
    public int heal() {
        return 0;
    }

    @Override
    public String description() {
        return "";
    }
}
