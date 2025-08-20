package com.rpggame.service;

import com.rpggame.aggregate.Member;
import com.rpggame.repository.MemberRepository;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService() {
        this.memberRepository = new MemberRepository();
    }

    public int registMember(Member registMember) {
        int lastNo = memberRepository.findLastMemberNo();
        registMember.setMemNo(lastNo + 1);

        int result = memberRepository.registMember(registMember);

        if(result == 1){
            System.out.println(registMember.getId() + "회원님 환영합니다!");
            return 1;
        }else{
            System.out.println("회원 가입 실패");
            return 0;
        }
    }

    public int loginMember(Member loginMember) {
        int result = memberRepository.loginMember(loginMember);

        if(result == 1){
            System.out.println(loginMember.getId() + "회원님 환영합니다!");
            return 1;
        }else{
            System.out.println("로그인 실패");
            return 0;
        }
    }
}
