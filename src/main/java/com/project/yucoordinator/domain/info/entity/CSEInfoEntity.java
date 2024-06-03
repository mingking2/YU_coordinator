package com.project.yucoordinator.domain.info.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "CSE_Info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CSEInfoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String url;
}
