package ru.lofitsky.training.book_store_example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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