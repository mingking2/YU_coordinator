package com.project.yucoordinator.domain.info.service;

import com.project.yucoordinator.domain.info.dto.InfoDTO;
import com.project.yucoordinator.domain.info.entity.CSEInfoEntity;
import com.project.yucoordinator.domain.info.entity.YUInfoEntity;
import com.project.yucoordinator.domain.info.repository.CSEInfoRepository;
import com.project.yucoordinator.domain.info.repository.YUInfoRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InfoService {
    private final YUInfoRepository yuInfoRepository;
    private final CSEInfoRepository cseInfoRepository;

    public void saveInfo(String givenUrl, int flag) throws IOException {
        Document doc = Jsoup.connect(givenUrl).get();
        Elements infoElements = doc.select("table.board-table");

        for (Element element: infoElements) {
            Elements links = element.select("div.b-title-box");
            for (Element link : links) {
                String titleAll = link.select("a").attr("title");
                String url = link.select("a").attr("href");
                if(!url.startsWith("http"))
                    url = givenUrl + url;

                String substring = titleAll.substring(0, titleAll.length()-6);
                selectRepo(substring, url, flag);
            }
        }
    }

    public void selectRepo(String title, String url, int flag) {
        if (flag == 0) {
            YUInfoEntity info = YUInfoEntity.builder()
                    .title(title)
                    .url(url)
                    .build();
            if(yuInfoRepository.findByTitle(info.getTitle()).isEmpty())
                yuInfoRepository.save(info);
        } else if (flag == 1) {
            CSEInfoEntity info = CSEInfoEntity.builder()
                    .title(title)
                    .url(url)
                    .build();
            if(cseInfoRepository.findByTitle(info.getTitle()).isEmpty())
                cseInfoRepository.save(info);
        }
    }

    public List<InfoDTO> findAllInfos(int flag) {
        List<InfoDTO> infoDTOS = new ArrayList<>();
        if (flag == 0) {
            List<YUInfoEntity> yuInfoList = yuInfoRepository.findAll();
            for(YUInfoEntity yuInfo : yuInfoList) {
                infoDTOS.add(InfoDTO.YuInfoDTO(yuInfo));
            }
        } else {
            List<CSEInfoEntity> cseInfoList = cseInfoRepository.findAll();
            for(CSEInfoEntity cseInfo : cseInfoList) {
                infoDTOS.add(InfoDTO.CseInfoDTO(cseInfo));
            }
        }
        return infoDTOS;
    }

    public void deleteAllInfo() {
        yuInfoRepository.deleteAll();
        yuInfoRepository.resetAutoIncrement();

        cseInfoRepository.deleteAll();
        cseInfoRepository.resetAutoIncrement();
    }

}
