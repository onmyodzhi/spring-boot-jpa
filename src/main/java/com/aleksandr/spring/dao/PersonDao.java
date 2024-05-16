package com.aleksandr.spring.dao;

import com.aleksandr.spring.models.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Book> findBooksByPersonId(int id){
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }
}
