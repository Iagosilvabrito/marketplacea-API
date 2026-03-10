package dev.marketplace.response;

import lombok.Builder;

import java.math.BigDecimal;
@Builder
public record ProductResponse (Long id, String name, Integer quantity, BigDecimal price){
}
