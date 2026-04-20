package com.vcms.cms.dto;

public class NewsRequestDto {
    private String title;
    private String description;
    private String filename;
    private Boolean status;

    public NewsRequestDto() {
    }

    public NewsRequestDto(String title, String description, String filename, Boolean status) {
        this.title = title;
        this.description = description;
        this.filename = filename;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
