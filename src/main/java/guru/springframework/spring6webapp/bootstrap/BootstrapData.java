package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.author.Author;
import guru.springframework.spring6webapp.domain.author.AuthorRepository;
import guru.springframework.spring6webapp.domain.book.Book;
import guru.springframework.spring6webapp.domain.book.BookRepository;
import guru.springframework.spring6webapp.domain.publisher.Publisher;
import guru.springframework.spring6webapp.domain.publisher.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();

        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();

        ddd.setAuthors(Set.of(eric));
        ddd.setTitle("DDD");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();

        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJ8 = new Book();

        noEJ8.setTitle("J2EE Development without EJ8");
        noEJ8.setIsbn("1234567");

        Author rodSaved = authorRepository.save(rod);
        Book noEJ8Saved = bookRepository.save(noEJ8);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJ8Saved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);


        System.out.println("In Bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());

        Publisher publisher = new Publisher();
        publisher.setPublisherName("My publisher");
        publisher.setAddress("My address");

        publisherRepository.save(publisher);
        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
