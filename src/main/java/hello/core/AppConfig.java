package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//앱 전체를 구성하고 설계
public class AppConfig {

    //생성자를 통해서 구현체를 결정함. (Impl에 생성자 주입)
    public MemberService memberService(){
        //MemberServiceImpl을 만들고, 내가 만든 것에는 MemoryMemberRepository를 주입할거야
        return new MemberServiceImpl(memberRepository());
    }

    //주문서비스로 회원구현체, 할인정책 사용
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //회원구현체 객체 생성
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    //할인정책으로 고정할인을 사용하는구나
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
