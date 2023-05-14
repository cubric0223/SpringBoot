package dev.cubic.todolist.repository;

import dev.cubic.todolist.domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository  extends JpaRepository<ToDo, Long> {
}
