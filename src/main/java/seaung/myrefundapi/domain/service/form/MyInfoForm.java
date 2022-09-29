package seaung.myrefundapi.domain.service.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MyInfoForm {
    private String userId;
    @JsonProperty("refunds")
    private List<Refunds> refundForm;
}
