package seaung.myrefundapi.api.controller;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seaung.myrefundapi.domain.entity.Member;
import seaung.myrefundapi.domain.entity.Refund;
import seaung.myrefundapi.domain.service.RefundService;
import seaung.myrefundapi.domain.service.form.RefundForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/myrefund/api/v1")
public class RefundController {

    private final RefundService refundService;
    @PostMapping("/find/refund")
    public ResponseForm refund(@RequestBody @Valid RefundForm refundForm, BindingResult bindingResult, HttpServletRequest request) {

        ResponseForm form = new ResponseForm();

        HttpSession session = request.getSession(false);
        if(session == null) {
            form.setStatus(HttpStatus.BAD_REQUEST.value());
            form.setMessage("환급액 조회 실패");
            form.setError("로그인 정보를 확인해주세요.");

            return form;
        }

        Optional<Member> loginMember = (Optional<Member>) session.getAttribute(SessionConst.LOGIN_MEMBER);
        Optional<Refund> refund = refundService.createRefund(loginMember.get().getUserId(), refundForm);

        if(bindingResult.hasErrors()) {
            form.setStatus(HttpStatus.BAD_REQUEST.value());
            form.setMessage("환급액 조회 실패");
            form.setError(bindingResult.getFieldError().getDefaultMessage());
        }

        form.setStatus(HttpStatus.OK.value());
        form.setMessage("환급액 조회 완료");
        form.setData(new DataDto(loginMember.get().getUserId(), String.format("%,d", (int) refund.get().getRefund())+"원"));

        return form;
    }

    @Getter @Setter
    @AllArgsConstructor
    static class DataDto {
        private String user_id;
        private String refund;
    }
}
