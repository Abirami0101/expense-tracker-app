package net.javaprojects.expense.mapper;

import net.javaprojects.expense.dto.CategoryDto;
import net.javaprojects.expense.entity.Category;

public class CategoryMapper {
    //Map CategoryDto to Category
    public static Category mapToCategory(CategoryDto categoryDto){
        return new Category(
                categoryDto.id(),
                categoryDto.name()
        );
    }
    //Map Category to CategoryDto
    public static CategoryDto mapToCategoryDto(Category category){
        return new CategoryDto(
                category.getId(),
                category.getName()
        );
    }
}
