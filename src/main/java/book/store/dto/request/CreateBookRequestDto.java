package book.store.dto.request;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CreateBookRequestDto {
    @NotNull
    private String title;
    @NotNull
    private String author;
    @NotNull
    private String isbn;
    @NotNull
    private BigDecimal price;
    private String description;
    private String coverImage;
}
