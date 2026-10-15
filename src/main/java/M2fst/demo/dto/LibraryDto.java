package M2fst.demo.dto;

import M2fst.demo.dto.books.BookDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class LibraryDto {
    private int id;
    private String name ;
    private Set<BookDto> books;
}
