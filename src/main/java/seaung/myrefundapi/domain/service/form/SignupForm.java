package seaung.myrefundapi.domain.service.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class SignupForm {
    @NotBlank
    @JsonProperty("user_id")
    private String userId;
    @NotBlank
    private String password;
    @Email(message = "메일 양식을 지켜주세요")
    @NotBlank
    private String email;
    @NotBlank
    @Pattern(regexp = "[0-9]{10,11}",
            message = "10 ~ 11 자리의 숫자만 입력 가능합니다.")
    private String phone;
}
