package dev.marketplace.controller;

import dev.marketplace.entity.Category;
import dev.marketplace.entity.Product;
import dev.marketplace.mapper.CategoryMapper;
import dev.marketplace.mapper.ProductMapper;
import dev.marketplace.request.CategoryRequest;
import dev.marketplace.request.ProductRequest;
import dev.marketplace.response.CategoryResponse;
import dev.marketplace.response.ProductResponse;
import dev.marketplace.service.CategoryService;
import dev.marketplace.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marketplace/product")
@RequiredArgsConstructor
public class ProductController{

    private final ProductService productService;


    @GetMapping()
    public ResponseEntity<List<ProductResponse>> getAllProduct(){

        List<ProductResponse> categories = productService.findAll()
                .stream()
                .map(ProductMapper::toProducctResponse)
                .toList();

        return ResponseEntity.ok(categories);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getByCategoryId(@PathVariable Long id){
        return productService.getByProductId(id)
                .map(product -> ResponseEntity.ok(ProductMapper.toProducctResponse(product)))
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<ProductResponse> saveCategory(@RequestBody ProductRequest request){
        Product newProduct = ProductMapper.ToProduct(request);
        Product savedProduct = productService.save(newProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductMapper.toProducctResponse(savedProduct));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletCategory(@PathVariable Long id){
        deletCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();


    }
}
