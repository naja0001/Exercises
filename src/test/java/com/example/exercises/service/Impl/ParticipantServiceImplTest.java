package com.example.exercises.service.Impl;

import com.example.exercises.dto.ParticipantDto;
import com.example.exercises.entity.Participant;
import com.example.exercises.enums.Club;
import com.example.exercises.enums.Gender;
import com.example.exercises.mapper.ParticipantMapper;
import com.example.exercises.repository.ParticipantRepository;
import com.example.exercises.service.ParticipantService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
/*
@ExtendWith(MockitoExtension.class)
class ParticipantServiceImplTest {

    @Mock private ParticipantRepository participantRepository;
    private ParticipantService underTest;

    @BeforeEach
    void setUp() {
        underTest = new ParticipantServiceImpl(participantRepository);
    }


    @Test
    void canGetAllParticipants() {
        // Arrange: No setup needed for this simple test case

        // Act: Call the method to retrieve all participants
        underTest.getAllParticipants();

        // Assert: Verify that findAll() was called on the repository
        verify(participantRepository).findAll();

    }


    @Disabled @Test
    void canUpdateParticipant() {

        // Arrange:

        // Act:

        // Assert:

    }


    @Disabled @Test
    void canDeleteParticipant() {

        // Arrange:

        // Act:

        // Assert:

    }
}*/