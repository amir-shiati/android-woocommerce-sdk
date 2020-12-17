package com.amirshiati.androidwoocommercesdk.model;

import java.io.Serializable;

public class DefaultAttribute implements Serializable {
    private Long id;
    private String name;
    private String option;

    public DefaultAttribute(Long id, String name, String option) {
        this.id = id;
        this.name = name;
        this.option = option;
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

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
