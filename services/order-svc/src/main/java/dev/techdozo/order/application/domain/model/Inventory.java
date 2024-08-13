package dev.techdozo.order.application.domain.model;

public record Inventory(Long productId, String sku, Double quantity) {
}
