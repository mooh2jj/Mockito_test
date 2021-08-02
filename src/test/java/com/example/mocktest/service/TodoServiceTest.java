package com.example.mocktest.service;

import com.example.mocktest.model.TodoEntity;
import com.example.mocktest.model.TodoRequest;
import com.example.mocktest.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    void add() {
        when(this.todoRepository.save(any(TodoEntity.class)))
                .then(AdditionalAnswers.returnsFirstArg());

        TodoRequest todoRequest = new TodoRequest();
        todoRequest.setTitle("Test Title");

        TodoEntity todoEntity = this.todoService.add(todoRequest);
        assertEquals(todoRequest.getTitle(), todoEntity.getTitle());
    }
}