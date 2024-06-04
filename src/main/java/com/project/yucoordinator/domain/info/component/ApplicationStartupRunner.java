package com.project.yucoordinator.domain.info.component;

import com.project.yucoordinator.domain.info.service.InfoService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ApplicationStartupRunner {
    private static final String mainUrl = "https://www.yu.ac.kr/main/intro/yu-news.do";
    private static final String cseUrl = "https://cse.yu.ac.kr/cse/community/notice.do";

    private final InfoService infoService;
    
    @PostConstruct
    @Scheduled(cron = "0 0 0/12 * * *")
    public void run() throws IOException {
        infoService.deleteAllInfo();

        infoService.saveInfo(mainUrl, 0);
        infoService.saveInfo(cseUrl, 1);

    }

}
