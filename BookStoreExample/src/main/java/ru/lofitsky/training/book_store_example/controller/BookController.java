package ru.lofitsky.training.book_store_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lofitsky.training.book_store_example.model.Book;
import ru.lofitsky.training.book_store_example.model.Genres;
import ru.lofitsky.training.book_store_example.service.BookService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    int lastSeeingPageNumber = 0;

    @GetMapping("/")
    public String index(Model model,
           @PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 10) Pageable pageable) {

        lastSeeingPageNumber = pageable.getPageNumber();

        Page<Book> page = bookService.getAllBooks(pageable);
        model.addAttribute("page", page);

        int totalPages = page.getTotalPages();
        List<Integer> pageNumbers = Collections.emptyList();

        if(totalPages > 0) {
            pageNumbers = IntStream.rangeClosed(1, totalPages)
                                   .boxed()
                                   .collect(Collectors.toList());
        }

        model.addAttribute("pagenumbers", pageNumbers);
        return "index";
    }

    @GetMapping("/addNewBook")
    public String addNewBook(Model model) {
        List<Genres> genres = Stream.of(Genres.values()).collect(Collectors.toList());
        model.addAttribute("genres", genres);

        return "addNewBook";
    }

    @PostMapping("/saveBook")
    public String saveBook(@RequestParam Long id,
                           @RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam String author,
                           @RequestParam String publisher,
                           Model model) {

        Book editedBook = Book.builder()
                .title(title)
                .genre(Genres.getByString(genre))
                .author(author)
                .publisher(publisher)
                .build();

        if(id != -1) {
            editedBook.setId(id);
        }

        bookService.saveBook(editedBook);

        model.addAttribute("books", bookService.getAllBooks());

        return "redirect:/?page=" + lastSeeingPageNumber;
    }

    @GetMapping("/editBook")
    public String editBook(@RequestParam Long id, Model model) {
        List<Genres> genres = Stream.of(Genres.values()).collect(Collectors.toList());

        model.addAttribute("book", bookService.getBookById(id));
        model.addAttribute("genres", genres);

        return "/editBook";
    }

    @PostMapping("/deleteBook")
    public String deleteBook(@RequestParam Long id) {
        bookService.deleteBook(id);

        return "redirect:/?page=" + lastSeeingPageNumber;
    }
}