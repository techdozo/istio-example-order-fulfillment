package dev.techdozo.payment.persistence.repository.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Entity
@Table(name = "payment")
public class PaymentPersistable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Long orderId;
  private String productId;
  private Double amount;
  private String externalId;
}
