package guru.springframework.spring6webapp.domain.author;

import guru.springframework.spring6webapp.domain.book.Book;
import guru.springframework.spring6webapp.domain.book.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class FindAllAuthorsFeature {

    private final AuthorRepository authorRepository;

    public FindAllAuthorsFeature(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Iterable<Author> execute() {
        return authorRepository.findAll();
    }
}

