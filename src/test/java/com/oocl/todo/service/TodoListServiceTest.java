package com.oocl.todo.service;

import com.oocl.todo.dto.TodoListResponse;
import com.oocl.todo.mapper.TodoRequestMapper;
import com.oocl.todo.model.Todo;
import com.oocl.todo.repository.TodoRepository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class TodoListServiceTest {
    @Test
    void should_return_todolistresponses_when_get_all_todo_given_nothing() {
        // given
        TodoRepository mockTodoListRepository = mock(TodoRepository.class);
        TodoRequestMapper mockTodoRequestMapper = mock(TodoRequestMapper.class);
        given(mockTodoListRepository.findAll()).willReturn(Arrays.asList(getTodo()));
        TodoService todoService = new TodoService(mockTodoListRepository, mockTodoRequestMapper);
        // when
        List<TodoListResponse> todos = todoService.getTodoList();
        // then
        assertEquals(1, todos.size());
    }

    @Test
    void should_return_todolistresponse_when_add_todo_given_a_not_null_todo() {
        // given
        Todo todo = getTodo();
        TodoRepository mockTodoListRepository = mock(TodoRepository.class);
        TodoRequestMapper mockTodoRequestMapper = mock(TodoRequestMapper.class);
        given(mockTodoListRepository.save(todo)).willReturn(getTodo());
        TodoService todoService = new TodoService(mockTodoListRepository, mockTodoRequestMapper);
        // when
        TodoListResponse todoListResponse = todoService.addTodo(todo);
        // then
        assertEquals(todo.getContent(), todoListResponse.getContent());
    }



    private Todo getTodo() {
        return new Todo(1, "zhangsan", false);
    }
}
