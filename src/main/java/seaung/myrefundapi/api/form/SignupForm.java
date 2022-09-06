package seaung.myrefundapi.api.form;

import lombok.Builder;
import lombok.Data;

@Data
public class SignupForm {
    private String UserId;
    private String password;

    @Builder
    public SignupForm(String userId, String password) {
        UserId = userId;
        this.password = password;
    }
}
