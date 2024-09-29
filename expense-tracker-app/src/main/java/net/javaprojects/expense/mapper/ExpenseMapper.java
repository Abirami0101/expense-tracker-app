package net.javaprojects.expense.mapper;

import net.javaprojects.expense.dto.CategoryDto;
import net.javaprojects.expense.dto.ExpenseDto;
import net.javaprojects.expense.entity.Category;
import net.javaprojects.expense.entity.Expense;

public class ExpenseMapper {
    public static ExpenseDto mapToExpenseDto(Expense expense){
        return new ExpenseDto(
                expense.getId(),
                expense.getAmount(),
                expense.getExpenseDate(),
                new CategoryDto(
                expense.getCategory().getId(),
                expense.getCategory().getName()
                )
        );
    }
    public static Expense mapToExpense(ExpenseDto expenseDto){
        Category category=new Category();
        category.setId(expenseDto.categoryDto().id());
        return new Expense(expenseDto.id(),
                expenseDto.amount(),
                expenseDto.expenseDate(),
                category 
        );
    }
}
