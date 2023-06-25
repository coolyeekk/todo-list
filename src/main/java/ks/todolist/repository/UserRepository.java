/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ks.todolist.repository;

import java.util.Optional;
import ks.todolist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author coolyeekk
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    public User findByEmail(String email);
}
