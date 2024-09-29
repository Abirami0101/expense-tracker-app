package net.javaprojects.expense.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        description = "Category Data Transfer Object transfer data between client and server"
)
public record CategoryDto(Long id,
                          @Schema(
                                  description = "Category name"
                          )
                          String name) {
}
