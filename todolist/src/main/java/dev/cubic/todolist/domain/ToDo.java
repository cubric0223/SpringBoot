package dev.cubic.todolist.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "ToDo")
@Table(name = "todo")
@AllArgsConstructor
<<<<<<< HEAD
@NoArgsConstructor(force = true)
=======
<<<<<<< HEAD
@NoArgsConstructor(force = true)
=======
@NoArgsConstructor
>>>>>>> 671eb93429d94c4e82b3477caea7b44133995424
>>>>>>> 2228d333951df43849bd2342a99dbca952e77062
@Setter
@Getter
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotNull
    private String todo;

}