package com.loopy.springbasic;

import com.loopy.springbasic.repository.JdbcMemberRepository;
import com.loopy.springbasic.repository.JdbcTemplateMemberRepository;
import com.loopy.springbasic.repository.JpaMemberRepository;
import com.loopy.springbasic.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.swing.text.html.parser.Entity;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    private final EntityManager em;

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(DataSource dataSource, EntityManager em, MemberRepository memberRepository) {
        this.em = em;
        this.dataSource = dataSource;
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
//
////        return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
