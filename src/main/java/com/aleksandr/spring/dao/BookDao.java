package com.aleksandr.spring.dao;

import com.aleksandr.spring.models.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Optional;

@Repository
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Optional<Person> findPersonByBookId(int bookId){
        Query query = entityManager.createQuery("SELECT p FROM Book b JOIN b.owner p WHERE b.bookId=:bookId");
        query.setParameter("bookId", bookId);
        return query.getResultStream().findAny();
    }
}
