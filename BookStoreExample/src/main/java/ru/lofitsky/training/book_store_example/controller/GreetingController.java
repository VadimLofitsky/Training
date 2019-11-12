package ru.lofitsky.training.book_store_example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//TODO: think about renaming controller into smth like (Request/Response)Controller
public class GreetingController {
    @RequestMapping("/")
    public String greeting() {
        return "Hello, world!";
    }

    // for testing workability
//    @RequestMapping("/book/{id}/{title}/{genre}/{publisher}")
//    public Book greeting(@PathVariable(name="id") Integer id,
//                         @PathVariable(name="title") String title,
//                         @Nullable @PathVariable(name="genre") String genre,
//                         @PathVariable(name="publisher") String publisher) {
//
//        return new Book(id, title, Genres.UNKNOWN, publisher);
//    }
}