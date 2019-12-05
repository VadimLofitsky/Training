package ru.lofitsky.training.book_store_example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lofitsky.training.book_store_example.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Commons
    Book findByTitle(String title);
    List<Book> findAll();


    // Pageables
    Page<Book> findByTitle(String title, Pageable pageable);
    Page<Book> findAll(Pageable pageable);
}