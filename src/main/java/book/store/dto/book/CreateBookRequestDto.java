package book.store.dto.book;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.Length;

public record CreateBookRequestDto(
        @NotBlank(message = "Title can't be Null or Empty")
        String title,
        @Length(max = 12, message = "Author can't be more than 12 chars")
        @NotBlank(message = "Author can't be Null or Empty")
        String author,
        @Length(max = 13, message = "Isbn can't be more than 13 digits")
        @NotBlank(message = "Isbn can't be Null or Empty")
        String isbn,
        @NotNull(message = "Price can't be Null")
        @Min(value = 0, message = "Price can't be less 0")
        BigDecimal price,
        String description,
        String coverImage
) {
}
