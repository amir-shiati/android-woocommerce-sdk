package com.amirshiati.androidwoocommercesdk.model;

import java.io.Serializable;

public class ProductDownloadProperties implements Serializable {

    private Long id;
    private String name;
    private String fileUrl;

    public ProductDownloadProperties(Long id, String name, String fileUrl) {
        this.id = id;
        this.name = name;
        this.fileUrl = fileUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
