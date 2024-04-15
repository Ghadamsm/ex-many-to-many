package com.example.ex_mtom.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Address {


    @Id
    private Integer id ;


    @NotEmpty(message = "area should be not empty")
    @Size(min = 4 , max = 25 , message = "area should be between 4 char and 25")
    @Column(columnDefinition = "varchar(25) not null")
    private String area ;


    @NotEmpty(message = "street should be not empty")
    @Size(min = 4 , max = 35 , message = "street should be between 4 char and 35")
    @Column(columnDefinition = "varchar(35) not null")
    private String street ;


    @NotNull(message = "building Number should be not empty")
    @Positive(message = "please enter a positive number")
    @Column(columnDefinition = "int not null")
    private Integer buildingNumber ;



    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher ;


}
