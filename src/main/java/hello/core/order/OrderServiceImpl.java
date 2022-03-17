package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

//주문 서비스 구현체
//메모리 회원 리포지토리, 고정 금액 할인 정책을 구현체로 생성
//주문 생성 요청이 오면, id로 회원 정보를 조회하고, 할인정책을 적용한 다음, 주문 객체 생성해서 반환

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    //주문이 들어오면 멤버를 만들어주고, 그 멤버의 할인을 확인하기 위해 할인에 넘겨주고.
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //최종적으로 할인된 가격을 받아옴

        //주문을 만들어서 주문 반환
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
