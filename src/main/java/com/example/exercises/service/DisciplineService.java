package com.example.exercises.service;


import com.example.exercises.dto.DisciplineDto;
import java.util.List;

public interface DisciplineService {
    DisciplineDto addDiscipline(DisciplineDto disciplineDto);
    DisciplineDto getDisciplineById(Long id);
    List<DisciplineDto> getAllDisciplines();
    DisciplineDto updateDiscipline(Long id, DisciplineDto disciplineDto);
    boolean deleteDiscipline(Long id);
}
