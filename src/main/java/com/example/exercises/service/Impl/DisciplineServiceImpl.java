package com.example.exercises.service.Impl;

import com.example.exercises.dto.DisciplineDto;
import com.example.exercises.entity.Discipline;
import com.example.exercises.repository.DisciplineRepository;
import com.example.exercises.service.DisciplineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplineServiceImpl implements DisciplineService {

    private final DisciplineRepository disciplineRepository;

    public DisciplineServiceImpl(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    @Override
    public DisciplineDto addDiscipline(DisciplineDto disciplineDto) {
        Discipline discipline = new Discipline();
        discipline.setName(disciplineDto.getName());
        discipline.setResultType(disciplineDto.getResultType());
        discipline.setResults(disciplineDto.getResults());
        discipline.setParticipants(disciplineDto.getParticipants());

        Discipline savedDiscipline = disciplineRepository.save(discipline);
        return new DisciplineDto(savedDiscipline.getId(), savedDiscipline.getName(), savedDiscipline.getResultType(), savedDiscipline.getResults(), savedDiscipline.getParticipants());
    }

    @Override
    public DisciplineDto getDisciplineById(Long id) {
        Optional<Discipline> discipline = disciplineRepository.findById(id);
        return discipline.map(d -> new DisciplineDto(d.getId(), d.getName(), d.getResultType(), d.getResults(), d.getParticipants())).orElse(null);
    }

    @Override
    public List<DisciplineDto> getAllDisciplines() {
        return disciplineRepository.findAll().stream()
                .distinct()
                .map(d -> new DisciplineDto(d.getId(), d.getName(), d.getResultType(), d.getResults(), d.getParticipants()))
                .collect(Collectors.toList());
    }


        @Override
        public DisciplineDto updateDiscipline (Long id, DisciplineDto disciplineDto){
        Optional<Discipline> disciplineOptional = disciplineRepository.findById(id);
        if (disciplineOptional.isPresent()) {
            Discipline discipline = disciplineOptional.get();
            discipline.setName(disciplineDto.getName());
            discipline.setResultType(disciplineDto.getResultType());
            discipline.setResults(disciplineDto.getResults());
            discipline.setParticipants(disciplineDto.getParticipants());

            Discipline updatedDiscipline = disciplineRepository.save(discipline);
            return new DisciplineDto(updatedDiscipline.getId(), updatedDiscipline.getName(), updatedDiscipline.getResultType(), updatedDiscipline.getResults(), updatedDiscipline.getParticipants());
        }
        return null;
    }

    @Override
    public boolean deleteDiscipline(Long id) {
        if (disciplineRepository.existsById(id)) {
            disciplineRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
