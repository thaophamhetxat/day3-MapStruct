package thethao.day3mapstrucanddtos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "native")
    private int id;

    @Column
    private String title;


    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @ManyToMany(
            fetch = FetchType.LAZY,
            mappedBy = "books"
    )
    private Set<Author> authors = new HashSet<>();

    @ManyToMany(
            fetch = FetchType.LAZY,
            mappedBy = "books"
    )
    private Set<User> users = new HashSet<>();
}
