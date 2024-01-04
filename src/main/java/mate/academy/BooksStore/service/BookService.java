package mate.academy.BooksStore.service;

import java.util.List;
import mate.academy.BooksStore.model.Book;

public interface BookService {
    Book save(Book book);
    List<Book> findAll();
}
