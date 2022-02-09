package com.example.demo.domain.service;

import com.example.demo.domain.model.Todo;
import com.example.demo.domain.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public List<Todo> findAll() {
        //TODO: dummy実装です。
        /*
        List<Todo> todos = new ArrayList<>();
        var todo1 = new Todo();
        todo1.setId(1);
        todo1.setTitle("Todo1");
        todo1.setDescription("Desc1");
        todos.add(todo1);
        var todo2 = new Todo();
        todo2.setId(2);
        todo2.setTitle("Todo2");
        todo2.setDescription("Desc2");
        todos.add(todo2);
        return todos;
        */
        return todoRepository.findAll();
    }

    public void register(Todo todo) {
        todoRepository.save(todo);
    }

    public Todo getOne(Integer id) {
        return todoRepository.getOne(id);
    }
}
