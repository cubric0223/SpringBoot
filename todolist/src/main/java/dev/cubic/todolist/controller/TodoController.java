package dev.cubic.todolist.controller;

import dev.cubic.todolist.domain.ToDo;
import dev.cubic.todolist.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
>>>>>>> 671eb93429d94c4e82b3477caea7b44133995424
>>>>>>> 2228d333951df43849bd2342a99dbca952e77062

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

    //todolist 항목 추가
    @PostMapping("/addTodo")
    public String addTodo(@RequestParam("todo") String todo){
        //db에 저장하면 된다.
        ToDo toDo = new ToDo();
        toDo.setTodo(todo);
        toDoRepository.save(toDo);
        return "redirect:/";
    }
<<<<<<< HEAD

    //todolist 항목 삭제
    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id){  // @PathVariable를 이용해서 id를 받아옴
        toDoRepository.deleteById(id); // 받아온 id로 해당 항목 삭제
        return "redirect:/"; //초기화면으로 이동
    }
=======
<<<<<<< HEAD

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id){
        toDoRepository.deleteById(id);
        return "redirect:/";
    }
=======
>>>>>>> 671eb93429d94c4e82b3477caea7b44133995424
>>>>>>> 2228d333951df43849bd2342a99dbca952e77062
}
