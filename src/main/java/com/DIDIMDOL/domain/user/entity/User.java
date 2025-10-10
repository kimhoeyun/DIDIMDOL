package com.DIDIMDOL.domain.user.entity;

import com.DIDIMDOL.domain.progress.entity.Progress;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private long userId;

    @Column
    private String password;

    @Column
    private Status status;

    @OneToMany(mappedBy = "user")
    private List<Progress> progresses = new ArrayList<>();
}
