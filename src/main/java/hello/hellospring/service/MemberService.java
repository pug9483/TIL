package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/*자동 줄맞춤 : option + cmd + L
테스트 코드 만들기 : cmd + shift + T
cmd + option + v : 변수명 알아서 지정*/

// 스프링에 올라올 때, 이것을 스프링 컨테이너에 등록하게 된다.

// 데이터를 저장하거나 변경할 때는 항상 @Transactional이 있어야 한다.
@Transactional
public class MemberService {
    // 회원 리포지토리 필요
    private final MemberRepository memberRepository;

    /* 맴버 서비스는 맴버 레포지토리가 필요하다. */
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원 가입
    public Long join(Member member) {

        // Optional<Member> result = memberRepository.findByName(member.getName());

        // Optional의 ifPresent메소드 : null이 아니라 값이 있으면 동작한다.
        // result.ifPresent(m -> {
        //    throw new IllegalStateException("이미 존재하는 회원입니다.");
        //});
        // Optional 꺼내기(권장 x) : result.get();
        // 값이 있으면 꺼내고 없으면 디폴트 값 실행 : result.orElseGet(Supplier<? extends Member) supplier) Member)

        //권장
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();

    }

    // 메소드로 뽑는 것이 좋음 : control + T
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                // 같은 이름이 있는 중복 회원 x
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
