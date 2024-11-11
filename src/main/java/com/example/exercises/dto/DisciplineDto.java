package com.example.exercises.dto;

import com.example.exercises.entity.Participant;
import com.example.exercises.entity.Result;
import com.example.exercises.enums.ResultType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class DisciplineDto {
    private Long id;
    private String name;
    private ResultType resultType;
    private Set<Result> results;
    private Set<Participant> participants;

    public DisciplineDto(Long id, String name, ResultType resultType, Set<Result> results, Set<Participant> participants) {
        this.id = id;
        this.name = name;
        this.resultType = resultType;
        this.results = results;
        this.participants = participants;
    }
}
