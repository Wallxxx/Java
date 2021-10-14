package com.bootcamp.unit;

import com.bootcamp.dao.DaoAccounts;
import com.bootcamp.model.Accounts;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
public class DaoAccountsTest {

    @Autowired
    private DaoAccounts daoAccounts;

    @Test
    public void DaoAccountsTesting () {
        Assertions.assertThat(daoAccounts).isNotNull();
    }

    @Test
    public void getBalanceByUserIdTest() {
        Accounts accounts = daoAccounts.getBalanceByUserId(1).get(0);
        Assert.assertEquals(new BigDecimal(0), accounts.getBalance());
    }

    @Test
    public void getBalanceByAccountNumberTest() {
        Accounts accounts = daoAccounts.getBalanceByAccountNumber("7908-0000");
        Assert.assertEquals(new BigDecimal(0), accounts.getBalance());
    }

    @Test
    public void addDepositTest() {
        daoAccounts.addDeposit("7908-0000", new BigDecimal(100));
        BigDecimal balance = daoAccounts.getBalanceByAccountNumber("7908-0000").getBalance();
        daoAccounts.addDeposit("7908-0000", new BigDecimal(-100));
        Assert.assertEquals(new BigDecimal(100), balance);
    }
}
