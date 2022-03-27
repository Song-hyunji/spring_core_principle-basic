package hello.core;

import hello.core.discount.FixDiscountPolicy;
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
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
