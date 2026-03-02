package dev.marketplace.mapper;

import dev.marketplace.entity.Category;
import dev.marketplace.request.CategoryRequest;
import dev.marketplace.response.CategoryResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest){
        return Category
                .builder()
                .name(categoryRequest.name())
                .build();

    }

    public static CategoryResponse toCategoryResponse(Category category){

        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();

    }

}
