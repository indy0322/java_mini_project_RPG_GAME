package com.rpggame.service;

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

    public void findAllCharacter(String id) {
        ArrayList<Character> result = characterRepository.findAllCharacters(id);

        if(!result.isEmpty()){
            System.out.println("캐릭터 목록 확인: ");
            for(Character c : result){
                System.out.println("이름: " + c.getName() + " lv: " + c.getLevel());
            }
        }
    }
}
