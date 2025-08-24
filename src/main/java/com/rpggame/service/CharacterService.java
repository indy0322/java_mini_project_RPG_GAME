package com.rpggame.service;

import com.rpggame.aggregate.Monster;
import com.rpggame.repository.CharacterRepository;
import com.rpggame.aggregate.Character;

import java.util.ArrayList;

public class CharacterService {
    private final CharacterRepository characterRepository;

    public CharacterService() {
        this.characterRepository = new CharacterRepository();
    }

    public int createCharacter(Character character){
        int result = characterRepository.createCharacter(character);

        if(result == 1){
            System.out.println(character.getName() + "캐릭터가 생성되었습니다.");
            return 1;
        }else{
            System.out.println("캐릭터 생성 실패");
            return 0;
        }
    }

    public int findAllCharacter(String id) {
        ArrayList<Character> result = characterRepository.findAllCharacters(id);

        if(!result.isEmpty()){
            System.out.println("캐릭터 목록 확인: ");
            for(Character c : result){
                System.out.println("이름: " + c.getName() + " lv: " + c.getLevel());
            }
            return 1;
        }else{
            System.out.println("존재하는 캐릭터가 없습니다. 캐릭터를 생성해주세요.");
            return 0;
        }
    }

    public Character choiceCharacter(String id,String choiceChar) {
        Character result = characterRepository.choiceCharacters(id,choiceChar);
        if(result != null){
            System.out.println(result.getName() + " 캐릭터로 플레이를 시작하겠습니다.");
        }
        return result;
    }

    public void deal(Monster monster, Character character){
        System.out.println(character.getName() + " 는(은) 공격을 했습니다.");
        System.out.println(character.getDeal() + " 의 데미지를 주었습니다.");
        monster.setHp(monster.getHp() - character.getDeal());
        System.out.println(monster.getName() + " 의 남은 HP: " + monster.getHp());
    }

    public void heal(Character character){
        System.out.println(character.getName() + " 는(은) 5의 체력을 회복했습니다.");
        System.out.println(character.getName() + " 는(은) 10의 마나를 소비했습니다.");
        if(character.getHp() < character.getMaxMp()){
            character.setHp(character.getHp() + 5);
            character.setMp(character.getMp() - 10);
            System.out.println(character.getName() + " 의 남은 체력: " +  character.getHp());
            System.out.println(character.getName() + " 의 남은 마나: " +  character.getMp());
        }else{
            System.out.println(character.getName() + " 는(은) " + "이미 완전히 회복하였습니다.");
        }
    }

    public void modifyLevel(Character playChar) {
        playChar.setLevel(playChar.getLevel() + 1);
        int result = characterRepository.modifyCharacter(playChar);
        if(result == 1){
            System.out.println(playChar.getName() + " 의 레벨이 1증가했습니다.");
        }else{
            System.out.println(playChar.getName() + " 이(가) 레벨업 하는데, 실패했습니다.");
        }

    }
}
