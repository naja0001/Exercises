package com.example.exercises.entity;

import com.example.exercises.enums.ResultType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "result_type")
    @Enumerated(EnumType.STRING)
    private ResultType resultType;

    private LocalDate date;

    @Column(name = "result_value")
    private long resultValue;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    @JsonBackReference(value="disciplines-results")
    private Discipline discipline;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    @JsonBackReference("participant-results")
    private Participant participant;


    public Result(LocalDate date, int resultValue, ResultType resultType, Discipline discipline, Participant participant) {
        this.date = date;
        this.resultValue = resultValue;
        this.resultType = resultType;
        this.discipline = discipline;
        this.participant = participant;
    }


    public Result(Long id, ResultType resultType, LocalDate date, long resultValue) {
        this.id = id;
        this.resultType = resultType;
        this.date = date;
        this.resultValue = resultValue;
    }
}