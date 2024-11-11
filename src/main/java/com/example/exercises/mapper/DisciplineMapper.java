package com.example.exercises.mapper;

import com.example.exercises.dto.DisciplineDto;
import com.example.exercises.entity.Discipline;
import java.util.ArrayList;


import java.util.HashSet;

public class DisciplineMapper {

    public static DisciplineDto mapToDisciplineDto(Discipline discipline) {
        return new DisciplineDto(
                discipline.getId(),
                discipline.getName(),
                discipline.getResultType(),
                new HashSet<>(discipline.getResults()), // Convert List to Set
                new HashSet<>(discipline.getParticipants()) // Convert List to Set
        );
    }

    public static Discipline mapToDiscipline(DisciplineDto disciplineDto) {
        return new Discipline(
                disciplineDto.getId(),
                disciplineDto.getName(),
                disciplineDto.getResultType(),
                new HashSet<>(disciplineDto.getResults()), // Convert Set to List
                new HashSet<>(disciplineDto.getParticipants()) // Convert Set to List
        );
    }
}
