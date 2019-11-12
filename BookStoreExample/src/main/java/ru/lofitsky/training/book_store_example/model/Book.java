package ru.lofitsky.training.book_store_example.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
public class Book {
    private final long id;
    private final String title;
    //    private final String[] authors;
    //    private final int year;
    private final Genres genre;
    private final String publisher;
}