package com.amirshiati.androidwoocommercesdk.model;

import java.io.Serializable;

public class ProductDownloadProperties implements Serializable {

    private String id;
    private String name;
    private String fileUrl;

    public ProductDownloadProperties(String id, String name, String fileUrl) {
        this.id = id;
        this.name = name;
        this.fileUrl = fileUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
