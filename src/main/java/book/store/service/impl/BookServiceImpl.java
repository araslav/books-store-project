package book.store.service.impl;

import book.store.dto.request.CreateBookRequestDto;
import book.store.dto.response.BookDto;
import book.store.exeption.EntityNotFoundException;
import book.store.mapper.request.BookRequestDtoMapper;
import book.store.mapper.response.BookResponseDtoMapper;
import book.store.model.Book;
import book.store.repository.BookRepository;
import book.store.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookRequestDtoMapper bookRequestDtoMapper;
    private final BookResponseDtoMapper bookResponseDtoMapper;

    @Override
    public BookDto createBook(CreateBookRequestDto requestDto) {
        return bookResponseDtoMapper.toDto(bookRepository
                .save(bookRequestDtoMapper.toModel(requestDto)));
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Don't find book with id " + id));
        return bookResponseDtoMapper.toDto(book);
    }

    @Override
    public List<BookDto> getAll() {
        return bookRepository.findAll().stream()
                .map(bookResponseDtoMapper::toDto)
                .toList();
    }
}
