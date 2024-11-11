package com.example.exercises.mapper;

import com.example.exercises.dto.ParticipantDto;
import com.example.exercises.entity.Participant;

public class ParticipantMapper {

    public static ParticipantDto mapToParticipantDto(Participant participant) {
        return new ParticipantDto(
                participant.getId(),
                participant.getFirstName(),
                participant.getLastName(),
                participant.getGender(),
                participant.getAge(),
                participant.getClub(),
                participant.getDisciplines(),
                participant.getResults()
        );
    }

    public static Participant mapToParticipant(ParticipantDto participantDto) {
        return new Participant(
                participantDto.getId(),
                participantDto.getFirstName(),
                participantDto.getLastName(),
                participantDto.getGender(),
                participantDto.getAge(),
                participantDto.getClub(),
                participantDto.getDisciplines(),
                participantDto.getResults()
        );
    }
}
