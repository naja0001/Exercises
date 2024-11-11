package com.example.exercises.service.Impl;

import com.example.exercises.dto.ParticipantDto;
import com.example.exercises.entity.Participant;
import com.example.exercises.mapper.ParticipantMapper;
import com.example.exercises.repository.ParticipantRepository;
import com.example.exercises.service.ParticipantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository;

    @Override
    public ParticipantDto addParticipant(ParticipantDto participantDto) {
        Participant participant = ParticipantMapper.mapToParticipant(participantDto);
        Participant savedParticipant = participantRepository.save(participant);
        return ParticipantMapper.mapToParticipantDto(savedParticipant);
    }


    @Override
    public List<ParticipantDto> getAllParticipants() {
        List<Participant> participants = participantRepository.findAll();
        return participants.stream()
                .map(ParticipantMapper::mapToParticipantDto)
                .collect(Collectors.toList());
    }

    public Optional<ParticipantDto> getParticipantById(Long id) {
        return participantRepository.findById(id)
                .map(participant -> {
                    ParticipantDto participantDto = ParticipantMapper.mapToParticipantDto(participant);

                    // Only include results if there are disciplines
                    if (participant.getDisciplines().isEmpty()) {
                        participantDto.setResults(null); // or clear results with an empty list if preferred
                    }

                    return participantDto;
                });
    }

    @Override
    public ParticipantDto updateParticipant(Long id, ParticipantDto updatedParticipantDto) {
        Participant participant = participantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Participant not found"));

        participant.setFirstName(updatedParticipantDto.getFirstName());
        participant.setLastName(updatedParticipantDto.getLastName());
        participant.setGender(updatedParticipantDto.getGender());
        participant.setAge(updatedParticipantDto.getAge());
        participant.setClub(updatedParticipantDto.getClub());


        Participant updatedParticipant = participantRepository.save(participant);
        return ParticipantMapper.mapToParticipantDto(updatedParticipant);
    }

    @Override
    public void deleteParticipant(Long id) {
        participantRepository.deleteById(id);
    }
}
