package com.example.demo.app.controller;

import com.example.demo.app.form.TodoForm;
import com.example.demo.domain.model.Todo;
import com.example.demo.domain.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("todos")
public class TodoController {

    Logger logger = LoggerFactory.getLogger(getClass().getPackage().getName());

    @Autowired
    private TodoService todoService;

    @ModelAttribute
    TodoForm setUpForm() {
        return new TodoForm();
    }

    @GetMapping
    public String list(Model model) {
        logger.info("Method list is called.");
        List<Todo> todos = todoService.findAll();
        model.addAttribute("todos", todos);
        return "todos/list";
    }

    @GetMapping(value = "/input")
    public String input() {
        return "todos/input";
    }

    @PostMapping(value = "/create")
    String create(@Validated TodoForm form, BindingResult result, Model model , RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "todos/input";
        }
        Todo todo = new Todo();
        todo.setId(form.getId());
        todo.setTitle(form.getTitle());
        todo.setDescription(form.getDescription());

        todoService.register(todo);

        return "redirect:";
    }

    @GetMapping(value = "/show/{id}")
    public String show(@PathVariable Integer id, Model model) {

        model.addAttribute("todo", todoService.getOne(id));
        return "todos/show";
    }

}
