package book.store.dto.category;

import jakarta.validation.constraints.NotBlank;

public record CreateCategoryRequest(
        @NotBlank(message = "Name can't be Null or Empty")
        String name,
        String description
) {
}
