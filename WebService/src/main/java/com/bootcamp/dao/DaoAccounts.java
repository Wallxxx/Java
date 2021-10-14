package com.bootcamp.dao;

import com.bootcamp.model.Accounts;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class DaoAccounts implements DaoAccountsInterface {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Accounts> getBalanceByUserId(Integer id) {
        return entityManager.createQuery("from Accounts where user = " + id, Accounts.class).getResultList();
    }

    @Override
    public Accounts getBalanceByAccountNumber(String number) {
        return entityManager.createQuery("from Accounts where number = '" + number + "'", Accounts.class)
                .getSingleResult();
    }

    @Override
    @Transactional
    public void addDeposit(String number, BigDecimal value) {
        Accounts newValue = entityManager.createQuery("from Accounts where number = '" + number + "'", Accounts.class)
                .getSingleResult();
        newValue.setBalance(newValue.getBalance().add(value));
        entityManager.merge(newValue);
    }
}
