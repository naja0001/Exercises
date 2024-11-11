package com.example.exercises.controller;

import com.example.exercises.dto.DisciplineDto;
import com.example.exercises.service.DisciplineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplines")
@AllArgsConstructor
public class DisciplineController {

    private final DisciplineService disciplineService;

    @PostMapping
    public ResponseEntity<DisciplineDto> addDiscipline(@RequestBody DisciplineDto disciplineDto) {
        DisciplineDto savedDiscipline = disciplineService.addDiscipline(disciplineDto);
        return new ResponseEntity<>(savedDiscipline, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplineDto> getDisciplineById(@PathVariable Long id) {
        DisciplineDto discipline = disciplineService.getDisciplineById(id);
        return discipline != null
                ? new ResponseEntity<>(discipline, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<DisciplineDto>> getAllDisciplines() {
        List<DisciplineDto> disciplines = disciplineService.getAllDisciplines();
        return new ResponseEntity<>(disciplines, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplineDto> updateDiscipline(@PathVariable Long id, @RequestBody DisciplineDto disciplineDto) {
        DisciplineDto updatedDiscipline = disciplineService.updateDiscipline(id, disciplineDto);
        return updatedDiscipline != null
                ? new ResponseEntity<>(updatedDiscipline, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscipline(@PathVariable Long id) {
        boolean isDeleted = disciplineService.deleteDiscipline(id);
        return isDeleted
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
