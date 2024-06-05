package com.project.yucoordinator.domain.info.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "YU_Info")
public class YUInfoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String url;


    public static YUInfoEntity create(String title, String url) {
        return new YUInfoEntity(title, url);
    }


    @Builder
    private YUInfoEntity(String title, String url) {
        // TODO Validation하기

        this.title = title;
        this.url = url;
    }
}
