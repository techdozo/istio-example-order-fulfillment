package dev.techdozo.inventory.config;

import dev.techdozo.inventory.application.domain.repository.InventoryRepository;
import dev.techdozo.inventory.persistence.repository.InventoryRepositoryImpl;
import dev.techdozo.inventory.persistence.repository.jpa.InventoryJpaRepository;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Setter
public class InventoryServiceAppConfig {

  @Bean
  @ConfigurationProperties
  public ApplicationProperties applicationProperties() {
    return new ApplicationProperties();
  }


  @Bean
  public InventoryRepository inventoryRepository(InventoryJpaRepository inventoryJpaRepository) {
    return new InventoryRepositoryImpl(inventoryJpaRepository);
  }
}
