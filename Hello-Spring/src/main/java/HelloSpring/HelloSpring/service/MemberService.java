package HelloSpring.HelloSpring.service;

import HelloSpring.HelloSpring.domain.Member;
import HelloSpring.HelloSpring.repository.MemberRepository;
import HelloSpring.HelloSpring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {

    private final MemberRepository memberRepository;
    //@Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * 회원가입
     */
    public Long join(Member member){
        //같은 이름이 있는 중복 회원X
        /**
         *
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m1 -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
         */
        //ctrl + alt + shift + T ==> extract method 하면 외부로 함수 뽑아냄
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m1 -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }


    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
