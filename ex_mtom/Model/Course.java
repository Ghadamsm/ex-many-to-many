package com.example.ex_mtom.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Course {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;


    @NotEmpty(message = "name should be not empty")
    @Size(min = 3, max = 40 , message = "name should be between 3 char and 40")
    @Column(columnDefinition = "varchar(40) not null unique")
    private String name ;



    @ManyToOne
    @JsonIgnore
    private Teacher teacher;



    @ManyToMany
    private List<Student> student;

}
