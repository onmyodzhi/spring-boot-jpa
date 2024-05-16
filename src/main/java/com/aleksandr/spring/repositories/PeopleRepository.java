package com.aleksandr.spring.repositories;

import com.aleksandr.spring.models.Book;
import com.aleksandr.spring.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findPersonByFullName(String fullName);
}
