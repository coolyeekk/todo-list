/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ks.todolist2;

import java.util.List;
import ks.todolist.entity.TodoItem;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author coolyeekk
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodoItemControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void testAddTodoItem() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("<access_token>");
        TodoItem item = new TodoItem();
        item.setTitle("To DO Item");
        HttpEntity<TodoItem> request = new HttpEntity<>(item, headers);
        ResponseEntity<TodoItem> response = restTemplate.postForEntity("/api_path/todo", request, TodoItem.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        TodoItem responseBody = response.getBody();
        assertNotNull(responseBody);
        assertNotNull(responseBody.getId());
        assertEquals(item.getTitle(), responseBody.getTitle());
}


    @Test
    public void testDeleteTodoItem() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("<access_token>");
        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<Void> response = restTemplate.exchange("/api_path/todo/<todo_id>", HttpMethod.DELETE, request, Void.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetAllTodoItems() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("<access_token>");
        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<List> response = restTemplate.exchange("/api_path/todo", HttpMethod.GET, request, List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testMarkTodoItemAsCompleted() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("<access_token>");
        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<TodoItem> response = restTemplate.exchange("/api_path/todo/<todo_id>", HttpMethod.PUT, request, TodoItem.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().isCompleted());
    }
}

