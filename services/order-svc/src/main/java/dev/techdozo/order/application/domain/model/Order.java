package dev.techdozo.order.application.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/** Order Domain object */
@Setter
@Getter
@ToString
public class Order {
  private Long orderId;
  private Long productId;
  private Double price;
  private Long quantity;
  private OrderStatus orderStatus;
}
