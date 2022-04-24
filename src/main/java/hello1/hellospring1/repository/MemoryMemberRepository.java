package hello1.hellospring1.repository;

import hello1.hellospring1.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;


public class MemoryMemberRepository  implements MemberRepository{
    
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); 
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();  //돌면서 name이 같으면 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //멤버들이 반환
    }

    public void clearStore(){
        store.clear();
    }
}
