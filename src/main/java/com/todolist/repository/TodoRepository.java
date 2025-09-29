package com.todolist.repository;

import com.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    
    List<Todo> findByCompletedOrderByCreatedAtDesc(boolean completed);
    
    List<Todo> findAllByOrderByCreatedAtDesc();
    
    @Query("SELECT COUNT(t) FROM Todo t WHERE t.completed = false")
    long countPendingTodos();
    
    @Query("SELECT COUNT(t) FROM Todo t WHERE t.completed = true")
    long countCompletedTodos();
    
    List<Todo> findByPriorityOrderByCreatedAtDesc(Todo.Priority priority);
}