package com.mysite.crud.services;

import com.mysite.crud.model.ToDo;
import com.mysite.crud.repositories.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService{
    ToDoRepository toDoRepository;

    public ToDoServiceImpl(ToDoRepository toDoRepository){
        this.toDoRepository = toDoRepository;
    }

    @Override
    public List<ToDo> getToDos() {
        List<ToDo> toDos = new ArrayList<>();
        toDoRepository.findAll().forEach(toDos::add);
        return toDos;
    }

    @Override
    public ToDo getToDoById(Long id) {
        return toDoRepository.findById(id).get();
    }

    @Override
    public ToDo insert(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @Override
    public void updateToDo(Long id, ToDo toDo) {
        ToDo toDoFromDb = toDoRepository.findById(id).get();
        System.out.println(toDoFromDb.toString());
//        toDoFromDb.setToDoStatus(toDo.getToDoStatus());
        toDoFromDb.setDescription(toDo.getDescription());
        toDoFromDb.setTitle(toDo.getTitle());
        toDoRepository.save(toDoFromDb);
    }

    @Override
    public void deleteToDo(Long toDoId) {
        toDoRepository.deleteById(toDoId);
    }
}
