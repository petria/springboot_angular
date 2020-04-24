import { Component, OnInit, Input } from '@angular/core';
import { Book } from '../book';
import { BookService } from '../book.service';
import { BooksComponent } from "../books/books.component";

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {

  @Input() book: Book;

  constructor(private bookService: BookService, private booksComponent : BooksComponent) { }

  ngOnInit(): void {
  }

  delete(): void {
    this.bookService.delete(this.book)
      .subscribe( book => this.doRefresh(null, true));
  }

  save(): void {
    this.bookService.updateBook(this.book)
      .subscribe( book => this.doRefresh(book, false));
  }

  saveNew() {
    this.bookService.saveNewBook(this.book)
      .subscribe(book => this.doRefresh(book, true));
  }

  private doRefresh(book : Book, updateBookList : boolean) {
    console.log('refresh: ', book);
    this.book = book;
    if (updateBookList) {
      this.booksComponent.getBooks();
    }
  }

}
