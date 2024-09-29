package net.javaprojects.expense.service;

import net.javaprojects.expense.dto.ExpenseDto;

import java.util.List;

public interface ExpenseService {
    ExpenseDto createExpense(ExpenseDto expenseDto);
    ExpenseDto getExpenseById(Long expenseId);
    List<ExpenseDto> getAllExpense();
    ExpenseDto updateExpense(Long expenseId,ExpenseDto expenseDto);
    void deleteExpenseById(Long expenseId);
}
