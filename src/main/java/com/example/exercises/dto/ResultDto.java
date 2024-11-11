package com.example.exercises.dto;


import com.example.exercises.entity.Discipline;
import com.example.exercises.entity.Participant;
import com.example.exercises.enums.ResultType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ResultDto {
    private Long id;
    private ResultType resultType;
    private LocalDate date;
    private long resultValue;


    public ResultDto(Long id, ResultType resultType, LocalDate date, long resultValue) {
        this.id = id;
        this.resultType = resultType;
        this.date = date;
        this.resultValue = resultValue;

    }
}
