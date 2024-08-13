package dev.techdozo.order.application.domain.service;

import dev.techdozo.order.application.domain.model.Inventory;
import dev.techdozo.order.application.domain.model.Order;

import java.util.List;

public interface InventoryService {
    List<Inventory> geyInventory(Order order);
}
