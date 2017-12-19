package com.getandlook.module;

/**
 * Created by Володимир Майборода on 17.12.2017.
 */
public class ImageReq {
    private String typeOfContent;
    private Integer idClient;
    private String image;

    public String getTypeOfContent() {
        return typeOfContent;
    }

    public void setTypeOfContent(String typeOfContent) {
        this.typeOfContent = typeOfContent;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
