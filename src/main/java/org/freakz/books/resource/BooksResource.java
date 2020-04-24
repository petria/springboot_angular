package org.freakz.books.resource;

import lombok.RequiredArgsConstructor;
import org.freakz.books.model.BookModel;
import org.freakz.books.service.BookService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RequiredArgsConstructor
@RestController
public class BooksResource {

    @Qualifier("bookJPAService")
    private final BookService bookService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = GET, value = "/api/books")
    @ResponseBody
    private Collection<BookModel> getBooks() {
        return bookService.getBooks();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = PUT, value = "/api/books")
    @ResponseBody
    private BookModel updateBook(@RequestBody BookModel bookModel) {
        return bookService.updateBook(bookModel);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = POST, value = "/api/books")
    @ResponseBody
    private BookModel createBook(@RequestBody BookModel bookModel) {
        return bookService.createBook(bookModel);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = DELETE, value = "/api/books/{bookId}")
    @ResponseBody
    private Boolean deleteBook(@PathVariable Integer bookId) {
        return bookService.deleteBook(bookId);
    }

}
