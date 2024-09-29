package net.javaprojects.expense.service.impl;

import lombok.AllArgsConstructor;
import net.javaprojects.expense.dto.CategoryDto;
import net.javaprojects.expense.entity.Category;
import net.javaprojects.expense.exception.ResourceNotFoundException;
import net.javaprojects.expense.mapper.CategoryMapper;
import net.javaprojects.expense.repository.CategoryRepository;
import net.javaprojects.expense.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        //Map CategoryDto to Category
        Category category= CategoryMapper.mapToCategory(categoryDto);

        Category savedCategory=categoryRepository.save(category);
        //Map CategoryDto to Category
        return CategoryMapper.mapToCategoryDto(savedCategory);
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category not found for id " + categoryId));
        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories=categoryRepository.findAll();
        return categories.stream()
                .map((category -> CategoryMapper.mapToCategoryDto(category)))
                .collect(Collectors.toList());

    }

    @Override
    public CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto) {
        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category not found for id " + categoryId));
        category.setName(categoryDto.name());
        Category updatedCategory=categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category not found for id " + categoryId));
        categoryRepository.delete(category);

    }
}
