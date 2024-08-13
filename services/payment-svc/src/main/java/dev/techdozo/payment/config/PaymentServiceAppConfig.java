package dev.techdozo.payment.config;

import dev.techdozo.payment.application.domain.repository.PaymentRepository;
import dev.techdozo.payment.application.service.PaymentService;
import dev.techdozo.payment.application.service.impl.PaymentServiceImpl;
import dev.techdozo.payment.persistence.repository.PaymentRepositoryImpl;
import dev.techdozo.payment.persistence.repository.jpa.PaymentJpaRepository;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Setter
public class PaymentServiceAppConfig {


    @Bean
    public PaymentService paymentService() {
        return new PaymentServiceImpl();
    }


    @Bean
    public PaymentRepository paymentRepository(PaymentJpaRepository paymentJpaRepository) {
        return new PaymentRepositoryImpl(paymentJpaRepository);
    }
}
