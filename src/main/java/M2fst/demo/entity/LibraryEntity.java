package M2fst.demo.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "libraries")
public class LibraryEntity {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany
            @JoinTable(
                    name = "book_library",
                    joinColumns = @JoinColumn(name = "library_id"),
                    inverseJoinColumns = @JoinColumn(name = "isbn")
            )
    Set<BookEntity> books = new HashSet<>();
}
