package org.freakz.books.service;

import org.freakz.books.model.BookModel;

import java.util.Collection;

public interface BookService {

    Collection<BookModel> getBooks();

    BookModel updateBook(BookModel bookModel);

    BookModel createBook(BookModel bookModel);

    Boolean deleteBook(int bookId);

}
