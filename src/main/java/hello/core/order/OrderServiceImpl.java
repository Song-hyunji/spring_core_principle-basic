package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

//주문 서비스 구현체
//메모리 회원 리포지토리, 고정 금액 할인 정책을 구현체로 생성
//주문 생성 요청이 오면, id로 회원 정보를 조회하고, 할인정책을 적용한 다음, 주문 객체 생성해서 반환

public class OrderServiceImpl implements OrderService{

    //구체화에 의존하지 않고 추상화인 인터페이스만 의존 (배우는 역할을 부여받아야한다. 직접 선택하면X(직접 객체생성X)
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    
    //생성자를 통해 구현체가 할당됨 -> DIP 지킴
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //주문이 들어오면 멤버를 만들어주고, 그 멤버의 할인을 확인하기 위해 할인에 넘겨주고.
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //최종적으로 할인된 가격을 받아옴

        //주문을 만들어서 주문 반환
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
