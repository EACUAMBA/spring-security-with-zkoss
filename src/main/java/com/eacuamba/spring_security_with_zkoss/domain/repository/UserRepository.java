package com.eacuamba.spring_security_with_zkoss.domain.repository;

import com.eacuamba.spring_security_with_zkoss.domain.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAllUsers(){
        TypedQuery<User> userTypedQuery = this.entityManager.createQuery("select u from User u", User.class);
        return userTypedQuery.getResultList();
    }
}
