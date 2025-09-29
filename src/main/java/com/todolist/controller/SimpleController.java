package com.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class SimpleController {
    
    // Simple in-memory storage for testing
    private static final List<Map<String, Object>> todos = new ArrayList<>();
    private static final AtomicLong idCounter = new AtomicLong(1);
    
    @GetMapping("/simple")
    public String simpleTodoList(Model model) {
        model.addAttribute("todos", todos);
        model.addAttribute("totalCount", todos.size());
        model.addAttribute("pendingCount", todos.stream().mapToLong(t -> (Boolean)t.get("completed") ? 0 : 1).sum());
        model.addAttribute("completedCount", todos.stream().mapToLong(t -> (Boolean)t.get("completed") ? 1 : 0).sum());
        return "simple-todolist";
    }
    
    @PostMapping("/simple/add")
    public String addSimpleTodo(@RequestParam String title, 
                               @RequestParam(required = false) String description,
                               @RequestParam String priority,
                               RedirectAttributes redirectAttributes) {
        Map<String, Object> todo = new HashMap<>();
        todo.put("id", idCounter.getAndIncrement());
        todo.put("title", title);
        todo.put("description", description);
        todo.put("priority", priority);
        todo.put("completed", false);
        
        todos.add(todo);
        redirectAttributes.addFlashAttribute("success", "Task added successfully!");
        return "redirect:/simple";
    }
    
    @PostMapping("/simple/toggle/{id}")
    public String toggleSimpleTodo(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        todos.stream()
             .filter(t -> t.get("id").equals(id))
             .findFirst()
             .ifPresent(t -> t.put("completed", !(Boolean)t.get("completed")));
        return "redirect:/simple";
    }
    
    @PostMapping("/simple/delete/{id}")
    public String deleteSimpleTodo(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        todos.removeIf(t -> t.get("id").equals(id));
        redirectAttributes.addFlashAttribute("success", "Task deleted!");
        return "redirect:/simple";
    }
}