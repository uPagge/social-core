package org.sadtech.bot.core.domain;

//@TODO: Дописать класс
public class Comment {

    private Integer postId;
    private Person person;
    private String text;
    private Integer data;

    public Comment() {

    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
