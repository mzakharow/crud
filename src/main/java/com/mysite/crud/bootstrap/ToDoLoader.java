package com.mysite.crud.bootstrap;

import com.mysite.crud.model.ToDo;
import com.mysite.crud.model.ToDoStatus;
import com.mysite.crud.repositories.ToDoRepository;
import org.springframework.boot.CommandLineRunner;

public class ToDoLoader implements CommandLineRunner {
    public final ToDoRepository toDoRepository;

    public ToDoLoader(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadToDos();
    }

    private void loadToDos() {
        if (toDoRepository.count() == 0) {
            toDoRepository.save(
                    ToDo.builder()
                            .title("Go to market")
                            .description("Buy eggs from market")
                            .todoStatus(ToDoStatus.NOT_COMPLETED)
                            .build()
            );
            toDoRepository.save(
                    ToDo.builder()
                            .title("Go to school")
                            .description("Complete assignments")
                            .todoStatus(ToDoStatus.NOT_COMPLETED)
                            .build()
            );
            System.out.println("Sample Todos Loaded");
        }
    }
}
