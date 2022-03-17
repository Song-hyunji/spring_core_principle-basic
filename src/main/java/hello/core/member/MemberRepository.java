package hello.core.member;

//회원 저장소 인터페이스
public interface MemberRepository {
    
    void save(Member member);  //멤버 저장
    Member findById(Long memberId); //멤버id로 멤버찾기
}
