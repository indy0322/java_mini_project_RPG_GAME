package com.rpggame.run;

import com.rpggame.aggregate.Member;
import com.rpggame.aggregate.Monster;
import com.rpggame.service.MemberService;
import com.rpggame.service.CharacterService;
import com.rpggame.aggregate.Character;
import com.rpggame.service.MonsterService;

import java.util.Scanner;

public class Application {

    private static final MemberService ms = new MemberService();
    private static final CharacterService cs = new CharacterService();
    private static final MonsterService mos = new MonsterService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int monsterNumber = 3;

        while (true) {
            System.out.println("==================== 환영합니다. ============================");
            System.out.print("회원가입을 하셨습니까? (yes/no):");
            String answer = sc.nextLine();
            int loginCheck = 0;

            if(answer.equalsIgnoreCase("yes")){
                loginCheck = ms.loginMember(login());
                if(loginCheck == 1){
                    break;
                }else{
                    System.out.println("다시 로그인해주세요.");
                }

            }else if(answer.equalsIgnoreCase("no")){
                ms.registMember(regist());
                loginCheck = ms.loginMember(login());
                if(loginCheck == 1){
                    break;
                }else{
                    System.out.println("다시 로그인해주세요.");
                }
            }else{
                System.out.println("다시 입력해주세요.");
            }
        }

        System.out.println("========================= RPG GAME =============================");

        while(true){
            System.out.print("캐릭터를 생성하시겠습니까? (yes/no): ");
            String answer = sc.nextLine();

            if(answer.equalsIgnoreCase("yes")){
                int characterCheck = cs.createCharacter(createChar());
                if(characterCheck == 1){
                    System.out.println("캐릭터가 생성되었습니다.");
                    break;
                }else{
                    System.out.println("다시 캐릭터를 만들어주세요.");
                }

            }else if(answer.equalsIgnoreCase("no")){
                break;
            }else{
                System.out.println("다시 입력해주세요.");
            }
        }

        System.out.println("===================== 캐릭터 목록 ============================");
        while(true) {

            int result = cs.findAllCharacter(SearchChar());
            if (result == 0) {
                while (true) {
                    int characterCheck = cs.createCharacter(createChar());
                    if (characterCheck == 1) {
                        System.out.println("캐릭터가 생성되었습니다.");
                        break;
                    } else {
                        System.out.println("다시 캐릭터를 만들어주세요.");
                    }
                }
            } else {
                break;
            }
        }

        System.out.println("===================== 캐릭터 선택 ============================");

        Character playChar = cs.choiceCharacter(loginId,choiceChar());

        System.out.println("탑을 공략하세요.");

        while(true) {
            System.out.println("============== " + playChar.getTower() + "층 =================");
            System.out.println("몬스터를 조우했습니다.");
            Monster monster = mos.getRandomMonster(monsterNumber);

            System.out.println(monster.getName() + " 이(가) 나타났습니다.");
            System.out.println(monster.toString());

            while (true) {
                System.out.println("=============================");
                System.out.println("1. 공격하기");
                System.out.println("2. 도망가기");
                System.out.println("3. 회복하기");
                System.out.println("=============================");
                int choice = sc.nextInt();
                if (choice == 1) {
                    cs.deal(monster, playChar);
                    if (monster.getHp() <= 0) {
                        System.out.println(monster.getName() + "이(가) 죽었습니다.");

                        if(playChar.getTower() > 10){
                            System.out.println("타워를 공략하셨습니다.");
                            System.out.println("게임이 종료됩니다.");
                            return;
                        }else{
                            monsterNumber = monsterNumber + 1;
                            cs.modifyStatus(playChar);
                        }
                        break;
                    } else {
                        mos.monsterRandomMotion(monster, playChar);
                        if (playChar.getHp() <= 0) {
                            System.out.println(playChar.getName() + " 이(가) 죽었습니다.");
                            System.out.println("게임이 종료됩니다.");
                            cs.deleteCharacter(playChar);
                            return;
                        }
                    }
                } else if (choice == 2) {
                    System.out.println(playChar.getName() + " 이(가) 도망쳤습니다.");
                    System.out.println("게임이 종료됩니다.");
                    return;
                } else if (choice == 3) {
                    cs.heal(playChar);
                } else {
                    System.out.println("제대로된 선택지를 고르세요.");
                }
            }
        }
    }


    //로그인 메서드
    static String loginId;

    private static Member login() {
        System.out.println("로그인을 해주시기 바랍니다.");
        Scanner sc = new Scanner(System.in);
        System.out.print("id: ");
        loginId = sc.nextLine();
        System.out.print("password: ");
        String pwd = sc.nextLine();

        Member loginMember = new Member();
        loginMember.setId(loginId);
        loginMember.setPwd(pwd);

        return loginMember;
    }


    //회원가입 메서드
    private static Member regist() {
        System.out.println("회원가입을 해주시기 바랍니다.");
        Scanner sc = new Scanner(System.in);
        System.out.print("id: ");
        String id = sc.nextLine();
        System.out.print("password: ");
        String pwd = sc.nextLine();

        Member registMember = new Member();
        registMember.setId(id);
        registMember.setPwd(pwd);

        return registMember;
    }

    //캐릭터 생성 메서드
    private static Character createChar() {
        System.out.println("캐릭터명을 지정해 주세요.");
        Scanner sc = new Scanner(System.in);
        System.out.println("name: ");
        String name = sc.nextLine();

        Character character = new Character(name,loginId);

        return character;
    }

    //캐릭터 불러오기 메서드
    private static String SearchChar() {
        return loginId;
    }

    //캐릭터 선택 메서드
    private static String choiceChar() {
        System.out.println("캐릭터를 선택해주세요");
        Scanner sc = new Scanner(System.in);
        String choiceChar = sc.nextLine();
        return choiceChar;
    }


}
