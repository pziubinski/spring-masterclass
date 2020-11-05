package pl.training.shop.payments;

import lombok.extern.java.Log;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Log
public class PaymentStatusChangedListener {

    @Async
    @EventListener
    public void onPaymentStatusChanged(PaymentStatusChangedEvent statusChangedEvent) {
        log.info("Payment changed status: " + statusChangedEvent.getPayment());
    }

}
