package dev.techdozo.order.infrastructure.service;

import dev.techdozo.order.application.domain.model.Inventory;
import dev.techdozo.order.application.domain.model.Order;
import dev.techdozo.order.application.domain.service.InventoryService;
import dev.techdozo.order.common.config.ApplicationProperties;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {
  private final ApplicationProperties applicationProperties;

  @Override
  public List<Inventory> geyInventory(Order order) {
    log.info("Fetching inventories for order {}", order);
    var restClient =
        RestClient.builder()
            .baseUrl(applicationProperties.getInventoryUrl() + "/inventories")
            .build();

    var inventories =
        restClient
            .get()
            .uri(uriBuilder -> uriBuilder.queryParam("productId", order.getProductId()).build())
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .toEntity(new ParameterizedTypeReference<List<Inventory>>() {})
            .getBody();
    log.info("Fetched inventories, {}", inventories);
    return inventories;
  }
}
