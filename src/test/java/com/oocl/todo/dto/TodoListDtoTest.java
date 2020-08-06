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
        System.out.println(todo);
        // then
        assertEquals("shangsan", todo.getContent());
        assertEquals(false, todo.getStatus());
    }
}
