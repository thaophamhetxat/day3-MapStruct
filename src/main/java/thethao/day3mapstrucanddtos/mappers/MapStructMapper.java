package thethao.day3mapstrucanddtos.mappers;

import org.apache.catalina.User;
import org.mapstruct.Mapper;
import thethao.day3mapstrucanddtos.dto.*;
import thethao.day3mapstrucanddtos.model.Author;

import java.awt.print.Book;
import java.util.List;

@Mapper(
        componentModel = "spring"
)

public interface MapStructMapper {
    BookSlimDto bookToBookSlimDto(BookSlimDto book);

    BookDto bookToBookDto(BookDto book);

    AuthorDto authorToAuthorDto(Author author);

    AuthorAllDto authorToAuthorAllDto(Author author);

    List<AuthorAllDto> authorsToAuthorAllDtos(List<Author> authors);

    UserGetDto userToUserGetDto(User user);

    User userPostDtoToUser(UserPostDto userPostDto);
}
