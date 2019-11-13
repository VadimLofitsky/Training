package ru.lofitsky.training.book_store_example.model;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Genres {
    UNKNOWN,                // for genres that are not listed below
    SCIENCE_FICTION,
    SATIRE,
    DRAMA,
    ACTION_AND_ADVENTURE,
    ROMANCE,
    MYSTERY,
    HORROR;

    private final static Map<String, Genres> namesMap = Stream.of(Genres.values())
            .collect(Collectors.toMap(Enum::name, enumType -> enumType));

    public static Genres getByString(String stringType) {
        Genres result = namesMap.get(stringType);
        return (result != null) ? result : UNKNOWN;
    }
}
