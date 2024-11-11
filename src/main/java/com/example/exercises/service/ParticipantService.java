package com.example.exercises.service;

import com.example.exercises.dto.ParticipantDto;

import java.util.List;
import java.util.Optional;

public interface ParticipantService {

    ParticipantDto addParticipant(ParticipantDto participantDto);

    List<ParticipantDto> getAllParticipants();

    Optional<ParticipantDto> getParticipantById(Long id);

    ParticipantDto updateParticipant(Long id, ParticipantDto participantDto);

    void deleteParticipant(Long id);

}
