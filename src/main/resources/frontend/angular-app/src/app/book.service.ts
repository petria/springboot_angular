import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

import { Book } from './book';
import { BOOKS } from './mock-books';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private booksUrl = 'http://localhost:8080/api/books';

  constructor(private http: HttpClient) { }

  getBooks(): Observable<Book[]> {
    //return of(BOOKS);
    return this.http.get<Book[]>(this.booksUrl)
  }

}
