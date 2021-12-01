package com.together.dto.request;

import com.together.domain.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryRequest {

    private String categoryName;

    public Category toCategoryEntity(String categoryName){
        return Category.builder()
                .categoryName(categoryName)
                .build();
    }
}
