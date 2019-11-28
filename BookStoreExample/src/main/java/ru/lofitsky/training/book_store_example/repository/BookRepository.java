package ru.lofitsky.training.book_store_example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.lofitsky.training.book_store_example.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Book findByTitle(String title);
}
