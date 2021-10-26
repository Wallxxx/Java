package com.rest.unit;

import com.rest.dao.DaoCounters;
import com.rest.model.Counter;
import com.rest.model.Memory;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoCountersTests {

    @Autowired
    private DaoCounters daoCounters;

    private final Set<Counter> data = new Memory().getData();

    @Before
    public void load() {
        data.add(new Counter("temp1", 10));
        data.add(new Counter("temp2", 0));
        data.add(new Counter("temp3", 0));
        data.add(new Counter("temp4", 0));
    }

    @Test
    public void DaoCountersTest() {
        Assertions.assertThat(daoCounters).isNotNull();
    }

    @Test
    public void createTest() {
        daoCounters.create("temp5");
        Assert.assertEquals(5, data.size());
    }

    @Test
    public void incTest() {
        daoCounters.inc("temp1");
        Assert.assertEquals(java.util.Optional.of(11), java.util.Optional.of(daoCounters.get("temp1")));
    }

    @Test
    public void getTest() {
        Assert.assertNotNull(daoCounters.get("temp1"));
    }

    @Test
    public void delete() {
        daoCounters.delete("temp4");
        Assert.assertEquals(3, data.size());
    }

    @Test
    public void sumTest() {
        Assert.assertTrue(daoCounters.sum() > 9);
    }

    @Test
    public void isHaveTest() {
        Assert.assertTrue(daoCounters.isHave("temp2"));
    }

    @Test
    public void isHaveNotFoundTest() {
        Assert.assertFalse(daoCounters.isHave("temp234"));
    }
}
