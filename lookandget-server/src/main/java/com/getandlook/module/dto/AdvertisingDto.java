package com.getandlook.module.dto;

/**
 * Created by Володимир Майборода on 30.10.2017.
 */

public class AdvertisingDto {

    private Integer id;

    private String pathToImage;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String pathToImage) {
        this.pathToImage = pathToImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
