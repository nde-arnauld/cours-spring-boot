package M2fst.demo.book;

import M2fst.demo.dto.books.BookDto;
import M2fst.demo.entity.BookEntity;
import M2fst.demo.repository.BookRepository;
import M2fst.demo.services.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.print.Book;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    void updateBookIsOk() {
        UUID isbn = UUID.randomUUID();
        BookEntity bookEntity = new BookEntity(isbn, "Premier livre");
        when(bookRepository.findById(isbn)).thenReturn(Optional.of(bookEntity));
        when(bookRepository.save(bookEntity)).thenReturn(bookEntity);

        BookEntity result = bookService.updateBook(BookDto.builder().ISBN(isbn).name("Nom du livre modifié").build());
    }
}
