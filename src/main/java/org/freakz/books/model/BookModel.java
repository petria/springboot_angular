package org.freakz.books.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BookModel {

    private int id;
    private String title;
    private String author;
    private String description;

}
