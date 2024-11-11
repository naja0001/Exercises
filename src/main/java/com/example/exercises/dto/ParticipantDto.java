package com.example.exercises.dto;

import com.example.exercises.enums.Club;
import com.example.exercises.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.exercises.entity.Discipline;
import com.example.exercises.entity.Result;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ParticipantDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private int age;
    private Club club;
    private Set<Discipline> disciplines;
    private Set<Result> results;

    // Full constructor with all fields
    public ParticipantDto(Long id, String firstName, String lastName, Gender gender, int age, Club club,
                          Set<Discipline> disciplines, Set<Result> results) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.club = club;
        this.disciplines = disciplines;
        this.results = results;
    }
}
