package com.DIDIMDOL.domain.traingmeta.entity;


import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class TrainingMeta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String outline;

    @Enumerated(EnumType.STRING)
    TrainingType trainingType;

    @Column
    DifficultyPolicy difficultyPolicy;


}
