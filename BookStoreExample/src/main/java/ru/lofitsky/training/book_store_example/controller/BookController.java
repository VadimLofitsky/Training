package ru.lofitsky.training.book_store_example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.lofitsky.training.book_store_example.model.Book;
import ru.lofitsky.training.book_store_example.model.Genres;

import java.util.Arrays;
import java.util.List;

@Controller
public class BookController {

    @RequestMapping("/")
    public String greeting() {
        return "Hello, world!";
    }

    @GetMapping("/addNewBook")
    public String addNewBook(Model model) {
        List<Genres> genres = Arrays.asList(Genres.values());

        Book testBook = new Book("The Holy Bible");
        testBook.setAuthor("Lord");
        testBook.setGenre(Genres.MYSTERY);
        testBook.setPublisher("the Time");

        model.addAttribute("genres", genres);
        model.addAttribute("book", testBook);

        return "addNewBook";
    }
}