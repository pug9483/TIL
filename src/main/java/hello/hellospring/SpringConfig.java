package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// command + p : 인자로 들어가야 할 변수의 자료형을 알 수 있음

@Configuration
public class SpringConfig {

    // 스프링 빈에 등록할 것이란 뜻
    @Bean
    public MemberService memberService(){
        // 스프링 빈에 등록되어 있는 memberRepository를 memberService에 넣어준다.
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
