package com.rpggame.run;

import com.rpggame.aggregate.Member;
import com.rpggame.service.MemberService;

import java.util.Scanner;

public class Application {

    private static final MemberService ms = new MemberService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loginCheck = 0;

        while (true) {
            System.out.println("======== 환영합니다. ==========");
            System.out.println("회원가입을 하셨습니까? (yes/no):");
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


    }

    private static Member login() {
        System.out.println("로그인을 해주시기 바랍니다.");
        Scanner sc = new Scanner(System.in);
        System.out.print("id: ");
        String id = sc.nextLine();
        System.out.print("password: ");
        String pwd = sc.nextLine();

        Member loginMember = new Member();
        loginMember.setId(id);
        loginMember.setPwd(pwd);

        return loginMember;
    }

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
}
