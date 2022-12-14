package com.api.shoesshop.services.impl;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.shoesshop.entities.Category;
import com.api.shoesshop.repositories.CategoryRepository;
import com.api.shoesshop.services.CategoryService;
import com.api.shoesshop.utils.Helper;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category save(Category entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public Page<Category> findAll(Map<String, String> query) {
        Pageable pageable = Helper.getPageable(query);
        String parentId = query.get("parent_id");
        if (parentId != null) {
            if (parentId.equals("null"))
                return categoryRepository.findByParentIdIsNull(pageable);
            return categoryRepository.findByParentIdIs(Long.valueOf(parentId), pageable);
        }
        return categoryRepository.findAll(pageable);

    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category update(long id, Category entity) {
        Category category = findById(id);
        if (category != null) {
            entity.setId(id);
            return categoryRepository.save(entity);
        }
        return null;
    }

    @Override
    public Category findById(long id) {
        Optional<Category> optional = categoryRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

}
