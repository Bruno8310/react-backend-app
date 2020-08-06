package com.oocl.todo.mapper;


import com.oocl.todo.dto.TodoListRequest;
import com.oocl.todo.dto.TodoListResponse;
import com.oocl.todo.model.Todo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TodoRequestMapper {

    public Todo mapperTodo(TodoListRequest todoListRequest) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoListRequest, todo);
        return todo;
    }

    public TodoListResponse mapperTodoResponse(Todo todo) {
        TodoListResponse  todoListResponse = new TodoListResponse();
        BeanUtils.copyProperties(todo, todoListResponse);
        return todoListResponse;
    }
}
