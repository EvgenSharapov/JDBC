package org.example.entity;

import java.sql.Date;

public class Employee {

    private Integer id;
    private String name;
    private String occupation;
    private Integer salary;
    private Integer age;
    private Date joinDate;



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", occupation='").append(occupation).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", age=").append(age);
        sb.append(", joinDate=").append(joinDate);
        sb.append('}');
        return sb.toString();
    }
//modified
    public Employee setId(Integer id) {
        this.id = id;
        return this;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public Employee setOccupation(String occupation) {
        this.occupation = occupation;
        return this;
    }

    public Employee setSalary(Integer salary) {
        this.salary = salary;
        return this;
    }

    public Employee setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Employee setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getAge() {
        return age;
    }

    public java.sql.Date getJoinDate() {
        return joinDate;
    }
}
