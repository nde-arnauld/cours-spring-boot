package M2fst.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class BookEntity {
    @Id
    @Column(name = "isbn")
    private UUID isbn;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "books")
    Set<LibraryEntity> libraries = new HashSet<>();

    public BookEntity(UUID isbn, String name) {
        this.isbn = isbn;
        this.name = name;
    }
}
