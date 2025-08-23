package com.rpggame.service;

import com.rpggame.aggregate.Monster;
import com.rpggame.aggregate.Character;

import java.util.Random;

public class MonsterService {

    public Monster getRandomMonster() {
        Random random = new Random();
        Monster[] monsters = Monster.values();
        int index = random.nextInt(monsters.length);
        return monsters[index];
    }

    public void monsterRandomMotion(Monster monster, Character character){
        Random random = new Random();
        int choice = random.nextInt(2);
        if(choice == 0){
            deal(monster, character);
        }else{
            heal(monster);
        }
    }

    public void deal(Monster monster, Character character) {
        System.out.println(monster.getName() + " 이(가) 공격을 하였습니다.");
        System.out.println(character.getName() + " 이(가) " + monster.getDeal() + " 의 피해를 입었습니다.");
        character.setHp(character.getHp() - monster.getDeal());
    }

    public void heal(Monster monster) {
        if(monster.getHp() < monster.getMaxHp()) {
            System.out.println(monster.getName() + " 는(은) " + "10의 체력을 회복하였습니다.");
            monster.setHp(monster.getHp() + 10);
        }else{
            System.out.println(monster.getName() + " 는(은) " + "이미 완전히 회복하였습니다.");
        }
    }
}
