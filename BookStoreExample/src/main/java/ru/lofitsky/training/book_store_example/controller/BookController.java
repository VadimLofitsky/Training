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
import ru.lofitsky.training.book_store_example.service.Endpoints;
import ru.lofitsky.training.book_store_example.service.UrlService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UrlService urlService;

    @GetMapping(Endpoints.ROOT_REQUEST)
    public String index(Model model,
           @PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 10) Pageable pageable) {

        model.addAttribute("urlService", urlService);

        Page<Book> page = bookService.getAllBooks(pageable);
        model.addAttribute("page", page);

        // Collection of books at this page
        List<Book> books = page.getContent();
        model.addAttribute("books", books);

        // Generating page numbers list
        int totalPages = page.getTotalPages();
        List<Integer> pageNumbers = Collections.emptyList();

        if(totalPages > 0) {
            pageNumbers = IntStream.rangeClosed(1, totalPages)
                                   .boxed()
                                   .collect(Collectors.toList());
        }

        model.addAttribute("pagenumbers", pageNumbers);

        return Endpoints.ROOT_RESPONSE;
    }

    @GetMapping(Endpoints.ADDNEWBOOK_REQUEST)
    public String addNewBook(Model model) {

        model.addAttribute("urlService", urlService);

        List<Genres> genres = Stream.of(Genres.values()).collect(Collectors.toList());
        model.addAttribute("genres", genres);

        return Endpoints.ADDNEWBOOK_RESPONSE;
    }

    @PostMapping(Endpoints.SAVEBOOK_REQUEST)
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

        return Endpoints.SAVEBOOK_RESPONSE;
    }

    @GetMapping(Endpoints.EDITBOOK_REQUEST)
    public String editBook(@RequestParam Long id, Model model) {
        List<Genres> genres = Stream.of(Genres.values()).collect(Collectors.toList());

        model.addAttribute("book", bookService.getBookById(id));
        model.addAttribute("genres", genres);

        return Endpoints.EDITBOOK_RESPONSE;
    }

    @PostMapping(Endpoints.DELETEBOOK_REQUEST)
    public String deleteBook(@RequestParam Long id) {
        bookService.deleteBook(id);

        return Endpoints.DELETEBOOK_RESPONSE;
    }
}