package book.store.service;

import book.store.dto.request.CreateBookRequestDto;
import book.store.dto.response.BookDto;
import java.util.List;

public interface BookService {
    BookDto createBook(CreateBookRequestDto requestDto);

    BookDto getBookById(Long id);

    List<BookDto> getAll();
}
