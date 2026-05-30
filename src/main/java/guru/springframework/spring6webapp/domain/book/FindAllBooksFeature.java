package guru.springframework.spring6webapp.domain.book;

import org.springframework.stereotype.Service;

@Service
public class FindAllBooksFeature {

    private final BookRepository bookRepository;

    public FindAllBooksFeature(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> execute() {
        return bookRepository.findAll();
    }
}
