package ru.lofitsky.training.book_store_example.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@ToString(includeFieldNames = true)
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final long id;

    @NotBlank(message = "Title is not optional")
    private final String title;

    private final Genres genre;
    private final String publisher;
}