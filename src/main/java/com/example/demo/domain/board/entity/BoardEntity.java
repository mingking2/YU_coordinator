package com.example.demo.domain.board.entity;

import com.example.demo.domain.common.BaseEntity;
import com.example.demo.domain.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "board")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class BoardEntity extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String url;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public void update(String title, String content, String url) {
        this.title = title;
        this.content = content;
        this.url = url;
    }

}
