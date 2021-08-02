package com.example.mocktest.repository;

import com.example.mocktest.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

}
