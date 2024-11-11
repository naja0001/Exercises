package com.example.exercises.service.Impl;

import com.example.exercises.dto.ResultDto;
import com.example.exercises.entity.Result;
import com.example.exercises.repository.ResultRepository;
import com.example.exercises.service.ResultService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResultServiceImpl implements ResultService {

    private final ResultRepository resultRepository;

    public ResultServiceImpl(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public ResultDto addResult(ResultDto resultDto) {
        Result result = new Result();  // Map from ResultDto to Result entity here
        // Set properties from resultDto to result
        result.setResultType(resultDto.getResultType());
        result.setDate(resultDto.getDate());
        result.setResultValue(resultDto.getResultValue());

        result = resultRepository.save(result);

        return new ResultDto(result.getId(), result.getResultType(), result.getDate(), result.getResultValue());
    }

    @Override
    public ResultDto getResultById(Long id) {
        Optional<Result> result = resultRepository.findById(id);
        return result.map(r -> new ResultDto(r.getId(), r.getResultType(), r.getDate(), r.getResultValue())).orElse(null);
    }

    @Override
    public List<ResultDto> getAllResults() {
        return resultRepository.findAll().stream()
                .map(r -> new ResultDto(r.getId(), r.getResultType(), r.getDate(), r.getResultValue()))
                .collect(Collectors.toList());
    }

    @Override
    public ResultDto updateResult(Long id, ResultDto resultDto) {
        Optional<Result> resultOptional = resultRepository.findById(id);
        if (resultOptional.isPresent()) {
            Result result = resultOptional.get();
            result.setResultType(resultDto.getResultType());
            result.setDate(resultDto.getDate());
            result.setResultValue(resultDto.getResultValue());
            Result updatedResult = resultRepository.save(result);
            return new ResultDto(updatedResult.getId(), updatedResult.getResultType(), updatedResult.getDate(), updatedResult.getResultValue());
        }
        return null;
    }

    @Override
    public boolean deleteResult(Long id) {
        if (resultRepository.existsById(id)) {
            resultRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
