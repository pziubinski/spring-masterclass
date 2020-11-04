package pl.training.shop.payments;

import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class HashMapPaymentRepository implements PaymentRepository {

    @Setter
    private Map<String, Payment> payments = new HashMap<>();

    @Override
    public Payment save(Payment payment) {
        payments.put(payment.getId(), payment);
        return payment;
    }

}
