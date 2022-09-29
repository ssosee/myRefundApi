package seaung.myrefundapi.domain.service;

import seaung.myrefundapi.domain.entity.Member;
import seaung.myrefundapi.domain.service.form.LoginForm;
import seaung.myrefundapi.domain.service.form.MyInfoForm;
import seaung.myrefundapi.domain.service.form.SignupForm;

import java.util.Optional;

public interface LoginService {
    String signup(SignupForm signupForm);
    Optional<Member> login(LoginForm loginForm);
    Optional<MyInfoForm> myInfo(String userId);
}
