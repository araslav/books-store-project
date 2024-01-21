package book.store.dto.book;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record CreateBookRequestDto(
        @NotBlank(message = "Title can't be Null or Empty")
        String title,
        @NotBlank(message = "Author can't be Null") String author,
        @NotBlank(message = "Isbn can't be Null") String isbn,
        @NotNull(message = "Price can't be Null")
        @Min(value = 0, message = "Price can't be less 0") BigDecimal price,
        String description,
        String coverImage
) {
}
