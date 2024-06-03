package com.project.yucoordinator.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateReq {
    private Long id;
    private String title;
    private String content;
    private String url;
}
