/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ks.todolist.controller;

import java.util.List;
import ks.todolist.entity.TodoItem;
import ks.todolist.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author coolyeekk
 */
@RestController
@RequestMapping("/api_path/todo")
public class TodoItemController {
    @Autowired
    private TodoItemService service;

    @PostMapping
    public TodoItem addTodoItem(@RequestBody TodoItem item) {
        return service.addTodoItem(item);
    }
    
    @DeleteMapping("/{id}")
    public void deleteTodoItem(@PathVariable("id") Long id) {
        service.deleteTodoItem(id);
    }
    
    @GetMapping
    public List<TodoItem> getAllTodoItems() {
        return service.getAllTodoItems();
    }
    
    @PutMapping("/{id}")
    public TodoItem markTodoItemAsCompleted(@PathVariable("id") Long id) {
        return service.markTodoItemAsCompleted(id);
    }
}

