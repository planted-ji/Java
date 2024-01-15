package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private  static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // 키값 생성
    @Override
    public Member save(Member member) {
        member.setId(++sequence); // id 값 세팅
        store.put(member.getId(), member); // store에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // null이 나올 경우를 대비해 감싸줌
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) // member.getName이 파라미터로 넘어온 name과 같은지 확인
                .findAny(); // 찾을 경우 반환, 끝까지 돌려도 없으면 optional에 null이 포함되어 반환.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}