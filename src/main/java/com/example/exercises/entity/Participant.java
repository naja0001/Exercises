// Package declaration: This defines the package in which the class resides
package com.example.exercises.entity;

// Import statements for the necessary JPA and Lombok annotations
import com.example.exercises.enums.Club;
import com.example.exercises.enums.Gender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Lombok annotations to automatically generate getters and setters for all fields
@Getter // Lombok annotation that generates getter methods for all fields
@Setter // Lombok annotation that generates setter methods for all fields
@NoArgsConstructor // Lombok annotation that generates a no-argument constructor
@AllArgsConstructor // Lombok annotation that generates a constructor with all arguments

// Specifies that this class is a JPA entity and maps to a database table
@Entity
@Table(name = "participant") // Specifies the table name in the database

public class Participant {

    // Primary key for the entity, with auto-generated value
    @Id // Marks this field as the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies auto-increment behavior for the primary key
    private Long id; // Unique identifier for each participant

    // Column mapping for the first name, with a custom column name
    @Column(name="first_name") // Maps this field to the "first_name" column in the database table
    private String firstName; // Stores the participant's first name

    // Column mapping for the last name, with a custom column name
    @Column(name="last_name") // Maps this field to the "last_name" column in the database table
    private String lastName; // Stores the participant's last name

    // No @Column annotation is needed when the field name matches the database column name
    @Enumerated(EnumType.STRING)
    private Gender gender; // Stores the participant's gender

    // Integer field for storing the participant's age
    private int age; // Stores the participant's age

    // String field for the club name the participant is associated with
    @Enumerated(EnumType.STRING)
    private Club club; // Stores the name of the participant's club

    @ManyToMany
    @JoinTable(
            name = "participant_discipline",
            joinColumns = @JoinColumn(name = "participant_id"),
            inverseJoinColumns = @JoinColumn(name = "discipline_id")
    )
    private Set<Discipline> disciplines = new HashSet<>();

    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL)
    @JsonManagedReference("participant-results")
    private Set<Result> results = new HashSet<>();

    public Participant(String firstName, String lastName, Gender gender, int age, Club club, List<Discipline> disciplines, List<Result> results) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.club = club;
        this.disciplines = new HashSet<>();
        this.results = new HashSet<>();
    }

    public Participant(String firstName, String lastName, Gender gender, int age, Club club) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.club = club;
    }
}
