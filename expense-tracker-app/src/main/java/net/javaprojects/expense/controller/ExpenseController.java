package net.javaprojects.expense.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.javaprojects.expense.dto.ExpenseDto;
import net.javaprojects.expense.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "CRUD REST APIs for Expense Resource",
        description = "CRUD REST APIs for Expense Resource - Create Expense, Get a specific Expense,"+
                "Get all Expenses, Update Expense and Delete Expense"
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private ExpenseService expenseService;

    // Create expense REST API
    @Operation(
            summary = "CREATE expense REST API",
            description = "CREATE expense REST API save expense to database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto){
        ExpenseDto savedExpense=expenseService.createExpense(expenseDto);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }

    //Get Expense by Id REST API
    @Operation(
            summary = "GET expense REST API",
            description = "GET expense REST API get expense from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable("id") Long expenseId){
        ExpenseDto expense=expenseService.getExpenseById(expenseId);
        return ResponseEntity.ok(expense);
    }

    //Get all Expense REST API
    @Operation(
            summary = "GET ALL expenses REST API",
            description = "GET ALL expenses REST API get all expenses from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses(){
        List<ExpenseDto> expenses=expenseService.getAllExpense();
        return ResponseEntity.ok(expenses);
    }

    //Update Expense REST API
    @Operation(
            summary = "UPDATE expense REST API",
            description = "UPDATE expense REST API update expense in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @PutMapping("/{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable("id") Long expenseId,
                                                    @RequestBody ExpenseDto expenseDto){
        ExpenseDto updatedExpense=expenseService.updateExpense(expenseId,expenseDto);
        return ResponseEntity.ok(updatedExpense);
    }

    //Delete Expense REST API
    @Operation(
            summary = "DELETE expense REST API",
            description = "DELETE expense REST API update expense in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long expenseId){
        expenseService.deleteExpenseById(expenseId);
        return ResponseEntity.ok("Successfully deleted "+expenseId);
    }
}
