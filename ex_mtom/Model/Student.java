package com.example.ex_mtom.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;


    @NotEmpty(message = "name should be not empty")
    @Size(min = 3, max = 15 , message = "name should be between 3 char and 15")
    @Column(columnDefinition = "varchar(15) not null")
    private String name ;


    @NotNull(message = "age should be not empty")
    @Positive(message = "please enter a positive number")
    @Column(columnDefinition = "int not null")
    private Integer age ;


    @NotEmpty(message = "major should be not empty")
    @Column(columnDefinition = "varchar(35) not null")
    private String major ;




    @ManyToMany(mappedBy = "student")
    @JsonIgnore
    private List<Course> courses;

}
