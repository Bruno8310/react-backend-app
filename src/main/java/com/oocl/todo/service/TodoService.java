package com.oocl.todo.service;

import com.oocl.todo.dto.TodoListResponse;
import com.oocl.todo.mapper.TodoRequestMapper;
import com.oocl.todo.model.Todo;
import com.oocl.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private TodoRequestMapper todoRequestMapper;

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository, TodoRequestMapper todoRequestMapper) {
        this.todoRepository = todoRepository;
        this.todoRequestMapper = todoRequestMapper;
    }

    public List<TodoListResponse> getTodoList() {
        List<Todo> todos = todoRepository.findAll();
        List<TodoListResponse> todoListResponses = new ArrayList<>();
        for (Todo todo : todos) {
            todoListResponses.add(todoRequestMapper.mapperTodoResponse(todo));
        }
        return todoListResponses;
    }

    public TodoListResponse addTodo(Todo todo) {

       return null;
    }
}
