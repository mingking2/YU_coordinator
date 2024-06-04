package com.project.yucoordinator.domain.board.dto;

import com.project.yucoordinator.domain.board.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDTO {
    private Long id;
    private Long displayId;
    private String title;
    private String url;
    private String content;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;


    public static BoardDTO makeBoardDTO(BoardEntity boardEntity) {
        return BoardDTO.builder()
                .id(boardEntity.getId())
                .title(boardEntity.getTitle())
                .url(boardEntity.getUrl())
                .content(boardEntity.getContent())
                .createdTime(boardEntity.getCreatedTime())
                .updatedTime(boardEntity.getUpdatedTime())
                .build();
    }

    public void setDisplayId(int i) {
        displayId = (long) i;
    }

}
