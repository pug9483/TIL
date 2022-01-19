package hello.core.order;

import hello.core.discount.DiscountPolice;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    // 맴버 레포지토리에서 회원 찾아야 한다.
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 할인 정책 필요
    private final DiscountPolice discountPolice = new FixDiscountPolicy(); // 고정 할인 정책 사용

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolice.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
