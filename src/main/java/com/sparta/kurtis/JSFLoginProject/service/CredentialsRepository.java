package com.sparta.kurtis.JSFLoginProject.service;

import com.sparta.kurtis.JSFLoginProject.entity.Credentials;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CredentialsRepository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Map<String, Credentials> getAllCredentialsMap() {
        Map<String, Credentials> credentialsMap = new LinkedHashMap<>();

        for (Credentials credential : getAllCredentials()) {
            credentialsMap.put(credential.getUsername(), credential);
        }

        return credentialsMap;
    }

    private Collection<Credentials> getAllCredentials() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Credentials> criteriaQuery = criteriaBuilder.createQuery(Credentials.class);
        Root<Credentials> credentialsRoot = criteriaQuery.from(Credentials.class);
        criteriaQuery.select(credentialsRoot);
        TypedQuery<Credentials> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }

    public void addCredential(Credentials credentials) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(credentials);
        entityManager.flush();
        entityManager.refresh(credentials);
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
