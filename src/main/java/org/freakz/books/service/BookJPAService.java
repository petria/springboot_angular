package org.freakz.books.service;

import lombok.AllArgsConstructor;
import org.freakz.books.jpa.entity.Book;
import org.freakz.books.jpa.repository.BookRepository;
import org.freakz.books.model.BookModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BookJPAService implements BookService {

    private final ModelMapper modelMapper = new ModelMapper();

    private final BookRepository repository;

    @Override
    public Collection<BookModel> getBooks() {
        return repository.findAll()
                .stream()
                .map(entity -> mapEntityToDTO(entity))
                .collect(Collectors.toList());
    }

    @Override
    public BookModel updateBook(BookModel bookModel) {
        Book book = mapDtoToEntity(bookModel);
        return mapEntityToDTO(repository.save(book));
    }

    @Override
    public BookModel createBook(BookModel bookModel) {
        Book book = mapDtoToEntity(bookModel);
        return mapEntityToDTO(repository.save(book));
    }

    @Override
    public Boolean deleteBook(int bookId) {
        repository.deleteById(bookId);
        return true;
    }

    private BookModel mapEntityToDTO(Book entity) {
        return modelMapper.map(entity, BookModel.class);
    }

    private Book mapDtoToEntity(BookModel bookModel) {
        return modelMapper.map(bookModel, Book.class);
    }

}
