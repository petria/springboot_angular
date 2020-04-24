package org.freakz.books.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class Book {

    private int id;
    private String title;
    private String description;

}
