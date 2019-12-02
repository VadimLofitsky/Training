package ru.lofitsky.training.book_store_example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

        model.addAttribute("genres", genres);

        return "addNewBook";
    }
}