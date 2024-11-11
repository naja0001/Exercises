package com.example.exercises.entity;


import com.example.exercises.enums.ResultType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Discipline {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "result_type")
    @Enumerated(EnumType.STRING)
    private ResultType resultType;

    @OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL)
    @JsonBackReference (value = "discipline-results")
    private Set<Result> results= new HashSet<>();

    @ManyToMany(mappedBy = "disciplines", cascade = CascadeType.PERSIST)
    @JsonBackReference(value = "discipline-participants")
    private Set<Participant> participants = new HashSet<>();

    public Discipline(String name, ResultType resultType) {
        this.name = name;
        this.resultType = resultType;
    }
}
