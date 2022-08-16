package com.loopy.springbasic.repository;

import com.loopy.springbasic.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void saveTest(){
        Member member = new Member();
        member.setName("test_1");

        Member savedMember = repository.save(member);
        Assertions.assertThat(member).isEqualTo(savedMember);

    }

    @Test
    public void FindByIdTest(){
        Member member1 = new Member();
        member1.setName("test_1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("test_2");
        repository.save(member2);

        Assertions.assertThat(member1).isEqualTo(repository.findById(member1.getId()).get());
    }

    @Test
    public void FindByNameTest(){
        Member member1 = new Member();
        member1.setName("test_1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("test_2");
        repository.save(member2);

        Assertions.assertThat(member1).isEqualTo(repository.findByName(member1.getName()).get());
    }

    @Test
    public void FindAllTest(){
        Member member1 = new Member();
        member1.setName("test_1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("test_2");
        repository.save(member2);

        List<Member> list = repository.findAll();

        Assertions.assertThat(list.size()).isEqualTo(2);
    }
}
