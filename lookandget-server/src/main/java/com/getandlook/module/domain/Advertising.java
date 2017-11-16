package com.getandlook.module.domain;

import javax.persistence.*;

/**
 * Created by Володимир Майборода on 28.10.2017.
 */

@Entity
@Table(name = "advertising")
public class Advertising {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "image", nullable = false)
    private String pathToImage;

    @Column(name = "description")
    private String description;

    public Advertising() {
    }

    public Advertising(String pathToImage, String description) {
        this.pathToImage = pathToImage;
        this.description = description;
    }

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
