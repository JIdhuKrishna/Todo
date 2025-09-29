package com.todolist.service;

import com.todolist.entity.Todo;
import com.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    
    @Autowired
    private TodoRepository todoRepository;
    
    public List<Todo> getAllTodos() {
        return todoRepository.findAllByOrderByCreatedAtDesc();
    }
    
    public List<Todo> getPendingTodos() {
        return todoRepository.findByCompletedOrderByCreatedAtDesc(false);
    }
    
    public List<Todo> getCompletedTodos() {
        return todoRepository.findByCompletedOrderByCreatedAtDesc(true);
    }
    
    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }
    
    public Todo createTodo(String title, String description, Todo.Priority priority) {
        Todo todo = new Todo(title, description, priority);
        return todoRepository.save(todo);
    }
    
    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }
    
    public Todo toggleTodoCompletion(Long id) {
        Optional<Todo> todoOpt = todoRepository.findById(id);
        if (todoOpt.isPresent()) {
            Todo todo = todoOpt.get();
            todo.setCompleted(!todo.isCompleted());
            return todoRepository.save(todo);
        }
        return null;
    }
    
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
    
    public long getPendingCount() {
        return todoRepository.countPendingTodos();
    }
    
    public long getCompletedCount() {
        return todoRepository.countCompletedTodos();
    }
    
    public long getTotalCount() {
        return todoRepository.count();
    }
}