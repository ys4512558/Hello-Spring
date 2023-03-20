package HelloSpring.HelloSpring.controller;

import HelloSpring.HelloSpring.domain.Member;
import HelloSpring.HelloSpring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    //Autowired == 매개변수인 memberService를
    // 스프링의 container의 memberService를 자동으로 연결해줌
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public  String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        
        return "redirect:/"; //홈화면으로 이동시키기
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
