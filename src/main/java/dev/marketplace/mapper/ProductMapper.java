package dev.marketplace.mapper;


import dev.marketplace.entity.Product;
import dev.marketplace.request.ProductRequest;
import dev.marketplace.response.ProductResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductMapper {

    public static Product ToProduct(ProductRequest request){
        return Product
                .builder()
                .name(request.name())
                .quantity(request.quantity())
                .price(request.price())
                .build();

    }

    public static ProductResponse toProducctResponse(Product product){

        return ProductResponse
                .builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();


    }
}
