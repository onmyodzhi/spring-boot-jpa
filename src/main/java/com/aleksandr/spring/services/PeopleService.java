package com.aleksandr.spring.services;

import com.aleksandr.spring.models.Book;
import com.aleksandr.spring.models.Person;
import com.aleksandr.spring.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findById(int id) {
        return peopleRepository.findById(id).orElse(null);
    }

    @Transactional
    public Person save(Person person) {
        return peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person person) {
        Person updatedPerson = peopleRepository.findById(id).orElse(null);
        if (updatedPerson != null) {
            updatedPerson.setFullName(person.getFullName());
            updatedPerson.setYearOfBirth(person.getYearOfBirth());
            peopleRepository.save(updatedPerson);
        }
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }

    public List<Book> findBooksByPersonId(Person person) {
        return peopleRepository.findBooksByPersonId(person);
    }

    public Optional<Person> findPersonByFullName(String fullName) {
        return peopleRepository.findPersonByFullName(fullName);
    }
}
