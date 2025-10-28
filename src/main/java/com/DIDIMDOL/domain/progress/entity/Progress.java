package com.DIDIMDOL.domain.progress.entity;

import com.DIDIMDOL.domain.trainingmeta.entity.TrainingType;
import com.DIDIMDOL.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"userId", "trainingType"})
)
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter

public class Progress {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int attemptCnt;

    private Integer bestScore;
    private Integer lastScore;
    private Integer avgScore;

    @Enumerated(EnumType.STRING)
    private TrainingType trainingType;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    public void updateScores(int newScore) {
        int totalCnt = this.attemptCnt + 1;
        int currentAvg = (this.avgScore == null ? 0 : this.avgScore);
        int newAvg = (currentAvg * this.attemptCnt + newScore) / totalCnt;

        this.attemptCnt = totalCnt;
        this.lastScore = newScore;
        this.bestScore = Math.max(this.bestScore == null ? 0 : this.bestScore, newScore);
        this.avgScore = newAvg;
    }
}
