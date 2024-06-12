package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // Optional : null값을 Optional로 감싸서 반환 가능
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 저장된 모든 회원 리스트 반환
}
