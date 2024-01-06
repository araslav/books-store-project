package book.store.mapper.request;

import book.store.dto.request.CreateBookRequestDto;
import book.store.mapper.RequestDtoMapper;
import book.store.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookRequestDtoMapper implements RequestDtoMapper<CreateBookRequestDto, Book> {
    @Override
    public Book toModel(CreateBookRequestDto dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());
        book.setPrice(dto.getPrice());
        book.setDescription(dto.getDescription());
        book.setCoverImage(dto.getCoverImage());
        return book;
    }
}
