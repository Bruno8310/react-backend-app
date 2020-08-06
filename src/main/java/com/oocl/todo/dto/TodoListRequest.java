package com.oocl.todo.dto;


import com.oocl.todo.model.Todo;

public class TodoListRequest {
    private Integer id;

    private String content;

    private Boolean status;

    public TodoListRequest() {
    }

    public TodoListRequest(Integer id, String content, Boolean status) {
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

}
