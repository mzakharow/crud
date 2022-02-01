package com.mysite.crud.controllers;

import com.mysite.crud.model.ToDo;
import com.mysite.crud.services.ToDoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class ToDoController {
    ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public ResponseEntity<List<ToDo>> getAllToDos() {
        List<ToDo> toDos = toDoService.getToDos();
        return new ResponseEntity<>(toDos, HttpStatus.OK);
    }

    @GetMapping({"/{toDoId}"})
    public ResponseEntity<ToDo> getToDo(@PathVariable Long toDoId) {
        return new ResponseEntity<>(toDoService.getToDoById(toDoId), HttpStatus.OK);
    }

    public ResponseEntity<ToDo> saveToDo(@RequestBody ToDo toDo) {
        ToDo toDo1 = toDoService.insert(toDo);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("toDo", "/api/v1/todo" + toDo1.getId().toString());
        return new ResponseEntity<>(toDo1, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{toDoId}"})
    public ResponseEntity<ToDo> updateTodo(@PathVariable("toDoId") Long todoId, @RequestBody ToDo toDo) {
        toDoService.updateToDo(todoId, toDo);
        return new ResponseEntity<>(toDoService.getToDoById(todoId), HttpStatus.OK);
    }

    @DeleteMapping({"/{toDoId}"})
    public ResponseEntity<ToDo> deleteTodo(@PathVariable("toDoId") Long toDoId) {
        toDoService.deleteToDo(toDoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
