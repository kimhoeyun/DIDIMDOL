package com.DIDIMDOL.domain.exercise.entity;


import com.DIDIMDOL.domain.traingmeta.entity.TrainingMeta;
import com.DIDIMDOL.domain.traingmeta.entity.TrainingType;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Exercise {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    TrainingType trainingType;

    @Enumerated(EnumType.STRING)
    TrainingMeta trainingMeta;

    @Column
    private String title;

    @Column
    private Integer difficulty;

    @Column
    JsonNode content;

    @Column
    JsonNode solution;


}
