package item05;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/15
 * Time : 12:58 AM
 */

public class MemberService {
    private final MemberRepository memberRepository;

    // 생성자 주입 방식 (memberRepository는 MemberService가 인스턴스화 후 변경되지 않음이 보장된다.
    public MemberService(MemberRepository memberRepository) {
       this.memberRepository = memberRepository;
    }

    public MemberRepository currentMemberRepository() {
        return memberRepository;
    }
}
