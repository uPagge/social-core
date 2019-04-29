package org.sadtech.bot.core.domain;

import java.util.Objects;

public class Person {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer sex;
    private String city;

    public Person() {

    }

    public Person(Integer id, String firstName, String lastName, Integer sex, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(sex, person.sex) &&
                Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, sex, city);
    }

}
