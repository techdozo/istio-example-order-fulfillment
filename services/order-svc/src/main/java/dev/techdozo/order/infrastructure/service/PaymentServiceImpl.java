package dev.techdozo.order.infrastructure.service;

import dev.techdozo.order.application.domain.model.Order;
import dev.techdozo.order.application.domain.model.Payment;
import dev.techdozo.order.application.domain.service.PaymentService;
import dev.techdozo.order.common.config.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final ApplicationProperties applicationProperties;

    @Override
    public Payment createPayment(Order order) {
        var restClient =
                RestClient.builder()
                        .baseUrl(applicationProperties.getPaymentUrl())
                        .build();
        double amount = order.getPrice() * order.getQuantity();
        Payment payment = new Payment(null, amount);
        var paymentId = restClient
                .post()
                .body(new PaymentRequest(order.getOrderId(), order.getProductId(), amount))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(String.class)
                .getBody();
        return new Payment(payment.paymentId(), amount);

    }

    private record PaymentRequest(Long orderId, Long productId, double amount) {

    }
}
