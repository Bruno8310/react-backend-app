package com.oocl.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    private Boolean status;

    public Todo() {
    }

    public Todo(Integer id, String content, Boolean status) {
        this.id = id;
        this.content = content;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(id, todo.id) &&
                Objects.equals(content, todo.content) &&
                Objects.equals(status, todo.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, status);
    }
}
