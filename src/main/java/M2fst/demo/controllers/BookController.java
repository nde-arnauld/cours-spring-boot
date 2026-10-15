package M2fst.demo.controllers;

import M2fst.demo.dto.CreateBookDto;
import M2fst.demo.dto.books.AddBookResponseDto;
import M2fst.demo.dto.books.BookDto;
import M2fst.demo.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class BookController {
    private final BookService bookService;
    /**
    public BookController(BookService bookService,
                          @Value("${spring.datasource.url}") String databaseUrl,
                          @Value("${PATH}") String path) {
        this.bookService = bookService;
        System.out.println(databaseUrl);
        System.out.println(path);
    }

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
     */
    @PostMapping("/book")
    public ResponseEntity<AddBookResponseDto> addBook(@RequestBody CreateBookDto book){
        return ResponseEntity.ok(AddBookResponseDto.fromEntity(this.bookService.createBook(book.getName())));
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<AddBookResponseDto> updateBook(@PathVariable UUID id, @RequestBody BookDto book) {
        return ResponseEntity.ok(AddBookResponseDto.fromEntity(this.bookService.updateBook(book)));
    }
}
