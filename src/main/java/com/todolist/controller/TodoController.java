package com.todolist.controller;

import com.todolist.entity.Todo;
import com.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {
    
    @Autowired
    private TodoService todoService;
    
    @GetMapping("/")
    public String todoList(Model model) {
        try {
            List<Todo> todos = todoService.getAllTodos();
            
            // Add statistics to the model with null safety
            model.addAttribute("todos", todos != null ? todos : new ArrayList<>());
            model.addAttribute("totalCount", todoService.getTotalCount());
            model.addAttribute("pendingCount", todoService.getPendingCount());
            model.addAttribute("completedCount", todoService.getCompletedCount());
            
            // Add a new todo object for the form
            model.addAttribute("newTodo", new Todo());
        } catch (Exception e) {
            System.err.println("Error loading todos: " + e.getMessage());
            model.addAttribute("todos", new ArrayList<>());
            model.addAttribute("totalCount", 0L);
            model.addAttribute("pendingCount", 0L);
            model.addAttribute("completedCount", 0L);
            model.addAttribute("newTodo", new Todo());
            model.addAttribute("error", "Failed to load tasks. Please try again.");
        }
        
        return "todolist";
    }
    
    @PostMapping("/add")
    public String addTodo(@ModelAttribute Todo todo, RedirectAttributes redirectAttributes) {
        try {
            if (todo.getTitle() == null || todo.getTitle().trim().isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "Task title cannot be empty!");
                return "redirect:/";
            }
            
            // Set default priority if not provided
            if (todo.getPriority() == null) {
                todo.setPriority(Todo.Priority.MEDIUM);
            }
            
            todoService.saveTodo(todo);
            redirectAttributes.addFlashAttribute("success", "Task added successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to add task: " + e.getMessage());
        }
        
        return "redirect:/";
    }
    
    @PostMapping("/toggle/{id}")
    public String toggleTodo(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            Todo todo = todoService.toggleTodoCompletion(id);
            if (todo != null) {
                String status = todo.isCompleted() ? "completed" : "pending";
                redirectAttributes.addFlashAttribute("success", "Task marked as " + status + "!");
            } else {
                redirectAttributes.addFlashAttribute("error", "Task not found!");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to update task: " + e.getMessage());
        }
        
        return "redirect:/";
    }
    
    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            todoService.deleteTodo(id);
            redirectAttributes.addFlashAttribute("success", "Task deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to delete task: " + e.getMessage());
        }
        
        return "redirect:/";
    }
    
    @GetMapping("/api/test")
    @ResponseBody
    public String apiTest() {
        return "API working! Todo count: " + todoService.getTotalCount();
    }
}