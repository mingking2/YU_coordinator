package com.project.yucoordinator.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UpdateReq {
    private Long id;
    private String title;
    private String content;
    private String url;

    public static UpdateReq makeUpdateReq(BoardDTO boardDTO) {
        return UpdateReq.builder()
                .id(boardDTO.getId())
                .title(boardDTO.getTitle())
                .url(boardDTO.getUrl())
                .content(boardDTO.getContent())
                .build();
    }
}
