package HelloSpring.HelloSpring.repository;

import HelloSpring.HelloSpring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("First_Member");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //직접 출력해서 결과 확인하기
        //System.out.println("result = " + (result == member));
        //Assertions 둘 비교 해서 같다면 테스트 성공 다르면 테스트 실패뜸
        Assertions.assertEquals(member, result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("First Member");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Second Member");
        repository.save(member2);

        Member result = repository.findByName("First Member").get();

        Assertions.assertEquals(member1, result);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        Assertions.assertEquals(result.size(), 2);
    }
}
