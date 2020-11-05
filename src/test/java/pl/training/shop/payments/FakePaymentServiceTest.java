package pl.training.shop.payments;

import org.javamoney.moneta.FastMoney;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class FakePaymentServiceTest {

    public static final String PAYMENT_ID = "1";
    public static final FastMoney MONEY = LocalMoney.of(1_000);
    public static final PaymentRequest PAYMENT_REQUEST = PaymentRequest.builder()
            .money(MONEY)
            .build();

    @Mock
    private PaymentIdGenerator paymentIdGenerator;
    @Mock
    private PaymentRepository paymentRepository;
    @Mock
    private ApplicationEventPublisher eventPublisher;
    private Payment payment;

    @BeforeEach
    void setUp() {
        Mockito.when(paymentIdGenerator.getNext()).thenReturn(PAYMENT_ID);
        Mockito.when(paymentRepository.save(any(Payment.class))).then(AdditionalAnswers.returnsFirstArg());
        FakePaymentService fakePaymentService = new FakePaymentService(paymentIdGenerator, paymentRepository, eventPublisher);
        payment = fakePaymentService.process(PAYMENT_REQUEST);
    }

    @DisplayName("Should assign generated id to created payment")
    @Test
    void shouldAssignGeneratedIdToCreatedPayment() {
        assertEquals(PAYMENT_ID, payment.getId());
    }

    @DisplayName("Should assign money from payment request to created payment")
    @Test
    void shouldAssignMoneyFromPaymentRequestToCreatedPayment() {
        assertEquals(MONEY, payment.getMoney());
    }

    @DisplayName("Should assign timestamp to created payment")
    @Test
    void shouldAssignTomestampToCreatedPayment() {
        assertNotNull(payment.getTimestamp());
    }

    @DisplayName("Should assign started status to created payment")
    @Test
    void shouldAssignStartedStatusToCreatedPayment() {
        assertEquals(PaymentStatus.STARTED, payment.getStatus());
    }

    @DisplayName("Should save created payment")
    @Test
    void shouldSaveCreatedPayment() {
        verify(paymentRepository).save(payment);
    }

}
