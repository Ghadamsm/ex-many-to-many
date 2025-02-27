package com.example.ex_mtom.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Teacher {


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


    @Email
    @NotEmpty(message = "email should be not empty")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email ;


    @NotNull(message = "salary should be not empty")
    @Column(columnDefinition = "int not null")
    private Integer salary ;


    @OneToOne(cascade = CascadeType.ALL , mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address ;



    @OneToMany(cascade = CascadeType.ALL , mappedBy = "teacher")
    private Set<Course> courseSet ;


}
