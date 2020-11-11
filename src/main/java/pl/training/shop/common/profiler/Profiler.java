package pl.training.shop.common.profiler;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Order(10)
@Aspect
@Log
public class Profiler {

    @Around("execution(* pl.training.shop.payments.FakePaymentService.process(..))")
    //@Around("bean(paymentService)")
    //@Around("@annotation(ExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.nanoTime();
        Object result = proceedingJoinPoint.proceed();
        long totalTime = System.nanoTime() - startTime;
        log.info(String.format("%s executed in %d ns", proceedingJoinPoint.getSignature(), totalTime));
        return result;
    }

}
