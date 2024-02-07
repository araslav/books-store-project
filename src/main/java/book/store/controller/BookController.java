package book.store.controller;

import book.store.dto.book.BookDto;
import book.store.dto.book.BookSearchParametersDto;
import book.store.dto.book.CreateBookRequestDto;
import book.store.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book controller", description = "Endpoints for managing books")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @Operation(summary = "Create a new Book",
            parameters = {
                    @Parameter(name = "title", required = true, in = ParameterIn.DEFAULT,
                            description = "Title of the book",
                            schema = @Schema(type = "string")),
                    @Parameter(name = "author", required = true,
                            description = "Full name of the author",
                            schema = @Schema(type = "string", maxLength = 12)),
                    @Parameter(name = "isbn", required = true,
                            description = "isbn number",
                            schema = @Schema(type = "string", maxLength = 13)),
                    @Parameter(name = "price", required = true,
                            description = "Book's price",
                            schema = @Schema(type = "number", minimum = "0")),
                    @Parameter(name = "description",
                            description = "Book's description",
                            schema = @Schema(type = "string")),
                    @Parameter(name = "coverImage",
                            description = "Book's coverImage",
                            schema = @Schema(type = "string"))})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BookDto createBook(@RequestBody @Valid CreateBookRequestDto requestDto) {
        return bookService.createBook(requestDto);
    }

    @Operation(summary = "Find Book by id")
    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @Operation(summary = "Find all Books")
    @GetMapping
    public List<BookDto> getAll(Pageable pageable) {
        return bookService.findAll(pageable);
    }

    @Operation(summary = "Update Book by id",
            parameters = {
                    @Parameter(name = "title", required = true, in = ParameterIn.DEFAULT,
                            description = "Title of the book",
                            schema = @Schema(type = "string")),
                    @Parameter(name = "author", required = true,
                            description = "Full name of the author",
                            schema = @Schema(type = "string", maxLength = 12)),
                    @Parameter(name = "isbn", required = true,
                            description = "isbn number",
                            schema = @Schema(type = "string", maxLength = 13)),
                    @Parameter(name = "price", required = true,
                            description = "Book's price",
                            schema = @Schema(type = "number", minimum = "0")),
                    @Parameter(name = "description",
                            description = "Book's description",
                            schema = @Schema(type = "string")),
                    @Parameter(name = "coverImage",
                            description = "Book's coverImage",
                            schema = @Schema(type = "string"))})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public BookDto updateById(@PathVariable Long id,
                              @RequestBody @Valid CreateBookRequestDto requestDto) {
        return bookService.updateById(id, requestDto);
    }

    @Operation(summary = "Delete Book by id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @Operation(summary = "Find Books by params")
    @GetMapping("/search")
    public List<BookDto> searchBooks(BookSearchParametersDto params) {
        return bookService.search(params);
    }
}


