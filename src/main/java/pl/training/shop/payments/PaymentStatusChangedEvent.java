package pl.training.shop.payments;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class PaymentStatusChangedEvent extends ApplicationEvent {

    @Getter
    private final Payment payment;

    public PaymentStatusChangedEvent(Object source, Payment payment) {
        super(source);
        this.payment = payment;
    }

}
