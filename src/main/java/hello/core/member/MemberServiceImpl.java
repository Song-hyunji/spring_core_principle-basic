package hello.core.member;

//회원 서비스 구현체 (가입, 조회)
public class MemberServiceImpl implements MemberService{

    //배우가 직접 역할을 선택하는 코드
    //private final MemberRepository memberRepository = new MemoryMemberRepository();

    //DIP를 지키는 추상화 코드
    private final MemberRepository memberRepository;

    //생성자를 통해서 MemberRepository의 구현체를 결정함
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
