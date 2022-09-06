package seaung.myrefundapi.api.service;

import seaung.myrefundapi.api.form.LoginForm;
import seaung.myrefundapi.api.form.MyInfoForm;
import seaung.myrefundapi.api.form.SignupForm;

import java.util.Optional;

public interface LoginService {
    String signup(SignupForm signupForm);
    String login(LoginForm loginForm);
    Optional<MyInfoForm> myInfo();
}
