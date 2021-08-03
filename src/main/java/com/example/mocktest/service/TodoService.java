package com.example.mocktest.service;

import com.example.mocktest.model.TodoEntity;
import com.example.mocktest.model.TodoRequest;
import com.example.mocktest.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    final private TodoRepository todoRepository;

    //    1	todo 리스트 목록에 아이템을 추가
    public TodoEntity add(TodoRequest request) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(request.getTitle());
        todoEntity.setOrder(request.getOrder());
        todoEntity.setCompleted(request.getCompleted());
        return todoRepository.save(todoEntity);
    }

    //    2	todo  리스트 목록 중 특정 아이템을 조회
    public TodoEntity searchById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //    3	todo 리스트 전체 목록을 조회
    public List<TodoEntity> searchAll() {
        return todoRepository.findAll();
    }

    //    4	todo 리스트 목록 중 특정 아이템을 수정
    //    5	todo 리스트 목록 중 특정 아이템을 삭제
    //    6	todo 리스트 전체 목록을 삭제
}
