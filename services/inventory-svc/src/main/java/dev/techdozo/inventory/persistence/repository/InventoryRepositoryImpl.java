package dev.techdozo.inventory.persistence.repository;

import dev.techdozo.inventory.application.domain.model.Inventory;
import dev.techdozo.inventory.application.domain.repository.InventoryRepository;
import dev.techdozo.inventory.persistence.mapper.InventoryPersistableMapper;
import dev.techdozo.inventory.persistence.repository.jpa.InventoryJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class InventoryRepositoryImpl implements InventoryRepository {

  private final InventoryJpaRepository inventoryJpaRepository;

  @Override
  public List<Inventory> get(Long productId) {
    log.info("Getting all inventory from DB..");
    var inventoryPersistables = inventoryJpaRepository.findByProductId(productId);
    return inventoryPersistables.stream().map(InventoryPersistableMapper.MAPPER::map).toList();
  }
}
