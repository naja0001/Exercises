package com.example.exercises.controller;

import com.example.exercises.dto.ResultDto;
import com.example.exercises.service.ResultService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
@AllArgsConstructor
public class ResultController {

    private final ResultService resultService;

    // Endpoint to create a new result
    @PostMapping
    public ResponseEntity<ResultDto> addResult(@RequestBody ResultDto resultDto) {
        ResultDto savedResult = resultService.addResult(resultDto);
        return new ResponseEntity<>(savedResult, HttpStatus.CREATED);
    }

    // Endpoint to get a result by ID
    @GetMapping("/{id}")
    public ResponseEntity<ResultDto> getResultById(@PathVariable Long id) {
        ResultDto result = resultService.getResultById(id);
        return result != null
                ? new ResponseEntity<>(result, HttpStatus.OK) // 200 OK
                : new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
    }

    // Endpoint to get all results
    @GetMapping
    public ResponseEntity<List<ResultDto>> getAllResults() {
        List<ResultDto> results = resultService.getAllResults();
        return new ResponseEntity<>(results, HttpStatus.OK); // 200 OK
    }

    // Endpoint to update an existing result
    @PutMapping("/{id}")
    public ResponseEntity<ResultDto> updateResult(@PathVariable Long id, @RequestBody ResultDto resultDto) {
        ResultDto updatedResult = resultService.updateResult(id, resultDto);
        return updatedResult != null
                ? new ResponseEntity<>(updatedResult, HttpStatus.OK) // 200 OK
                : new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
    }

    // Endpoint to delete a result by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResult(@PathVariable Long id) {
        boolean isDeleted = resultService.deleteResult(id);
        return isDeleted
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT) // 204 No Content
                : new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
    }
}
