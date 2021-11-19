package thethao.day3mapstrucanddtos.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private int id;


    @Column
    private String email;


    @Column
    private String password;


    @Column
    private String name;


    @Column
    private String surname;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_book",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books = new HashSet<>();
}
