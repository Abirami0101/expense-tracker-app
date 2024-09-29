package net.javaprojects.expense.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;
@Schema(
        description = "Expense Data Transfer Object transfer data from client and server"
)
public record ExpenseDto(Long id,
                         @Schema(
                                 description = "Expense amount"
                         )
                         BigDecimal amount,
                         @Schema(
                                 description = "Expense created date"
                         )
                         LocalDate expenseDate,
                         @Schema(
                                 description = "Associated expense category"
                         )
                         CategoryDto categoryDto) {
}
