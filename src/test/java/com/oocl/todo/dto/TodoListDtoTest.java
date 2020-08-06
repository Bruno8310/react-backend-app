package com.oocl.todo.dto;


import com.oocl.todo.mapper.TodoRequestMapper;
import com.oocl.todo.model.Todo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class TodoListDtoTest {
    @Test
    void should_return_todo_when_todoResquest_mapper_to_todo_given_todoResquest() {
        // given
        TodoListRequest todoListRequest = new TodoListRequest(1, "shangsan", false);
        TodoRequestMapper todoRequestMapper = new TodoRequestMapper();
        // when
        Todo todo = todoRequestMapper.mapperTodo(todoListRequest);

        // then
        assertEquals("shangsan", todo.getContent());
        assertEquals(false, todo.getStatus());
    }

    @Test
    void should_return_todoresponse_when_todo_mapper_todoresponse_todo_given_todo() {
        // given
        Todo todo = new Todo(1, "shangsan", false);
        TodoRequestMapper todoRequestMapper = new TodoRequestMapper();
        // when
        TodoListResponse todoResponse = todoRequestMapper.mapperTodoResponse(todo);

        // then
        assertEquals("shangsan", todoResponse.getContent());
        assertEquals(false, todoResponse.getStatus());
    }
}
