package com.aleksandr.spring.models;

import org.hibernate.validator.constraints.NotEmpty;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Book")
public class Book implements Comparable<Book>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "title")
    @NotEmpty(message = "field title should not be empty")
    @Size(max = 100)
    private String title;

    @Column(name = "author")
    @NotEmpty(message = "field author should not be empty")
    @Pattern(regexp = "[A-Z][- A-Za-z]+", message = "The author must begin with a capital letter and can only contain letters, hyphens, and spaces")
    private String author;

    @Column(name = "age_of_release")
    @NotNull(message = "Field age of release should not be empty")
    @Min(value = -2000, message = "must be greater than or equal to -2000")
    @Max(value = 2024, message = "must be less than or equal to 2024")
    private int ageOfRelease;

    @Column(name = "date_of_assign")
    private LocalDate dateOfAssign;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person owner;

    public Book(String title, String author, int ageOfRelease) {
        this.title = title;
        this.author = author;
        this.ageOfRelease = ageOfRelease;
    }

    public Book() {
    }

    @Override
    public int compareTo(Book otherBook) {
        return this.ageOfRelease - otherBook.ageOfRelease;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public @NotEmpty(message = "field title should not be empty") @Size(max = 100) String getTitle() {
        return title;
    }

    public void setTitle(@NotEmpty(message = "field title should not be empty") @Size(max = 100) String title) {
        this.title = title;
    }

    public @NotEmpty(message = "field author should not be empty") @Pattern(regexp = "[A-Z][- A-Za-z]+", message = "The author must begin with a capital letter and can only contain letters, hyphens, and spaces") String getAuthor() {
        return author;
    }

    public void setAuthor(@NotEmpty(message = "field author should not be empty") @Pattern(regexp = "[A-Z][- A-Za-z]+", message = "The author must begin with a capital letter and can only contain letters, hyphens, and spaces") String author) {
        this.author = author;
    }

    public @NotNull(message = "field age of release should not be empty") @Min(value = -2000) @Max(value = 2024) int getAgeOfRelease() {
        return ageOfRelease;
    }

    public void setAgeOfRelease(@NotNull(message = "field age of release should not be empty") @Min(value = -2000) @Max(value = 2024) int ageOfRelease) {
        this.ageOfRelease = ageOfRelease;
    }

    public LocalDate getDateOfAssign() {
        return dateOfAssign;
    }

    public void setDateOfAssign(LocalDate dateOfAssign) {
        this.dateOfAssign = dateOfAssign;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getBookId() == book.getBookId() && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(getAgeOfRelease(), book.getAgeOfRelease());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getTitle(), getAuthor(), getAgeOfRelease());
    }

    @Override
    public String toString() {
        return
                "book id = " + bookId +
                ", title = '" + title + '\'' +
                ", author = '" + author + '\'' +
                ", age of release = '" + ageOfRelease + '\'';
    }
}
