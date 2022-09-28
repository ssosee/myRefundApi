package seaung.myrefundapi.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import seaung.myrefundapi.domain.entity.Member;
import seaung.myrefundapi.domain.service.LoginService;
import seaung.myrefundapi.domain.service.form.LoginForm;
import seaung.myrefundapi.domain.service.form.SignupForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/myrefund/api/v1")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/signup")
    public ResponseForm signup(@RequestBody @Valid SignupForm signupForm, BindingResult bindingResult) {

        ResponseForm form = new ResponseForm();

        if(bindingResult.hasErrors()) {
            form.setStatus(HttpStatus.BAD_REQUEST.toString());
            form.setMessage("회원가입 실패");
            form.setError("회원가입 정보를 확인해주세요.");
            form.setData(new HashMap<String, String>().put("user_id", signupForm.getUserId()));
            log.warn(bindingResult.getAllErrors().toString());
            return form;
        }

        String signupMember = loginService.signup(signupForm);
        form.setStatus(HttpStatus.OK.toString());
        form.setMessage("회원가입 완료");
        form.setData(new HashMap<String, String>().put("user_id", signupMember));

        return form;
    }

    @PostMapping("/login")
    public ResponseForm login(@RequestBody @Valid LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request) {

        ResponseForm form = new ResponseForm();

        if(bindingResult.hasErrors()) {
            form.setStatus(HttpStatus.BAD_REQUEST.toString());
            form.setMessage("로그인 실패");
            form.setError("아이디 또는 비밀번호를 확인해주세요.");
            form.setData(new HashMap<String, String>().put("user_id", loginForm.getUserId()));

            return form;
        }

        Optional<Member> loginMember = loginService.login(loginForm);
        if(loginMember == null) {
            form.setStatus(HttpStatus.BAD_REQUEST.toString());
            form.setMessage("로그인 실패");
            form.setError("아이디 또는 비밀번호를 ");
            form.setData(new HashMap<String, String>().put("user_id", loginForm.getUserId()));

            return form;
        }

        HttpSession session = request.getSession(true);
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        form.setStatus(HttpStatus.OK.toString());
        form.setMessage("로그인 완료");
        form.setData(new HashMap<String, String>().put("user_id", loginForm.getUserId()));

        return form;
    }

}
