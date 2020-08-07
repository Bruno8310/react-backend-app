package com.oocl.todo.service;

import com.oocl.todo.dto.TodoListRequest;
import com.oocl.todo.dto.TodoListResponse;
import com.oocl.todo.mapper.TodoRequestMapper;
import com.oocl.todo.model.Todo;
import com.oocl.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public Todo addTodo(TodoListRequest todoListRequest) {
        Todo todo = todoRequestMapper.mapperTodo(todoListRequest);
        return todoRepository.save(todo);
    }

    public TodoListResponse updateTodo(Integer id, TodoListRequest todoListRequest) {
        if (!id.equals(todoListRequest.getId())) {
            return null;
        }
        Todo newTodo = todoRequestMapper.mapperTodo(todoListRequest);
        System.out.println(newTodo.toString());
        Todo oldTodo = todoRepository.findById(id).get();

        if (Objects.nonNull(oldTodo.getStatus())) {
            oldTodo.setStatus(newTodo.getStatus());
        }
        return todoRequestMapper.mapperTodoResponse(todoRepository.save(oldTodo));
    }

    public void deleteTodo(Integer id) {
        todoRepository.deleteById(id);
    }
}
