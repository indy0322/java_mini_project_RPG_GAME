package com.rpggame.repository;

import com.rpggame.aggregate.Character;
import com.rpggame.aggregate.Member;
import com.rpggame.stream.MyObjectOutput;

import java.io.*;
import java.util.ArrayList;

public class CharacterRepository {

    private final ArrayList<Character> characters = new ArrayList<Character>();
    private final File file = new File("src/main/java/com/rpggame/db/characterDB.dat");

    public CharacterRepository() {
        if(!file.exists()){
            ArrayList<Character> defaultCharacterList = new ArrayList<>();
            defaultCharacterList.add(new Character("char1","dumy"));
            defaultCharacterList.add(new Character("char2","dumy"));


            saveMembers(defaultCharacterList);
        }

        loadCharacters();

    }

    private void saveMembers(ArrayList<Character> defaultMemberList) {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            for(Character c : defaultMemberList){
                oos.writeObject(c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int createCharacter(Character character) {
        MyObjectOutput moo = null;
        int result = 0;
        try {

            moo = new MyObjectOutput(new BufferedOutputStream(new FileOutputStream(file, true)));
            moo.writeObject(character);
            moo.flush(); //내부적으로 Buffered를 쓰고 있으니 객체 출력 강제화

            characters.clear();
            loadCharacters();

            result = 1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(moo != null) moo.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return result;
    }


    private void loadCharacters() {
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));

            while(true){
                characters.add((Character) ois.readObject());
            }

        } catch (EOFException e) {
            System.out.println("캐릭터 정보 읽어오기 완료!");
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        } finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public ArrayList<Character> findAllCharacters(String id) {
        ArrayList<Character> returnList = new ArrayList<>();
        for(Character c : characters){
            if(id.equals(c.getId())){
                returnList.add(c);
            }
        }

        return returnList;
    }
}


