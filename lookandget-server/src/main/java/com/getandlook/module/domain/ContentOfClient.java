package com.getandlook.module.domain;

import javax.persistence.*;

/**
 * Created by Володимир Майборода on 28.10.2017.
 */

@Entity
@Table(name = "content_of_client")
public class ContentOfClient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_content", nullable = false)
    private TypeContent typeContent;

    @Column(name = "status")
    private String status;

    public ContentOfClient() {
    }

    public ContentOfClient(Client client, TypeContent typeContent, String status) {
        this.client = client;
        this.typeContent = typeContent;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public TypeContent getTypeContent() {
        return typeContent;
    }

    public void setTypeContent(TypeContent typeContent) {
        this.typeContent = typeContent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
