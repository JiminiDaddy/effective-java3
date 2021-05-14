package item05;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/15
 * Time : 1:04 AM
 */

public class MemberServiceTest {
    @Test
    @DisplayName("MemberServicer의 의존주입 확인")
    void checkMemberServiceDependencyInjection() {
        MemberRepository memberRepository1 = new MemoryMemberRepository();
        MemberService memberService1 = new MemberService(memberRepository1);
        MemberRepository currentMemberRepository1 = memberService1.currentMemberRepository();
        // 자원이 변하지 않고 불변임이 확인된다.
        Assertions.assertThat(memberRepository1).isSameAs(currentMemberRepository1);

        MemberService memberService2 = new MemberService(memberRepository1);
        MemberRepository currentMemberRepository2 = memberService2.currentMemberRepository();
        Assertions.assertThat(currentMemberRepository1).isSameAs(currentMemberRepository2);

        // MemberService 1과 2는 서로 다른 인스턴스이므로 멀티 스레드에서 문제 없이 사용 가능하다.
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }
}
