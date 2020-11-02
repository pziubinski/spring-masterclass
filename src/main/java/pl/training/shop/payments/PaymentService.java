package pl.training.shop.payments;

public interface PaymentService {
    Payment process(PaymentRequest paymentRequest);
}
