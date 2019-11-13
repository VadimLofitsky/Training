package ru.lofitsky.training.book_store_example.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lofitsky.training.book_store_example.model.Book;
import ru.lofitsky.training.book_store_example.model.Genres;

@RestController
//TODO: think about renaming controller into smth like (Request/Response)Controller
public class GreetingController {
    @RequestMapping("/")
    public String greeting() {
        return "Hello, world!";
    }

    // for testing workability
    // and even such a request goes fine! )) :
    // http://localhost:8080/book/10/SomeTitle/фантастика/publisher
    @RequestMapping("/book/{id}/{title}/{genre}/{publisher}")
    public Book greeting(@PathVariable(name = "id") Integer id,
                         @PathVariable(name = "title") String title,
                         @PathVariable(name = "genre") String genre,
                         @PathVariable(name = "publisher") String publisher) {

        return new Book(id, title, Genres.getByString(genre), publisher);
    }
}