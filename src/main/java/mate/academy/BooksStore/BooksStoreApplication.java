package mate.academy.BooksStore;

import mate.academy.BooksStore.model.Book;
import mate.academy.BooksStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class BooksStoreApplication {
	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(BooksStoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Book bookYa = new Book();
			bookYa.setTitle("Title1");
			bookYa.setAuthor("Ya");
			bookYa.setIsbn("1234");
			bookYa.setPrice(BigDecimal.valueOf(2000));
			Book bookYar = new Book();
			bookYar.setTitle("Title2");
			bookYar.setAuthor("Yar");
			bookYar.setIsbn("2345");
			bookYar.setPrice(BigDecimal.valueOf(1500));
			bookService.save(bookYa);
			bookService.save(bookYar);

			System.out.println(bookService.findAll());
		};
	}

}
