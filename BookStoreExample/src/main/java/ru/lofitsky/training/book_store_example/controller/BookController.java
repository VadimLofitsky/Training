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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    static List<Genres> genres = Arrays.asList(Genres.values());

    int lastSeeingPageNumber = 0;

    @GetMapping("/")
    public String index(Model model,
           @PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 10) Pageable pageable) {

        lastSeeingPageNumber = pageable.getPageNumber();
        pageable.first();

        Page<Book> page = bookService.getAllBooks(pageable);
        model.addAttribute("bookpage", page);

        int totalPages = page.getTotalPages();
        int[] pageNumbers = {};
        if(totalPages != 0) {
            pageNumbers = IntStream.rangeClosed(1, totalPages).toArray();
        }

        model.addAttribute("pagenumbers", pageNumbers);
        return "index";
    }

    @GetMapping("/addNewBook")
    public String addNewBook(Model model) {
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

        Optional<Long> optID = Optional.of(id);
        if(optID.isPresent() && optID.get() != -1) {
            editedBook.setId(optID.get());
        }

        bookService.saveBook(editedBook);

        model.addAttribute("books", bookService.getAllBooks());

        return "redirect:/?page=" + lastSeeingPageNumber;
    }

    @GetMapping("/editBook")
    public String editBook(@RequestParam Long id, Model model) {
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