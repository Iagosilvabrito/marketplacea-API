package dev.marketplace.service;

import dev.marketplace.entity.Category;
import dev.marketplace.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;


    public List<Category> findAll(){
        return categoryRepository.findAll();

    }
    public Optional<Category> getByCategoryId(Long id){
        return categoryRepository.findById(id);

    }

    public Category saveCategory(Category category){

        return categoryRepository.save(category);
    }
    public void deletById(Long id){
        categoryRepository.deleteById(id);
    }
}
