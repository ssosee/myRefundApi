package seaung.myrefundapi.domain.service.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginForm {

    @NotBlank
    @JsonProperty("user_id")
    private String UserId;
    @NotBlank
    private String password;

    @Builder
    public LoginForm(String userId, String password) {
        UserId = userId;
        this.password = password;
    }
}
