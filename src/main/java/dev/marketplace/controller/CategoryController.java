package dev.marketplace.controller;

import dev.marketplace.entity.Category;
import dev.marketplace.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/marketplace/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public List<Category> getAllCategoy(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id){
        Optional<Category> optCategory = categoryService.findById(id);

        if (optCategory.isPresent()){

            return optCategory.get();
        }
        return null;
    }

    @PostMapping
    public Category saveCategory(@RequestBody Category category){

        return categoryService.saveCategory(category);


    }



}
