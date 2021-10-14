package com.bootcamp.unit;

import com.bootcamp.dao.DaoCards;
import com.bootcamp.model.Cards;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
public class DaoCardsTest {

    @Autowired
    private DaoCards daoCards;

    @Test
    public void DaoCardsTesting() {
        Assertions.assertThat(daoCards).isNotNull();
    }

    @Test
    public void getCardsByUserIdTest() {
        List<Cards> cards = daoCards.getCardsByUserId(1);
        Assert.assertEquals(2, cards.size());
    }

    @Test
    public void getCountCardsByAccountTest() {
        Long cards = daoCards.getCountCardsByAccount("7908-0000");
        Assert.assertEquals(Long.valueOf(2), cards);
    }

    @Test
    public void newCardTest() {
        daoCards.newCard("7908-0021");
        Long cards = daoCards.getCountCardsByAccount("7908-0021");
        Assert.assertEquals(Long.valueOf(2), cards);
    }
}
