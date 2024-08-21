package com.springinaction.part1.chapter2.domain.modelAttribute;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/showInfo")
public class MyWebsiteController {

    @GetMapping("")
    public String showInfo(Model model) {
        System.out.println("showWebsiteInfo method called..");
        WebsiteInfoDTO websiteInfoDTO = new WebsiteInfoDTO();
        websiteInfoDTO.setWebsiteName("Sekiro");
        websiteInfoDTO.setWebsiteCategory("Gaming");

        // add to model
        model.addAttribute("websiteInfo", websiteInfoDTO);
        return "info";
    }

    @ModelAttribute(name = "websiteInfo")
    public WebsiteInfoDTO showInfoWithAnnotation() {
        System.out.println("@ModelAttribute : inside getWebsiteDTO method");

        // setting website information
        WebsiteInfoDTO websiteInfoDTO = new WebsiteInfoDTO();
        websiteInfoDTO.setWebsiteName("Sekiro.com");
        websiteInfoDTO.setWebsiteCategory("gaming");
        System.out.println("************");

        return websiteInfoDTO;
    }
}
