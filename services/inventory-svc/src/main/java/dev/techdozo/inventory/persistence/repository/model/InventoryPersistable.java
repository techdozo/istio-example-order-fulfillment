package dev.techdozo.inventory.persistence.repository.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Entity
@Table(name = "inventory")
public class InventoryPersistable {
  @Id
  private Long id;
  private Long productId;
  private String productName;
  private String productType;
  private Long quantity;
}
