package com.oocl.todo.service;

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
    void should_return_todolist_when_get_all_todo_given_nothing() {
        // given
        TodoRepository mockTodoListRepository = mock(TodoRepository.class);
        given(mockTodoListRepository.findAll()).willReturn(Arrays.asList(getTodo()));
        TodoService todoService = new TodoService(mockTodoListRepository);
        // when
        List<Todo> todos = todoService.getTodoList();
        // then
        assertEquals(1, todos.size());

    }



    private Todo getTodo() {
        return new Todo(1, "zhangsan", false);
    }
}
