package book.store.service;

import book.store.dto.book.BookDto;
import book.store.dto.book.CreateBookRequestDto;
import java.util.List;

public interface BookService {
    BookDto createBook(CreateBookRequestDto requestDto);

    BookDto getBookById(Long id);

    List<BookDto> getAll();

    void deleteById(Long id);

    BookDto updateById(Long id, CreateBookRequestDto requestDto);
}
