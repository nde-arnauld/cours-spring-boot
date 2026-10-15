package M2fst.demo.dto.books;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class BookDto {
    @NotBlank
    private UUID ISBN;

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;
}
