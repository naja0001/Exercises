package com.example.exercises.service;

import com.example.exercises.dto.ResultDto;

import java.util.List;

public interface ResultService {

    ResultDto addResult(ResultDto resultDto);

    ResultDto getResultById(Long id);

    List<ResultDto> getAllResults();

    ResultDto updateResult(Long id, ResultDto resultDto);

    boolean deleteResult(Long id);
}
