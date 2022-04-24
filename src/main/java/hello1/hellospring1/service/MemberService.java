package hello1.hellospring1.service;

import hello1.hellospring1.domain.Member;
import hello1.hellospring1.repository.MemberRepository;
import hello1.hellospring1.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MemberService {

    private final MemberRepository memberRepository;


    public MemberService(MemoryMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member) {

        validateDuplicateMember(member); // 중복회원 검증
        memberRepository.save(member);
        return member.getId();

    }
    private  void validateDuplicateMember(Member member){
        memberRepository.findByName(member.getName())
        .ifPresent(me -> {
            throw  new IllegalStateException("이미 존재하는 회원입니다. ");
        });

    }

    //전제 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }


}