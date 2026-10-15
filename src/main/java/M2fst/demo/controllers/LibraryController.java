package M2fst.demo.controllers;

import M2fst.demo.dto.books.BookDto;
import M2fst.demo.dto.LibraryDto;
import M2fst.demo.services.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class LibraryController {
    private final LibraryService libraryService;

    @GetMapping("/library")
    public Collection<LibraryDto> GetLibrary(){
        return this.libraryService.getLibrary();
    }

    @GetMapping("/library/{id}")
    public ResponseEntity<LibraryDto> GetLibraryById(@PathVariable int id){
        return ResponseEntity.ok(this.libraryService.getLibraryById(id));
    }

    @PostMapping("/library/{id}/book")
    public ResponseEntity<LibraryDto> AddBook(@PathVariable int id, @RequestBody BookDto book){
        return ResponseEntity.ok(this.libraryService.addBook(id, book.getName()));
    }

    @GetMapping("/library/{id}/book")
    public Collection<BookDto> GetBooks(@RequestParam List<UUID> listIsbn, @PathVariable int id ){
        return this.libraryService.getBooks(listIsbn,id);
    }

    @DeleteMapping("/library/{id}/book/{isbn}")
    public ResponseEntity<LibraryDto> DeleteBook(@PathVariable int id, @PathVariable(name="isbn") UUID ISBN ){
        return ResponseEntity.ok(this.libraryService.deleteBook(id, ISBN));
    }
}
