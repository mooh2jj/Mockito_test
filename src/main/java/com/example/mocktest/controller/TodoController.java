package com.example.mocktest.controller;

import com.example.mocktest.model.TodoRequest;
import com.example.mocktest.model.TodoResponse;
import com.example.mocktest.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @PostMapping("/")
    public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request) {
        return ResponseEntity.ok(new TodoResponse());
    }
}
