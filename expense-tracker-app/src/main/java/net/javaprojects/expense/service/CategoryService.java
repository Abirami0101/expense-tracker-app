package net.javaprojects.expense.service;

import net.javaprojects.expense.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto getCategoryById(Long categoryId);
    List<CategoryDto> getAllCategory();
    CategoryDto updateCategory(Long categoryId,CategoryDto categoryDto);
    void deleteCategory(Long categoryId);
}
