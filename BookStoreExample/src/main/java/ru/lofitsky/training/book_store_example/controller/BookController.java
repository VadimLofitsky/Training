package ru.lofitsky.training.book_store_example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.lofitsky.training.book_store_example.model.Book;

@Controller
public class BookController {

    @RequestMapping("/")
    public String greeting() {
        return "Hello, world!";
    }

    @GetMapping("/addNewBook")
    public String addNewBook() {
        return "addNewBook";
    }
}