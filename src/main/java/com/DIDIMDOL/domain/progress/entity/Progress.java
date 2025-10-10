package com.DIDIMDOL.domain.progress.entity;

import com.DIDIMDOL.domain.trainingmeta.entity.TrainingType;
import com.DIDIMDOL.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class Progress {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int attempCnt;

    private Integer bestScore;
    private Integer lastScore;
    private Integer avgScore;

    @Enumerated(EnumType.STRING)
    private TrainingType trainingType;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

}
