package dev.techdozo.order.application.domain.service;

import dev.techdozo.order.application.domain.model.Order;
import dev.techdozo.order.application.domain.model.Payment;

public interface PaymentService {
    Payment createPayment(Order order);
}
