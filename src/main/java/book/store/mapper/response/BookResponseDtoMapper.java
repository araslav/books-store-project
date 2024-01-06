package book.store.mapper.response;

import book.store.dto.response.BookDto;
import book.store.mapper.ResponseDtoMapper;
import book.store.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookResponseDtoMapper implements ResponseDtoMapper<Book, BookDto> {
    @Override
    public BookDto toDto(Book model) {
        BookDto bookDto = new BookDto();
        bookDto.setId(model.getId());
        bookDto.setTitle(model.getTitle());
        bookDto.setAuthor(model.getAuthor());
        bookDto.setIsbn(model.getIsbn());
        bookDto.setPrice(model.getPrice());
        bookDto.setDescription(model.getDescription());
        bookDto.setCoverImage(model.getCoverImage());
        return bookDto;
    }
}
