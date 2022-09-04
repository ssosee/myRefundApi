package seaung.myrefundapi.domain.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableDefault;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class RefundRepositoryTest {
    @Autowired
    private RefundRepository refundRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void test() {
        refundRepository.findRefundsByMember();
    }
}