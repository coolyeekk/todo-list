/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ks.todolist.repository;

import ks.todolist.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author coolyeekk
 */
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {}
