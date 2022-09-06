package seaung.myrefundapi.api.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class LoginForm {
    @NotBlank
    private String userId;
    @NotBlank
    private String password;
    @Email
    private String email;
    @NotBlank
    @Pattern(regexp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$",
            message = "10 ~ 11 자리의 숫자만 입력 가능합니다.")
    private String phone;
}
