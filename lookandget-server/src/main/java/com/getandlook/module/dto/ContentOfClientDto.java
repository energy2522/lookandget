package com.getandlook.module.dto;

/**
 * Created by Володимир Майборода on 30.10.2017.
 */

public class ContentOfClientDto {

    private Integer id;

    private Integer clientId;

    private Integer typeContentId;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getTypeContentId() {
        return typeContentId;
    }

    public void setTypeContentId(Integer typeContentId) {
        this.typeContentId = typeContentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
