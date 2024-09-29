package net.javaprojects.expense.service.impl;

import lombok.AllArgsConstructor;
import net.javaprojects.expense.dto.ExpenseDto;
import net.javaprojects.expense.entity.Category;
import net.javaprojects.expense.entity.Expense;
import net.javaprojects.expense.exception.ResourceNotFoundException;
import net.javaprojects.expense.mapper.ExpenseMapper;
import net.javaprojects.expense.repository.CategoryRepository;
import net.javaprojects.expense.repository.ExpenseRepository;
import net.javaprojects.expense.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {
    private ExpenseRepository expenseRepository;
    private CategoryRepository categoryRepository;
    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense expense= ExpenseMapper.mapToExpense(expenseDto);
        Expense savedExpense=expenseRepository.save(expense);

        return ExpenseMapper.mapToExpenseDto(savedExpense);
    }

    @Override
    public ExpenseDto getExpenseById(Long expenseId) {
        Expense expense=expenseRepository.findById(expenseId)
                .orElseThrow(()->new ResourceNotFoundException("Expense not found for id: "+expenseId));
        return ExpenseMapper.mapToExpenseDto(expense);
    }

    @Override
    public List<ExpenseDto> getAllExpense() {
        List<Expense> expenses=expenseRepository.findAll();
        return expenses.stream()
                .map((expense) -> ExpenseMapper.mapToExpenseDto(expense))
                .collect(Collectors.toList());

    }

    @Override
    public ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto) {
        Expense expense=expenseRepository.findById(expenseId)
                .orElseThrow(()->new ResourceNotFoundException("Expense not fount for id: "+expenseId));
        expense.setAmount(expenseDto.amount());
        expense.setExpenseDate(expenseDto.expenseDate());
        if(expenseDto.categoryDto() !=null){
            Category category=categoryRepository.findById(expenseDto.categoryDto().id())
                    .orElseThrow(()->new ResourceNotFoundException("Category not found for id " + expenseDto.categoryDto().id()));
            expense.setCategory(category);
        }
        Expense updatedExpense=expenseRepository.save(expense);
        return ExpenseMapper.mapToExpenseDto(updatedExpense);
    }

    @Override
    public void deleteExpenseById(Long expenseId) {
        Expense expense=expenseRepository.findById(expenseId)
                .orElseThrow(()->new ResourceNotFoundException("Expense not fount for id: "+expenseId));
        expenseRepository.delete(expense);

    }

}
