package com.together.service;

import com.together.domain.entity.Category;
import com.together.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository repository;

    public void createCategory(String category){
        try {
            repository.save(Category.builder().categoryName(category).build());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateCategory(Category category, String newCategoryName){
        category.updateCategoryName(newCategoryName);
    }
}
