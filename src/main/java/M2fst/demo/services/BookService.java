package M2fst.demo.services;

import M2fst.demo.dto.books.BookDto;
import M2fst.demo.entity.BookEntity;
import M2fst.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookEntity createBook(String name){
        UUID isbn = UUID.randomUUID();
        BookEntity book = new BookEntity();
        book.setIsbn(isbn);
        book.setName(name);
        this.bookRepository.save(book);
        return book;
    }

    public BookEntity updateBook(BookDto book){
        if (book == null) return null;

        BookEntity bookEntity = this.bookRepository.findById(book.getISBN()).orElseThrow();
        bookEntity.setIsbn(book.getISBN());
        bookEntity.setName(book.getName());
        this.bookRepository.save(bookEntity);
        return bookEntity;
    }
}
