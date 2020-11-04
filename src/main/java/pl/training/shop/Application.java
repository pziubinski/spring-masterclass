package pl.training.shop;

import lombok.extern.java.Log;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.training.shop.payments.*;

@Log
public class Application {

    public static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(CONFIG_LOCATION)) {

            var paymentService = applicationContext.getBean(PaymentService.class);
            var paymentRequest = PaymentRequest.builder()
                    .money(LocalMoney.of(1_000))
                    .build();
            var payment = paymentService.process(paymentRequest);

            log.info(payment.toString());
        }
    }
}
