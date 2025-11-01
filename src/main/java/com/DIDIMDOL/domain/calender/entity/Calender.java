package com.DIDIMDOL.domain.calender.entity;

import com.DIDIMDOL.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Calender {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private LocalDate date;
    private String content;

    private boolean complete;

    public void updateComplete(){
        this.complete = complete;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
