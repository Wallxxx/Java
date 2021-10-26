package com.rest.dao;

import com.rest.model.Counter;
import com.rest.model.Memory;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Repository
public class DaoCounters implements DaoCountersInterface {

    private final Set<Counter> data = new Memory().getData();

    @Override
    public void create(String name) {
        data.add(new Counter(name, 0));
    }

    @Override
    public void inc(String name) {
        for (Counter counter : data) {
            if (Objects.equals(counter.getName(), name)) {
                counter.setValue(counter.getValue() + 1);
                break;
            }
        }
    }

    @Override
    public Integer get(String name) {
        int value = 0;
        for (Counter counter : data) {
            if (Objects.equals(counter.getName(), name)) {
                value = counter.getValue();
                break;
            }
        }
        return value;
    }

    @Override
    public void delete(String name) {
        data.removeIf(counter -> Objects.equals(counter.getName(), name));
    }

    @Override
    public Integer sum() {
        int value = 0;
        for (Counter counter : data) {
            value += counter.getValue();
        }
        return value;
    }

    @Override
    public Set<String> showNames() {
        Set<String> answer = new HashSet<>();
        for (Counter counter : data) {
            answer.add(counter.getName());
        }
        return answer;
    }

    @Override
    public boolean isHave(String name) {
        boolean have = false;
        for (Counter counter : data) {
            if (Objects.equals(counter.getName(), name)) {
                have = true;
                break;
            }
        }
        return have;
    }
}
