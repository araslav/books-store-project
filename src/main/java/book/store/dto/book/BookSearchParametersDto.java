package book.store.dto.book;

public record BookSearchParametersDto(
        String title,
        String[] author,
        String isbn) {
}
