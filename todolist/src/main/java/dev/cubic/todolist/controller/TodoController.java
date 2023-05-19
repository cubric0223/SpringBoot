package dev.cubic.todolist.controller;

import dev.cubic.todolist.domain.ToDo;
import dev.cubic.todolist.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final ToDoRepository toDoRepository;

    @GetMapping("/")
    public String index(Model model){
        List<ToDo> todos = toDoRepository.findAll();
        model.addAttribute("todos", todos);
        return "todos";
    }

    @PostMapping("/addTodo")
    public String addTodo(@RequestParam("todo") String todo){
        //db에 저장하면 된다.
        ToDo toDo = new ToDo();
        toDo.setTodo(todo);
        toDoRepository.save(toDo);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id){
        toDoRepository.deleteById(id);
        return "redirect:/";
    }
}
