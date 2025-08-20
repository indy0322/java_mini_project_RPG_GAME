package com.rpggame.repository;

import com.rpggame.aggregate.Member;
import com.rpggame.stream.MyObjectOutput;

import java.io.*;
import java.util.ArrayList;

public class MemberRepository {

    private final ArrayList<Member> members = new ArrayList<Member>();
    private final File file = new File("src/main/java/com/rpggame/db/memberDB.dat");

    public MemberRepository() {
        if(!file.exists()){
            ArrayList<Member> defaultMemberList = new ArrayList<>();
            defaultMemberList.add(new Member(1,"user01","pass01"));
            defaultMemberList.add(new Member(2,"user02","pass02"));
            defaultMemberList.add(new Member(3,"user03","pass03"));

            saveMembers(defaultMemberList);
        }

        loadMembers();

    }

    private void saveMembers(ArrayList<Member> defaultMemberList) {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            for(Member member : defaultMemberList){
                oos.writeObject(member);
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

    private void loadMembers() {
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));

            while(true){
                members.add((Member)ois.readObject());
            }

        } catch (EOFException e) {
            System.out.println("회원 정보 읽어오기 완료!");
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

    public int registMember(Member registMember) {
        MyObjectOutput moo = null;
        int result = 0;
        try {

            moo = new MyObjectOutput(new BufferedOutputStream(new FileOutputStream(file, true)));
            moo.writeObject(registMember);
            moo.flush(); //내부적으로 Buffered를 쓰고 있으니 객체 출력 강제화

            members.clear();
            loadMembers();

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

    public int findLastMemberNo() {
        return members.get(members.size()-1).getMemNo();
    }

    public int loginMember(Member loginMember) {
        int result = 0;
        for(Member member : members){
            if(loginMember.getId().equals(member.getId())) {
                if(loginMember.getPwd().equals(member.getPwd())) {
                    result = 1;
                    return result;
                }
            }
        }
        return result;
    }

}
