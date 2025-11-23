package com.DIDIMDOL.domain.exercise.entity;

import com.DIDIMDOL.domain.trainingmeta.entity.TrainingMeta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Column(columnDefinition = "jsonb")
    private String configJson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainingMetaId", nullable = false)
    private TrainingMeta trainingMeta;

    public Exercise(String title, Difficulty difficulty, String configJson, TrainingMeta trainingMeta) {
        this.title = title;
        this.difficulty = difficulty;
        this.configJson = configJson;
        this.trainingMeta = trainingMeta;
    }

    public void changeDifficulty(Difficulty newDifficulty) {
        this.difficulty = newDifficulty;
    }
}
