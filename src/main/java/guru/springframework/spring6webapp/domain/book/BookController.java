package guru.springframework.spring6webapp.domain.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final FindAllBooksFeature findAllBooksFeature;

    public BookController(FindAllBooksFeature findAllBooksFeature) {
        this.findAllBooksFeature = findAllBooksFeature;
    }

    @RequestMapping("/books")
    public String findAllBooks(Model model) {


        model.addAttribute("books", findAllBooksFeature.execute());

        return "books";
    }
}
