package com.example.exercises.config;

import com.example.exercises.entity.Discipline;
import com.example.exercises.entity.Participant;
import com.example.exercises.entity.Result;
import com.example.exercises.enums.Club;
import com.example.exercises.enums.Gender;
import com.example.exercises.enums.ResultType;
import com.example.exercises.repository.DisciplineRepository;
import com.example.exercises.repository.ParticipantRepository;
import com.example.exercises.repository.ResultRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitData implements ApplicationRunner {

    private final DisciplineRepository disciplineRepository;
    private final ResultRepository resultRepository;
    private final ParticipantRepository participantRepository;

    private List<Discipline> disciplines = new ArrayList<>();
    private List<Participant> participants = new ArrayList<>();

    public InitData(DisciplineRepository disciplineRepository, ResultRepository resultRepository, ParticipantRepository participantRepository) {
        this.disciplineRepository = disciplineRepository;
        this.resultRepository = resultRepository;
        this.participantRepository = participantRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("Creating initial data:");
        createInitialData();
        System.out.println("Initial data loaded successfully.");
    }

    private void createInitialData() {
        createDisciplines();
        createParticipants();
        createParticipantsDisciplines();
        createParticipantsResults();
    }

    private void createParticipantsResults() {
        List<Result> results = List.of(
                new Result(LocalDate.now(), 10563, ResultType.MILLISECONDS, disciplines.get(0), participants.get(0)), // Ali - High Jump
                new Result(LocalDate.now(), 1032, ResultType.MILLISECONDS, disciplines.get(0), participants.get(0)), // Ali - High Jump
                new Result(LocalDate.now(), 1022, ResultType.MILLISECONDS, disciplines.get(0), participants.get(0)), // Ali - High Jump
                new Result(LocalDate.now(), 103422, ResultType.MILLISECONDS, disciplines.get(0), participants.get(0)), // Ali - High Jump
                new Result(LocalDate.now(), 20534, ResultType.MILLISECONDS, disciplines.get(1), participants.get(2)), // John - Marathon
                new Result(LocalDate.now(), 304234, ResultType.MILLISECONDS, disciplines.get(1), participants.get(2)), // John - Marathon
                new Result(LocalDate.now(), 4234423, ResultType.MILLISECONDS, disciplines.get(1), participants.get(2)), // John - Marathon
                new Result(LocalDate.now(), 432432, ResultType.MILLISECONDS, disciplines.get(1), participants.get(2)), // John - Marathon
                new Result(LocalDate.now(), 4433234, ResultType.MILLISECONDS, disciplines.get(2), participants.get(3)), // Sama - Shot Put
                new Result(LocalDate.now(), 3432323, ResultType.MILLISECONDS, disciplines.get(2), participants.get(3)), // Sama - Shot Put
                new Result(LocalDate.now(), 2334, ResultType.CENTIMETER, disciplines.get(3), participants.get(0)), // Ali - Archery
                new Result(LocalDate.now(), 34343, ResultType.CENTIMETER, disciplines.get(3), participants.get(0)), // Ali - Archery
                new Result(LocalDate.now(), 32243, ResultType.CENTIMETER, disciplines.get(3), participants.get(0)), // Ali - Archery
                new Result(LocalDate.now(), 12334, ResultType.CENTIMETER, disciplines.get(3), participants.get(1)), // Berfin - Archery
                new Result(LocalDate.now(), 13256, ResultType.CENTIMETER, disciplines.get(3), participants.get(1)), // Berfin - Archery
                new Result(LocalDate.now(), 232, ResultType.CENTIMETER, disciplines.get(3), participants.get(3)), // Sama - Archery
                new Result(LocalDate.now(), 126, ResultType.CENTIMETER, disciplines.get(3), participants.get(3)), // Sama - Archery
                new Result(LocalDate.now(), 150, ResultType.CENTIMETER, disciplines.get(4), participants.get(9)), // Laura - 200m Dash
                new Result(LocalDate.now(), 170, ResultType.CENTIMETER, disciplines.get(4), participants.get(9)), // Laura - 200m Dash
                new Result(LocalDate.now(), 230, ResultType.CENTIMETER, disciplines.get(4), participants.get(10)) // David - 200m Dash
               );

        resultRepository.saveAll(results); // Save all results to the repository
    }


    private void createDisciplines() {
        disciplines = List.of(
                new Discipline("High Jump", ResultType.CENTIMETER),
                new Discipline("Marathon", ResultType.MILLISECONDS),
                new Discipline("Shot Put", ResultType.MILLIMETER),
                new Discipline("Archery", ResultType.POINTS),
                new Discipline("200m Dash", ResultType.MILLISECONDS)
        );

        // Save all disciplines to the repository
        disciplineRepository.saveAll(disciplines);
    }

    private void createParticipants() {
        participants = List.of(
                new Participant("John", "Doe", Gender.MALE, 28, Club.RUNNING_CLUB),
                new Participant("Berfin", "Turan", Gender.FEMALE, 25, Club.SWIMMING_CLUB),
                new Participant("John", "Doe", Gender.MALE, 31, Club.CYCLING_CLUB),
                new Participant("Salma", "Smith", Gender.FEMALE, 23, Club.RUNNING_CLUB),
                new Participant("Michael", "Johnson", Gender.MALE, 34, Club.SWIMMING_CLUB),
                new Participant("Emily", "Davis", Gender.FEMALE, 27, Club.CYCLING_CLUB),
                new Participant("Chris", "Brown", Gender.OTHER, 29, Club.SWIMMING_CLUB),
                new Participant("Sophia", "Martinez", Gender.FEMALE, 22, Club.SWIMMING_CLUB),
                new Participant("Daniel", "Wilson", Gender.MALE, 30, Club.RUNNING_CLUB),
                new Participant("Laura", "Taylor", Gender.FEMALE, 26, Club.SWIMMING_CLUB),
                new Participant("David", "Moore", Gender.OTHER, 33, Club.RUNNING_CLUB),
                new Participant("Amy", "Thomas", Gender.FEMALE, 24, Club.RUNNING_CLUB)
        );

        participantRepository.saveAll(participants);
    }

    private void createParticipantsDisciplines() {
                participants.get(3).getDisciplines().add(disciplines.get(1));
                participants.get(3).getDisciplines().add(disciplines.get(2));
                participants.get(4).getDisciplines().add(disciplines.get(2));
                participants.get(4).getDisciplines().add(disciplines.get(3));
                participants.get(5).getDisciplines().add(disciplines.get(2));
                participants.get(5).getDisciplines().add(disciplines.get(3));
                participants.get(6).getDisciplines().add(disciplines.get(2));
                participants.get(7).getDisciplines().add(disciplines.get(3));
                participants.get(8).getDisciplines().add(disciplines.get(3));
                participants.get(9).getDisciplines().add(disciplines.get(1));
                participants.get(10).getDisciplines().add(disciplines.get(1));
                participants.get(11).getDisciplines().add(disciplines.get(1));

                // Save participants with updated disciplines
                participantRepository.saveAll(participants);
    }
}
