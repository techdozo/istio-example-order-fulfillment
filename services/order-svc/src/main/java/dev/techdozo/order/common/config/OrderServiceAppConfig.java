package dev.techdozo.order.common.config;

import dev.techdozo.order.application.command.OrderCommand;
import dev.techdozo.order.application.command.impl.OrderCommandImpl;
import dev.techdozo.order.application.domain.repository.OrderRepository;
import dev.techdozo.order.application.domain.service.InventoryService;
import dev.techdozo.order.application.domain.service.PaymentService;
import dev.techdozo.order.application.factory.OrderFactory;
import dev.techdozo.order.application.factory.impl.OrderFactoryImpl;
import dev.techdozo.order.application.query.OrderQuery;
import dev.techdozo.order.application.query.impl.OrderQueryImpl;
import dev.techdozo.order.infrastructure.service.InventoryServiceImpl;
import dev.techdozo.order.infrastructure.service.PaymentServiceImpl;
import dev.techdozo.order.persistence.repository.OrderRepositoryImpl;
import dev.techdozo.order.persistence.repository.jpa.OrderJpaRepository;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Setter
public class OrderServiceAppConfig {

  @Bean
  public OrderFactory orderFactory(OrderJpaRepository orderJpaRepository) {
    return new OrderFactoryImpl(orderCommand(orderJpaRepository), orderQuery(orderJpaRepository));
  }

  private OrderQuery orderQuery(OrderJpaRepository orderJpaRepository) {
    return new OrderQueryImpl(orderRepository(orderJpaRepository));
  }

  @Bean
  public OrderCommand orderCommand(OrderJpaRepository orderJpaRepository) {
    return new OrderCommandImpl(
        orderRepository(orderJpaRepository), inventoryService(), paymentService());
  }

  @Bean
  public InventoryService inventoryService() {
    return new InventoryServiceImpl(applicationProperties());
  }

  @Bean
  public PaymentService paymentService() {
    return new PaymentServiceImpl(applicationProperties());
  }

  @Bean
  @ConfigurationProperties
  public ApplicationProperties applicationProperties() {
    return new ApplicationProperties();
  }

  @Bean
  public OrderRepository orderRepository(OrderJpaRepository orderJpaRepository) {
    return new OrderRepositoryImpl(orderJpaRepository);
  }
}
