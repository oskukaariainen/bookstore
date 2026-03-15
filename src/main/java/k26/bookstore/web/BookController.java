package k26.bookstore.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import k26.bookstore.domain.Book;
import k26.bookstore.domain.BookRepository;
import k26.bookstore.domain.CategoryRepository;

@Controller
public class BookController {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public BookController(BookRepository bookRepository, CategoryRepository categoryRepository) {

        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    // näyttää kaikki kirjat
    @RequestMapping(value = { "/", "/booklist" })
    public String bookList(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

    // lisää uuden kirjan
    @RequestMapping(value = "/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }

    @PostMapping("/save")
    public String save(@Valid Book book, BindingResult bindingResult, Model model) {
        System.out.println("Kirja " + book.toString());

        if (bindingResult.hasErrors()) {
            System.out.println("Validation error tapahtui: " + book.toString());
            model.addAttribute("book", book);
            model.addAttribute("categories", categoryRepository.findAll());
            return "addbook";
        }

        bookRepository.save(book);
        return "redirect:booklist";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookRepository.findById(id).get());
        model.addAttribute("categories", categoryRepository.findAll());

        return "editbook";
    }

    @GetMapping("/access-denied")
    public String accessDenied(Model model) {
        model.addAttribute("errorMessage", "You do not have permission to perform this action.");
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

}
