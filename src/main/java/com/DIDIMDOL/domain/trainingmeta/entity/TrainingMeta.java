package com.DIDIMDOL.domain.trainingmeta.entity;

import com.DIDIMDOL.domain.exercise.entity.Exercise;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingMeta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TrainingType trainingType;

    private String typeDescription;

    @OneToMany(mappedBy = "trainingMeta")
    private List<Exercise> exercises = new ArrayList<>();
}