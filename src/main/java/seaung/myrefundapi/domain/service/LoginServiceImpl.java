package seaung.myrefundapi.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import seaung.myrefundapi.domain.entity.Member;
import seaung.myrefundapi.domain.entity.Refund;
import seaung.myrefundapi.domain.repository.MemberRepository;
import seaung.myrefundapi.domain.repository.RefundRepository;
import seaung.myrefundapi.domain.service.form.LoginForm;
import seaung.myrefundapi.domain.service.form.MyInfoForm;
import seaung.myrefundapi.domain.service.form.RefundForm;
import seaung.myrefundapi.domain.service.form.SignupForm;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final MemberRepository memberRepository;
    private final RefundRepository refundRepository;

    @Override
    public String signup(SignupForm signupForm) {

        validationUserId(signupForm);

        Member member = Member.builder()
                .userId(signupForm.getUserId())
                .password(signupForm.getPassword())
                .email(signupForm.getEmail())
                .phone(signupForm.getPhone())
                .build();

        memberRepository.save(member);

        log.info("회원가입 완료");

        return signupForm.getUserId();
    }

    private void validationUserId(SignupForm signupForm) {
        Optional<Member> firstByUserId = memberRepository.findFirstByUserId(signupForm.getUserId());
        if(!firstByUserId.isEmpty()) throw new IllegalArgumentException("이미 존재하는 아이디 입니다.");
    }

    @Override
    public Optional<Member> login(LoginForm loginForm) {
        Optional<Member> loginMember = memberRepository.findFirstByUserIdAndPassword(loginForm.getUserId(), loginForm.getPassword());
        //if(loginMember.isEmpty()) throw new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다.");
        return loginMember;
    }

    @Override
    public Optional<MyInfoForm> myInfo(String userId) {

        List<Refund> refundsByMember = refundRepository.findRefundsByMember(userId);

        MyInfoForm myInfoForm = new MyInfoForm();
        List<RefundForm> refundForms = new ArrayList<>();
        for(Refund r : refundsByMember) {
            RefundForm refundForm = new RefundForm();
            refundForm.setRefund(r.getRefund());
            refundForm.setYear(r.getYear());
            refundForms.add(refundForm);
        }
        myInfoForm.setRefundForm(refundForms);
        myInfoForm.setUserId(userId);

        return Optional.of(myInfoForm);
    }
}
