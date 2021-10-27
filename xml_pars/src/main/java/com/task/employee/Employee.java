package com.task.employee;

import lombok.Getter;

@Getter
public class Employee {

    private static Integer globalID = 0;

    private final Integer id;
    private final String name;
    private final String surname;
    private final String position;
    private Integer salary;

    public Employee(Integer id, String name, String surname, String position, Integer salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.salary = salary;
        if (globalID < id) globalID = id + 1;
    }

    public Employee(String name, String surname, String position, Integer salary) {
        this.id = globalID;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.salary = salary;
        globalID = globalID + 1;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
