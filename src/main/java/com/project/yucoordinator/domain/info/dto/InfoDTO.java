package com.project.yucoordinator.domain.info.dto;

import com.project.yucoordinator.domain.info.entity.CSEInfoEntity;
import com.project.yucoordinator.domain.info.entity.YUInfoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InfoDTO {
    private Long id;
    private String title;
    private String url;


    // TODO from, of이걸 찾아봐  convention
    public static InfoDTO YuInfoDTO(YUInfoEntity yuInfoEntity) {
        return InfoDTO.builder()
                .id(yuInfoEntity.getId())
                .title(yuInfoEntity.getTitle())
                .url(yuInfoEntity.getUrl())
                .build();
    }

    public static InfoDTO CseInfoDTO(CSEInfoEntity cseInfoEntity) {
        return InfoDTO.builder()
                .id(cseInfoEntity.getId())
                .title(cseInfoEntity.getTitle())
                .url(cseInfoEntity.getUrl())
                .build();
    }
}
