package com.example.exercises.controller;

import com.example.exercises.dto.ParticipantDto;
import com.example.exercises.service.ParticipantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/participants")
public class ParticipantController {

    private final ParticipantService participantService;

    @PostMapping
    public ResponseEntity<ParticipantDto> addParticipant(@RequestBody ParticipantDto participantDto) {
        ParticipantDto savedParticipant = participantService.addParticipant(participantDto);
        return new ResponseEntity<>(savedParticipant, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ParticipantDto>> getAllParticipants() {
        List<ParticipantDto> participants = participantService.getAllParticipants();
        return new ResponseEntity<>(participants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipantDto> getParticipantById(@PathVariable Long id) {
        Optional<ParticipantDto> participantDto = participantService.getParticipantById(id);
        return participantDto
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipantDto> updateParticipant(@PathVariable Long id, @RequestBody ParticipantDto updatedParticipantDto) {
        try {
            ParticipantDto updatedParticipant = participantService.updateParticipant(id, updatedParticipantDto);
            return new ResponseEntity<>(updatedParticipant, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticipant(@PathVariable Long id) {
        try {
            participantService.deleteParticipant(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
