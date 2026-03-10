package dev.marketplace.controller;

import dev.marketplace.entity.Category;
import dev.marketplace.mapper.CategoryMapper;
import dev.marketplace.request.CategoryRequest;
import dev.marketplace.response.CategoryResponse;
import dev.marketplace.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/marketplace/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> getAllCategoy(){

        List<CategoryResponse> categories = categoryService.findAll()
                .stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();

        return ResponseEntity.ok(categories);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getByCategoryId(@PathVariable Long id){
        return categoryService.getByCategoryId(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<CategoryResponse> saveCategory(@RequestBody CategoryRequest request){
        Category newCategory = CategoryMapper.toCategory(request);
        Category savedCategory = categoryService.saveCategory(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(savedCategory));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletCategory(@PathVariable Long id){
        deletCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();


    }



}
