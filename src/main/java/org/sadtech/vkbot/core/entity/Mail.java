package org.sadtech.vkbot.core.entity;

import java.util.Objects;

public class Mail {

    private Integer id;
    private Integer date;
    private Person person;
    private Integer peerId;
    private String body;

    public Mail() {

    }

    public Mail(Integer id, Integer date, Person userId, String body) {
        this.id = id;
        this.date = date;
        this.person = userId;
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getPeerId() {
        return peerId;
    }

    public void setPeerId(Integer peerId) {
        this.peerId = peerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mail mail = (Mail) o;
        return Objects.equals(id, mail.id) &&
                Objects.equals(date, mail.date) &&
                Objects.equals(person, mail.person) &&
                Objects.equals(body, mail.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, person, body);
    }
}
