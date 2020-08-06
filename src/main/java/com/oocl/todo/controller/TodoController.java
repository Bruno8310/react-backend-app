package com.oocl.todo.controller;

import com.oocl.todo.dto.TodoListRequest;
import com.oocl.todo.dto.TodoListResponse;
import com.oocl.todo.model.Todo;
import com.oocl.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="https://localhost:3000")
@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<TodoListResponse> getAllTodo() {
        return todoService.getTodoList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Todo addTodo(@RequestBody  TodoListRequest todoListRequest) {
        return todoService.addTodo(todoListRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    TodoListResponse updateTodo(@PathVariable Integer id, @RequestBody TodoListRequest todoListRequest) {
        System.out.println(todoListRequest.toString());
        return todoService.updateTodo(id, todoListRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteTodo(@PathVariable Integer id) {
        todoService.deleteTodo(id);
    }
}
