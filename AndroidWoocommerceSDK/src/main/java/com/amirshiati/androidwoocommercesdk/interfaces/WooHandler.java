package com.amirshiati.androidwoocommercesdk.interfaces;

public interface WooHandler {

    void get(long id, OnResponse onResponse);

    void getList(ParamBuilder builder, OnResponse onResponse);

    void delete(ParamBuilder builder);

    void add(ParamBuilder builder);

    void update(ParamBuilder builder);
}
