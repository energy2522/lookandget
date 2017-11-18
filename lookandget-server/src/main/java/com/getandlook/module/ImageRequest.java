package com.getandlook.module;

/**
 * Created by Володимир Майборода on 31.10.2017.
 */

public class ImageRequest {
    private String path;
    private String typeOfImage;
    private String typeOfContent;
    private Integer idOfClient;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTypeOfImage() {
        return typeOfImage;
    }

    public void setTypeOfImage(String typeOfImage) {
        this.typeOfImage = typeOfImage;
    }

    public String getTypeOfContent() {
        return typeOfContent;
    }

    public void setTypeOfContent(String typeOfContent) {
        this.typeOfContent = typeOfContent;
    }

    public Integer getIdOfClient() {
        return idOfClient;
    }

    public void setIdOfClient(Integer idOfClient) {
        this.idOfClient = idOfClient;
    }
}
