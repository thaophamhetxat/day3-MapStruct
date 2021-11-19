package thethao.day3mapstrucanddtos.mappers.impl;

import org.apache.catalina.User;
import org.springframework.stereotype.Component;
import thethao.day3mapstrucanddtos.dto.*;
import thethao.day3mapstrucanddtos.mappers.MapStructMapper;
import thethao.day3mapstrucanddtos.model.Author;


import javax.annotation.Generated;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2021-03-11T19:21:44+0100",
        comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public BookSlimDto bookToBookSlimDto(BookSlimDto book) {
        if (book == null) {
            return null;
        }

        BookSlimDto bookSlimDto = new BookSlimDto();

        bookSlimDto.setId(book.getId());
        bookSlimDto.setTitle(book.getTitle());

        return bookSlimDto;
    }

    @Override
    public BookDto bookToBookDto(BookDto book) {
        if (book == null) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setReleaseDate(book.getReleaseDate());
        bookDto.setAuthors(authorSetToAuthorDtoSet(book.getAuthors()));

        return bookDto;
    }

    @Override
    public AuthorDto authorToAuthorDto(Author author) {
        if (author == null) {
            return null;
        }

        AuthorDto authorDto = new AuthorDto();

        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setSurname(author.getSurname());
        authorDto.setBirthDate(author.getBirthDate());

        return authorDto;
    }

    @Override
    public AuthorAllDto authorToAuthorAllDto(Author author) {
        if (author == null) {
            return null;
        }

        AuthorAllDto authorAllDto = new AuthorAllDto();

        authorAllDto.setId(author.getId());
        authorAllDto.setName(author.getName());
        authorAllDto.setSurname(author.getSurname());
        authorAllDto.setBirthDate(author.getBirthDate());
        authorAllDto.setBooks(bookSetToBookSlimDtoSet(author.getBooks()));

        return authorAllDto;
    }

    @Override
    public List<AuthorAllDto> authorsToAuthorAllDtos(List<Author> authors) {
        if (authors == null) {
            return null;
        }

        List<AuthorAllDto> list = new ArrayList<AuthorAllDto>(authors.size());
        for (Author author : authors) {
            list.add(authorToAuthorAllDto(author));
        }

        return list;
    }

    @Override
    public UserGetDto userToUserGetDto(User user) {
        if (user == null) {
            return null;
        }

        UserGetDto userGetDto = new UserGetDto();

        userGetDto.setId(user.getId());
        userGetDto.setEmail(user.getEmail());
        userGetDto.setName(user.getName());
        userGetDto.setSurname(user.getSurname());

        return userGetDto;
    }

    @Override
    public User userPostDtoToUser(UserPostDto userPostDto) {
        if (userPostDto == null) {
            return null;
        }

        User user = new User();

        user.setId(userPostDto.getId());
        user.setEmail(userPostDto.getEmail());
        user.setPassword(userPostDto.getPassword());
        user.setName(userPostDto.getName());
        user.setSurname(userPostDto.getSurname());

        return user;
    }

    protected Set<AuthorDto> authorSetToAuthorDtoSet(Set<Author> set) {
        if (set == null) {
            return null;
        }

        Set<AuthorDto> set1 = new HashSet<AuthorDto>(Math.max((int) (set.size() / .75f) + 1, 16));
        for (Author author : set) {
            set1.add(authorToAuthorDto(author));
        }

        return set1;
    }

    protected Set<BookSlimDto> bookSetToBookSlimDtoSet(Set<Book> set) {
        if (set == null) {
            return null;
        }

        Set<BookSlimDto> set1 = new HashSet<BookSlimDto>(Math.max((int) (set.size() / .75f) + 1, 16));
        for (Book book : set) {
            set1.add(bookToBookSlimDto(book));
        }

        return set1;
    }
}
