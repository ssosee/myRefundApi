package seaung.myrefundapi.domain.service;

import seaung.myrefundapi.domain.entity.Refund;
import seaung.myrefundapi.domain.service.form.RefundForm;

import java.util.Optional;

public interface RefundService {
    Optional<Refund> createRefund(String userId, RefundForm refundForm);
}
