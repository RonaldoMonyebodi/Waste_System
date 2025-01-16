package com.enviro.assessment.grad001.service;

import com.enviro.assessment.grad001.model.WasteCategory;
import com.enviro.assessment.grad001.repository.WasteCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryService {

    private final WasteCategoryRepository repository;

    public WasteCategoryService(WasteCategoryRepository repository) {
        this.repository = repository;
    }

    public List<WasteCategory> getAllCategories() {
        return repository.findAll();
    }

    public WasteCategory createCategory(WasteCategory category) {
        return repository.save(category);
    }

    public WasteCategory updateCategory(Long id, WasteCategory updatedCategory) {
        return repository.findById(id).map(category -> {
            category.setName(updatedCategory.getName());
            category.setDescription(updatedCategory.getDescription());
            return repository.save(category);
        }).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}
