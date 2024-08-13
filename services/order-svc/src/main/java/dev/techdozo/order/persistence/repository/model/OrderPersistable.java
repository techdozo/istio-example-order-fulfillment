package dev.techdozo.order.persistence.repository.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Entity
@Table(name = "product_order")
public class OrderPersistable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Long productId;
  private String orderStatus;
  private Double price;
  private Long quantity;
}
