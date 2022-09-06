package seaung.myrefundapi.domain.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableDefault;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import seaung.myrefundapi.domain.entity.Member;
import seaung.myrefundapi.domain.entity.Refund;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class RefundRepositoryTest {
    @Autowired
    RefundRepository refundRepository;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("환급액 조회 쿼리 테스트")
    void findRefundsByMemberTest() {
        Member member1 = Member.builder()
                .userId("dlwlrma")
                .email("dlwlrma@kakao.com")
                .phone("01065228834")
                .password("dlwlrma")
                .build();

        Member member2 = Member.builder()
                .userId("dlwlrma2")
                .email("dlwlrma2@kakao.com")
                .phone("01165228834")
                .password("dlwlrma2")
                .build();

        Refund refund1 = Refund.builder()
                .tax(100)
                .refund(10L)
                .salary(100)
                .year(2022)
                .member(member1)
                .build();

        Refund refund2 = Refund.builder()
                .tax(200)
                .refund(20L)
                .salary(200)
                .year(2021)
                .member(member1)
                .build();

        memberRepository.save(member1);
        memberRepository.save(member2);
        refundRepository.save(refund1);
        refundRepository.save(refund2);

        List<Refund> dlwlrma = refundRepository.findRefundsByMember("dlwlrma");

        assertThat(dlwlrma.get(0).getYear()).isEqualTo(2022);
        assertThat(dlwlrma.get(1).getYear()).isEqualTo(2021);
    }
}