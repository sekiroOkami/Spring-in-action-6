package com.springinaction.part1.chapter2.domain.modelAttribute;


public class WebsiteInfoDTO {
    private String websiteName;
    private String websiteCategory;

    public WebsiteInfoDTO() {
        System.out.println("WebsiteInfoDTO constructor called!");
    }

    //getters and setters
    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getWebsiteCategory() {
        return websiteCategory;
    }

    public void setWebsiteCategory(String websiteCategory) {
        this.websiteCategory = websiteCategory;
    }
}
