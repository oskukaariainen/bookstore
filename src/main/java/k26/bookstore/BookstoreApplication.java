package k26.bookstore;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import k26.bookstore.domain.Category;
import ch.qos.logback.classic.Logger;
import k26.bookstore.domain.AppUser;
import k26.bookstore.domain.AppUserRepository;
import k26.bookstore.domain.Book;
import k26.bookstore.domain.BookRepository;
import k26.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = (Logger) LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository,
			CategoryRepository categoryRepository,
			AppUserRepository userRepository) {
		return (args) -> {

			if (userRepository.count() == 0) {

				log.info("Create some users");

				AppUser user1 = new AppUser("user",
						"$2a$10$.MgqhhqDMvsKPHJK9OwO7OvFv5rFwlWbr/loZKxUCUTJlZSz2oTCC", "USER");
				AppUser user2 = new AppUser("admin",
						"$2a$10$GMVXbP30ODjSw5ENAwRXQ.FmjZdmJEqn20/o62OC1jk2Rt3wEoJxC", "ADMIN");
				userRepository.save(user1);
				userRepository.save(user2);
			}

			if (categoryRepository.count() == 0) {
				log.info("save a couple of categories");

				Category category1 = new Category("Fantasy");
				Category category2 = new Category("Scifi");
				Category category3 = new Category("Drama");

				categoryRepository.save(category1);
				categoryRepository.save(category2);
				categoryRepository.save(category3);

				log.info("save a couple of books");
				bookRepository.save(new Book("Kirja1 ", "Kirjoittaja1", 3232, "asdasddsa", 1,
						category1));
				bookRepository.save(new Book("Kirja2", "Kirjoittaja2", 2000, "asdasd", 3,
						category2));
				bookRepository.save(new Book("Kirja3", "Kirjoittaja3", 2000, "asdsad", 3,
						category3));
			}

			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
