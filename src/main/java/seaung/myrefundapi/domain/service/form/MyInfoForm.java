package seaung.myrefundapi.domain.service.form;

import lombok.Data;

import java.util.List;

@Data
public class MyInfoForm {
    private String userId;
    private List<RefundForm> refundForm;
}
