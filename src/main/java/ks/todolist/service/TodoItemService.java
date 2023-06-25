/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ks.todolist.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import ks.todolist.entity.TodoItem;
import ks.todolist.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author coolyeekk
 */
@Service
public class TodoItemService {
    @Autowired
    private TodoItemRepository repository;

    public void deleteTodoItem(Long id) {
        repository.deleteById(id);
    }
    
    public List<TodoItem> getAllTodoItems() {
        return repository.findAll();
    }

    public TodoItem addTodoItem(TodoItem item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public TodoItem markTodoItemAsCompleted(Long id) {
        TodoItem item = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("TodoItem not found"));
        item.setCompleted(true);
        return repository.save(item);
    }
}
