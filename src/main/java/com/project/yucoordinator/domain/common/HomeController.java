package com.project.yucoordinator.domain.common;

import com.project.yucoordinator.domain.info.entity.CSEInfoEntity;
import com.project.yucoordinator.domain.info.entity.YUInfoEntity;
import com.project.yucoordinator.domain.info.service.InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final InfoService infoService;
    @GetMapping("/")
    public String home(Model model) {
        List<YUInfoEntity> allYUInfoEntity = (List<YUInfoEntity>) infoService.findAllInfos(0);
        List<CSEInfoEntity> allCSEInfoEntity = (List<CSEInfoEntity>) infoService.findAllInfos(1);
        model.addAttribute("infoList", allYUInfoEntity);
        model.addAttribute("CSEinfoList", allCSEInfoEntity);
        return "home";
    }
}
