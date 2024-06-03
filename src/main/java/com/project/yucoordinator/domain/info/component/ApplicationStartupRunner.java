package com.project.yucoordinator.domain.info.component;

import com.project.yucoordinator.domain.info.entity.CSEInfoEntity;
import com.project.yucoordinator.domain.info.entity.YUInfoEntity;
import com.project.yucoordinator.domain.info.service.InfoService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ApplicationStartupRunner {
    private static final String mainUrl = "https://www.yu.ac.kr/main/intro/yu-news.do";
    private static final String cseUrl = "https://cse.yu.ac.kr/cse/community/notice.do";

    private final InfoService infoService;
    
    @PostConstruct
    public void run() throws IOException {
        infoService.saveInfo(mainUrl, 0);
        infoService.saveInfo(cseUrl, 1);

        List<YUInfoEntity> infoEntityList1 = (List<YUInfoEntity>) infoService.findbyAllInfos(0);
        List<CSEInfoEntity> infoEntityList2 = (List<CSEInfoEntity>) infoService.findbyAllInfos(1);

        for (YUInfoEntity info : infoEntityList1) {
            System.out.println("info1.getTitle() = " + info.getTitle());
            System.out.println("info1.getUrl() = " + info.getUrl());
        }

        for (CSEInfoEntity info : infoEntityList2) {
            System.out.println("info2.getTitle() = " + info.getTitle());
            System.out.println("info2.getUrl() = " + info.getUrl());
        }
    }
}
