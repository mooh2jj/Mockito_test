package com.example.mocktest.controller;

import com.example.mocktest.model.TodoEntity;
import com.example.mocktest.model.TodoRequest;
import com.example.mocktest.model.TodoResponse;
import com.example.mocktest.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class TodoController {

    private final TodoService service;

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request) {
        log.info("create");

        if (ObjectUtils.isEmpty(request.getTitle())) {
            return ResponseEntity.badRequest().build();
        }

        if (ObjectUtils.isEmpty(request.getOrder())) {
            request.setOrder(0L);
        }

        if (ObjectUtils.isEmpty(request.getCompleted())) {
            request.setCompleted(false);
        }

        TodoEntity result = this.service.add(request);

        System.out.println("result: " + result);

        return ResponseEntity.ok(new TodoResponse(result));

    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> readOne(@PathVariable Long id) {
        System.out.println("Read One");
        TodoEntity result = service.searchById(id);

        return ResponseEntity.ok(new TodoResponse(result));
    }


    @GetMapping("/")
    public ResponseEntity<List<TodoResponse>> readAll() {
        System.out.println("Read All");
        List<TodoEntity> result = this.service.searchAll();
        List<TodoResponse> responses = result.stream()
                .map(TodoResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TodoResponse> update(@PathVariable Long id, @RequestBody TodoRequest request) {
        log.info("update");
        TodoEntity result = this.service.updateById(id, request);
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id) {
        log.info("delete One");
        this.service.deleteOne(id);
        return ResponseEntity.ok().build();     // ResponseEntity.ok()??? ??????
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() {
        log.info("delete All");
        this.service.deleteAll();
        return ResponseEntity.ok().build();     // ResponseEntity.ok()??? ??????
    }
}
