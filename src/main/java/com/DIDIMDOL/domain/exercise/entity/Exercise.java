package com.DIDIMDOL.domain.exercise.entity;

import com.DIDIMDOL.domain.traingmeta.entity.TrainingMeta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Difficulty difficulty;

    @Column(columnDefinition = "jsonb")
    private String configJson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainingMetaId", nullable = false)
    private TrainingMeta trainingMeta;
}
