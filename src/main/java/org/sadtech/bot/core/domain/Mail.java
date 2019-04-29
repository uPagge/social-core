package org.sadtech.bot.core.domain;

import java.util.Objects;

public class Mail {

    private Integer id;
    private Integer date;
    private Integer peerId;
    private String body;

    public Mail() {

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
                Objects.equals(body, mail.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, body);
    }

    @Override
    public String toString() {
        return "Mail{" +
                "id=" + id +
                ", date=" + date +
                ", peerId=" + peerId +
                ", body='" + body + '\'' +
                '}';
    }
}
