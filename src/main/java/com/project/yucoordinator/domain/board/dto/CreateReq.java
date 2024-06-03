package com.project.yucoordinator.domain.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReq {
    private String title;
    private String content;
    private String url;
    private Long memberId;
}
