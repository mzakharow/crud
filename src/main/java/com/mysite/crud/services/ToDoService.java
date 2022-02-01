package com.mysite.crud.services;

import com.mysite.crud.model.ToDo;

import java.util.List;

public interface ToDoService {
    List<ToDo> getToDos();

    ToDo getToDoById(Long id);

    ToDo insert(ToDo toDo);

    void updateToDo(Long id, ToDo toDo);

    void deleteToDo(Long toDoId);
}
