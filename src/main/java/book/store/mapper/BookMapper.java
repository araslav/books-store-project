package book.store.mapper;

import book.store.config.MapperConfig;
import book.store.dto.request.CreateBookRequestDto;
import book.store.dto.response.BookDto;
import book.store.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(CreateBookRequestDto requestDto);
}
