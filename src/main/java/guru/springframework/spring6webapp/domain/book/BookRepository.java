package guru.springframework.spring6webapp.domain.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
