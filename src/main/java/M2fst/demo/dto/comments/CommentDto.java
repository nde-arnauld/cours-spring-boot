package M2fst.demo.dto.comments;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommentDto {
    @NotBlank
    private int id;

    @NotBlank
    private String content;
}
