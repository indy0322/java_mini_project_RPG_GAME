package com.rpggame.run;

import com.rpggame.aggregate.Member;
import com.rpggame.service.MemberService;
import com.rpggame.service.CharacterService;
import com.rpggame.aggregate.Character;

import java.util.Scanner;

public class Application {

    private static final MemberService ms = new MemberService();
    private static final CharacterService cs = new CharacterService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loginCheck = 0;

        while (true) {
            System.out.println("==================== 환영합니다. ============================");
            System.out.print("회원가입을 하셨습니까? (yes/no):");
            String answer = sc.nextLine();

            if(answer.equalsIgnoreCase("yes")){
                loginCheck = ms.loginMember(login());
                if(loginCheck == 1){
                    break;
                }else{
                    System.out.println("다시 로그인해주세요.");
                }

            }else if(answer.equalsIgnoreCase("no")){
                ms.registMember(regist());
                break;
            }else{
                System.out.println("다시 입력해주세요.");
            }
        }

        System.out.println("========================= RPG GAME =============================");

        int characterCheck = 0;

        while(true){
            System.out.print("캐릭터를 생성하시겠습니까? (yes/no): ");
            String answer = sc.nextLine();

            if(answer.equalsIgnoreCase("yes")){
                characterCheck = cs.createCharacter(createChar());
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
        cs.findAllCharacter(SearchChar());




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
}
