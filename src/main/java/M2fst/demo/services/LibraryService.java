package M2fst.demo.services;

import M2fst.demo.dto.books.BookDto;
import M2fst.demo.dto.LibraryDto;
import M2fst.demo.exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Service
public class LibraryService {
    public List<LibraryDto> libraries;

    public LibraryService() {
        libraries = new ArrayList<>();
        LibraryDto library = new LibraryDto(0, "Bibliothèque de Nancy", new HashSet<>());
        this.libraries.add(library);
        LibraryDto library2 = new LibraryDto(1, "Bibliothèque de Metz", new HashSet<>());
        this.libraries.add(library2);
    }

    public Collection<LibraryDto> getLibrary() {
        return this.libraries;
    }

    public LibraryDto getLibraryById(@PathVariable int id) {
        for (LibraryDto library : libraries) {
            if (library.getId() == id) {
                return library;
            }
        }
        return null;
    }

    public LibraryDto addBook(int id, String name) {
        for (LibraryDto library : libraries) {
            if (library.getId() == id) {
                UUID ISBN = UUID.randomUUID();
                library.getBooks().add(BookDto.builder().name(name).ISBN(ISBN).build());
                return library;
            }
        }
        return null;
    }

    public Collection<BookDto> getBooks(List<UUID> ListIsbn, int id) {
        List<BookDto> result = new ArrayList<>();
        for (LibraryDto library : libraries) {
            if (library.getId() == id) {
                for (UUID isbn : ListIsbn) {
                    for (BookDto book : library.getBooks()) {
                        if (book.getISBN().equals(isbn)) {
                            result.add(book);
                        }
                    }
                }
            }
        }
        return result;
    }

    public LibraryDto deleteBook(int id, UUID isbn) {
        LibraryDto lib= libraries.stream()
                .filter(library -> library.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Library not found"));
        if (!lib.getBooks().removeIf(book -> book.getISBN().equals(isbn))){
            throw new NotFoundException("Book not found");
        }
        return lib;
    }
}
