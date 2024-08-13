package dev.techdozo.payment.resource.model;

public record PaymentRequest(
        Long orderId,
        Long productId,
        Double amount) {
}
