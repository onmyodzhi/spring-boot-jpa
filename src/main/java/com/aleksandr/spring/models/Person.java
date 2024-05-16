package com.aleksandr.spring.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int personId;

    @Column(name = "full_name")
    @NotEmpty(message = "This field should not empty")
    @NotNull(message = "This field should not empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Pattern(regexp = "[A-Z][- A-Za-z]+", message = "Full name must begin with a capital letter and can only contain letters, hyphens, and spaces")
    private String fullName;

    @Column(name = "year_of_birth")
    @Min(value = 1900, message = "age of year should be more then 1900")
    @NotNull(message = "field year of birth should not be empty")
    private int yearOfBirth;

    @OneToMany(mappedBy = "owner")
    private List<Book> books;

    public Person(String FullName, int ageOfYear) {
        this.fullName = FullName;
        this.yearOfBirth = ageOfYear;
    }

    public Person() {
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getPersonId() == person.getPersonId() && getYearOfBirth() == person.getYearOfBirth() && Objects.equals(getFullName(), person.getFullName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonId(), getFullName(), getYearOfBirth());
    }

    @Override
    public String toString() {
        return
                "person id = " + personId +
                ", Full name = '" + fullName + '\'' +
                ", year of birth = " + yearOfBirth;
    }
}
