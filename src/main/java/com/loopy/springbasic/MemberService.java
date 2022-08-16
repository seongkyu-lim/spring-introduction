package com.loopy.springbasic;

import com.loopy.springbasic.domain.Member;
import com.loopy.springbasic.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemoryMemberRepository repository;

    public MemberService(MemoryMemberRepository repository) {
        this.repository = repository;
    }

    public Long join(Member member){
        //같은 이름의 중복회원 x
        validateDuplicateMember(member);

        repository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        repository.findByName(member.getName())
                .ifPresent(m ->{
                    throw new IllegalStateException("이미 존재하는 이름입니다.");
                });
    }

    public List<Member> findMembers(){
        return repository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return repository.findById(memberId);
    }
}
