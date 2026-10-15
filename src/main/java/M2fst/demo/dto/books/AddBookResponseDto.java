package M2fst.demo.dto.books;

import M2fst.demo.entity.BookEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class AddBookResponseDto {
    @NotNull
    private UUID ISBN;

    public static AddBookResponseDto fromEntity(BookEntity book) {
        return AddBookResponseDto.builder()
                .ISBN(book.getIsbn())
                .build();
    }
}
