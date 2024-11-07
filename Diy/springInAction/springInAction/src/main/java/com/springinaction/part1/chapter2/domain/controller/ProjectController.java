package com.springinaction.part1.chapter2.domain.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
    @GetMapping("/info")
    public String info() {
        logger.info("Accessing /info endpoint");
        return "info-page";
    }

}
