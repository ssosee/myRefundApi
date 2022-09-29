package seaung.myrefundapi.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seaung.myrefundapi.domain.entity.Member;
import seaung.myrefundapi.domain.entity.Refund;
import seaung.myrefundapi.domain.repository.MemberRepository;
import seaung.myrefundapi.domain.repository.RefundRepository;
import seaung.myrefundapi.domain.service.form.RefundForm;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RefundServiceImpl implements RefundService {

    private final static float manWon = 10000f;
    private final RefundRepository refundRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Optional<Refund> createRefund(String userId, RefundForm refundForm) {

        float calculatedTaxAmount = getCalculatedTaxAmount(refundForm.getSalary());
        float deductedAmount = getDeductedAmount(calculatedTaxAmount);
        float determinedTaxAmount = getDeterminedTaxAmount(calculatedTaxAmount, deductedAmount);
        float result = determinedTaxAmount - refundForm.getTax();
        log.info("산출세액={}, 세액공제액={}, 결정세액={}", calculatedTaxAmount, deductedAmount, determinedTaxAmount);

        Optional<Member> findMember = memberRepository.findFirstByUserId(userId);


        Refund refund = Refund.builder()
                .tax(refundForm.getTax())
                .salary(refundForm.getSalary())
                .year(LocalDateTime.now().getYear())
                .refund(result*-1f)
                .member(findMember.get())
                .build();

        refundRepository.save(refund);

        return Optional.of(refund);
    }

    /**
     * <a href="https://www.nts.go.kr/nts/cm/cntnts/cntntsView.do?mi=6594&cntntsId=7873">산출세액 계산</a>
     */
    private float getCalculatedTaxAmount(float salary) {

        if(salary < 0f) throw new IllegalArgumentException("근로소득이 음수 입니다.");

        /**
         * 1200만원 이하
         */
        if(salary <= 1200*manWon) return salary*0.06f;
        /**
         * 1200 ~ 4600만원
         */
        else if(salary <= 4600*manWon) return 72*manWon + (salary-1200*manWon)*0.15f;
        /**
         * 4600 ~ 8800만원
         */
        else if(salary <= 8800*manWon) return 582*manWon + (salary-4600*manWon)*0.24f;
        /**
         * 8800 ~ 15000만원
         */
        else if(salary <= 15000*manWon) return 1590*manWon + (salary-8800*manWon)*0.35f;
        /**
         * 15000 ~ 30000만원
         */
        else if(salary <= 30000*manWon) return 3760*manWon + (salary-15000*manWon)*0.38f;
        /**
         * 30000 ~ 50000만원
         */
        else if(salary <= 50000*manWon) return 9460*manWon + (salary-30000*manWon)*0.40f;
        /**
         * 50000 ~ 100000만원
         */
        else if(salary <= 100000*manWon) return 17460*manWon + (salary-50000*manWon)*0.42f;
        /**
         * 100000만원 ~
         */
        return 38460*manWon + (salary-100000*manWon)*0.45f;
    }

    /**
     * <a href="https://www.nts.go.kr/nts/cm/cntnts/cntntsView.do?mi=6596&cntntsId=7875">세액공제액 계산</a>
     */
    private float getDeductedAmount(float calculatedTaxAmount) {
        if(calculatedTaxAmount <= 130*manWon) return calculatedTaxAmount*0.55f;
        return 71.5f*manWon + (calculatedTaxAmount - 130*manWon)*0.30f;
    }

    /**
     * <a href="https://www.nts.go.kr/nts/cm/cntnts/cntntsView.do?mi=6591&cntntsId=7870">결정세액 계산</a>
     */
    private float getDeterminedTaxAmount(float calculatedTaxAmount, float deductedAmount) {
        return calculatedTaxAmount - deductedAmount;
    }
}
