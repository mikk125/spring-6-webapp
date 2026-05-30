package guru.springframework.spring6webapp.domain.author;

import guru.springframework.spring6webapp.domain.book.FindAllBooksFeature;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final FindAllAuthorsFeature findAllAuthorsFeature;

    public AuthorController(FindAllAuthorsFeature findAllAuthorsFeature) {
        this.findAllAuthorsFeature = findAllAuthorsFeature;
    }

    @RequestMapping("/authors")
    public String findAllAuthors(Model model) {


        model.addAttribute("authors", findAllAuthorsFeature.execute());

        return "authors";
    }
}
