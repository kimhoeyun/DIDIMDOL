package com.DIDIMDOL.domain.progress.entity;


import com.DIDIMDOL.domain.exercise.entity.Exercise;
import com.DIDIMDOL.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Progress {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "User_userid")
    private User userid;

    @Column
    Exercise exercise;

    @Column
    private int attempCount;

    @Column
    private Integer bestSocre;

    @Column
    private Integer lastScore;

    @Column
    private Integer avgScore;

}
