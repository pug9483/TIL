package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// 가장 최근에 본 것 : command + E
import java.util.List;

// 스프링 컨테이너에 @Controller가 있으면 MemberController객체를 생성하며 스프링에 넣고 관리한다.
@Controller
public class MemberController {

    private final MemberService memberService;

    /*맴버 컨트롤러는 스프링 컨테이너가 뜰 때 생성된다. 그 때 생성자 호출을 하는데 생성자에 @Autowired라고 되어 있으면
    스프링 컨테이너에 있는 맴버 서비스를 가져다가 연결을 시켜준다.
    컨트롤러와 서비스를 연결시켜 주어야 한다.(@Autowired사용)
    맴버 컨트롤러가 생성이 될 때, 스프링 빈에 등록되어 있는 맴버 서비스 객체를 가져다가 등록시켜 준다. -> 의존 관계 주입(Dependency Injection)*/
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new") // 조회
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new") // 데이터 전달
    public String create(MemberForm form){ // MemberForm의 setName()을 통해 name필드에 데이터가 저장된다.
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        // home 화면으로 보내기
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
