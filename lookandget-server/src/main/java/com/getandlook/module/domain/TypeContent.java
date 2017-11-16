package com.getandlook.module.domain;

import javax.persistence.*;

/**
 * Created by Володимир Майборода on 28.10.2017.
 */

@Entity
@Table(name = "type_content")
public class TypeContent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    public TypeContent() {
    }

    public TypeContent(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
