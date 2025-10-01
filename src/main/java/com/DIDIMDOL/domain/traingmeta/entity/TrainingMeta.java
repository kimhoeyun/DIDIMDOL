package com.DIDIMDOL.domain.traingmeta.entity;

import com.DIDIMDOL.domain.exercise.entity.Exercise;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TrainingMeta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TrainingType trainingType;
    private String typeDescription;

    @OneToMany(mappedBy = "trainingMeta")
    private List<Exercise> exercises = new ArrayList<>();
}