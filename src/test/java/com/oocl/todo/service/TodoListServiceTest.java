package com.oocl.todo.service;

import com.oocl.todo.dto.TodoListRequest;
import com.oocl.todo.dto.TodoListResponse;
import com.oocl.todo.mapper.TodoRequestMapper;
import com.oocl.todo.model.Todo;
import com.oocl.todo.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

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
        Todo todo = new Todo(1, "zhangsan", false);
        TodoListRequest todoListRequest = new TodoListRequest(1, "zhangsan", false);
        TodoRepository mockTodoListRepository = mock(TodoRepository.class);
        TodoRequestMapper mockTodoRequestMapper = mock(TodoRequestMapper.class);
        given(mockTodoListRepository.save(todo)).willReturn(getTodo());
        TodoService todoService = new TodoService(mockTodoListRepository, mockTodoRequestMapper);
        when(mockTodoRequestMapper.mapperTodo(todoListRequest)).thenReturn(todo);
        // when
        Todo todo1 = todoService.addTodo(todoListRequest);

        // then
        assertEquals(todo.getContent(), todo1.getContent());
    }

    @Test
    void should_return_new_todo_when_update_todo_given_todo_id() {
        // given
        Todo oldTodo = getTodo();
        Todo newTodo = new Todo(1, "zhangsan", true);
        TodoListRequest todoListRequest = new TodoListRequest(1, "zhangsan", true);
        TodoListResponse todoListResponse = new TodoListResponse(1, "zhangsan", true);

        TodoRepository mockTodoListRepository = mock(TodoRepository.class);
        TodoRequestMapper mockTodoRequestMapper = mock(TodoRequestMapper.class);
        when(mockTodoListRepository.findById(1)).thenReturn(Optional.of(oldTodo));
        when(mockTodoRequestMapper.mapperTodo(todoListRequest)).thenReturn(newTodo);
        when(mockTodoListRepository.save(newTodo)).thenReturn(newTodo);
        when(mockTodoRequestMapper.mapperTodoResponse(newTodo)).thenReturn(todoListResponse);

        // when
        TodoService todoService = new TodoService(mockTodoListRepository, mockTodoRequestMapper);
        TodoListResponse todoListResponse1 = todoService.updateTodo(1, todoListRequest);
        // then
        assertEquals(todoListRequest.getContent(), todoListResponse1.getContent());
    }

    @Test
    void should_return_null_when_update_todo_given_wrong_id() {
        // given
        int id = 2;
        TodoListRequest todoListRequest = new TodoListRequest(1, "zhangsan", true);
        TodoRepository mockTodoListRepository = mock(TodoRepository.class);
        TodoRequestMapper mockTodoRequestMapper = mock(TodoRequestMapper.class);
        // when
        TodoService todoService = new TodoService(mockTodoListRepository, mockTodoRequestMapper);
        TodoListResponse todoListResponse = todoService.updateTodo(id, todoListRequest);
        // then
        assertNull(todoListResponse);
    }

    @Test
    void should_delete_todo_when_delete_todo_given_id() {
        // given
        Todo todo = getTodo();
        TodoRepository mockTodoListRepository = mock(TodoRepository.class);
        TodoRequestMapper mockTodoRequestMapper = mock(TodoRequestMapper.class);
        // when
        TodoService todoService = new TodoService(mockTodoListRepository, mockTodoRequestMapper);
        todoService.deleteTodo(1);
        // then
        verify(mockTodoListRepository).deleteById(1);
    }

    private Todo getTodo() {
        return new Todo(1, "zhangsan", false);
    }
}
