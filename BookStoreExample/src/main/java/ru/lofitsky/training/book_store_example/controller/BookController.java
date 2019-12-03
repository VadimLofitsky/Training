package ru.lofitsky.training.book_store_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lofitsky.training.book_store_example.model.Book;
import ru.lofitsky.training.book_store_example.model.Genres;
import ru.lofitsky.training.book_store_example.repository.BookRepository;

import java.util.Arrays;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }

    @GetMapping("/addNewBook")
    public String addNewBook(Model model) {
        List<Genres> genres = Arrays.asList(Genres.values());
        model.addAttribute("genres", genres);
        return "addNewBook";
    }

    @PostMapping("/saveBook")
    public String saveBook(@RequestParam String title,
                         @RequestParam String genre,
                         @RequestParam String author,
                         @RequestParam String publisher,
                           Model model) {

        Book gottenBook = new Book();
        gottenBook.setTitle(title);
        gottenBook.setGenre(Genres.getByString(genre));
        gottenBook.setAuthor(author);
        gottenBook.setPublisher(publisher);

        bookRepository.save(gottenBook);
        model.addAttribute("books", bookRepository.findAll());
        return "redirect:/";
    }
}