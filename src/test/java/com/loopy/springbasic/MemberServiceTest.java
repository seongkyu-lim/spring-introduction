package com.loopy.springbasic;

import com.loopy.springbasic.domain.Member;
import com.loopy.springbasic.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService service;
    MemoryMemberRepository repository;

    @BeforeEach
    public void beforeEach(){
        repository = new MemoryMemberRepository();
        service = new MemberService(repository);
    }

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }


    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("test_1");
        //when
        Long savedId = service.join(member);
        //then
        Member findMember = service.findOne(savedId).get();
        Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    void 중복회원_회원가입_예외(){
        //given
        Member member1 = new Member();
        member1.setName("test_1");

        Member member2 = new Member();
        member2.setName("test_1" );
        //when
        service.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, ()->service.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다.");

//        try{
//            service.join(member2);
//            fail("예외가 발생해야 합니다.");
//        }catch (IllegalStateException e){
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다.");
//        }

        //then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}