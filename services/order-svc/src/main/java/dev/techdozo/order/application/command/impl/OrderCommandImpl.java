package dev.techdozo.order.application.command.impl;

import dev.techdozo.order.application.command.OrderCommand;
import dev.techdozo.order.application.domain.model.Inventory;
import dev.techdozo.order.application.domain.model.Order;
import dev.techdozo.order.application.domain.model.OrderStatus;
import dev.techdozo.order.application.domain.repository.OrderRepository;
import dev.techdozo.order.application.domain.service.InventoryService;
import dev.techdozo.order.application.domain.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class OrderCommandImpl implements OrderCommand {

    private final OrderRepository orderRepository;
    private final InventoryService inventoryService;
    private final PaymentService paymentService;

    @Override
    public Order createOrder(Order newOrder) {
        //Check inventory
        var inventories = inventoryService.geyInventory(newOrder);
        double totalQuantity = inventories.stream().mapToDouble(Inventory::quantity).sum();
        //Create Payment
        if(totalQuantity > newOrder.getQuantity()) {
            var payment = paymentService.createPayment(newOrder);
        } else {
            throw new RuntimeException("Ordered product out of stock");
        }
        newOrder.setOrderStatus(OrderStatus.COMPLETED);
        var order = orderRepository.save(newOrder);
        log.info("Order saved, {}", newOrder);
        return newOrder;
    }
}
