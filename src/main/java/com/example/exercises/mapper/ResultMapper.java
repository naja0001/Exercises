package com.example.exercises.mapper;

import com.example.exercises.dto.ParticipantDto;
import com.example.exercises.dto.ResultDto;
import com.example.exercises.entity.Participant;
import com.example.exercises.entity.Result;

public class ResultMapper {

    public static ResultDto mapToParticipantDto(Result result) {
        return new ResultDto(
                result.getId(),
                result.getResultType(),
                result.getDate(),
                result.getResultValue()

        );
    }

    public static Result mapToResult(ResultDto resultDto) {
        return new Result(
                resultDto.getId(),
                resultDto.getResultType(),
                resultDto.getDate(),
                resultDto.getResultValue()

        );
    }

}
