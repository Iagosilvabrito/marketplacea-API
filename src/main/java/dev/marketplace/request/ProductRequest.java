package dev.marketplace.request;


import lombok.Builder;

import java.math.BigDecimal;
@Builder
public record ProductRequest(String name, Integer quantity, BigDecimal price){
}
