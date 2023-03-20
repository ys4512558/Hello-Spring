package HelloSpring.HelloSpring;

import HelloSpring.HelloSpring.repository.MemberRepository;
import HelloSpring.HelloSpring.repository.MemoryMemberRepository;
import HelloSpring.HelloSpring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
