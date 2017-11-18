package com.getandlook.module.domain;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

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

    @Column(name = "most_emotion")
    private String mostEmotion;

    @Column(name = "anger")
    private Double anger;

    @Column(name = "contempt")
    private Double contempt;

    @Column(name = "disgust")
    private Double disgust;

    @Column(name = "fear")
    private Double fear;

    @Column(name = "happiness")
    private Double happiness;

    @Column(name = "neutral")
    private Double neutral;

    @Column(name = "sadness")
    private Double sadness;

    @Column(name = "surprise")
    private Double surprise;

    @Transient
    private Map<String, Double> map;

    public ContentOfClient() {
        setMapDefault();
    }

    public ContentOfClient(Client client, TypeContent typeContent, String mostEmotion) {
        setMapDefault();
        this.client = client;
        this.typeContent = typeContent;
        this.mostEmotion = mostEmotion;
    }

    public Double getAnger() {
        return anger;
    }

    public void setAnger(Double anger) {
        this.anger = anger;
    }

    public Double getContempt() {
        return contempt;
    }

    public void setContempt(Double contempt) {
        this.contempt = contempt;
    }

    public Double getDisgust() {
        return disgust;
    }

    public void setDisgust(Double disgust) {
        this.disgust = disgust;
    }

    public Double getFear() {
        return fear;
    }

    public void setFear(Double fear) {
        this.fear = fear;
    }

    public Double getHappiness() {
        return happiness;
    }

    public void setHappiness(Double happiness) {
        this.happiness = happiness;
    }

    public Double getNeutral() {
        return neutral;
    }

    public void setNeutral(Double neutral) {
        this.neutral = neutral;
    }

    public Double getSadness() {
        return sadness;
    }

    public void setSadness(Double sadness) {
        this.sadness = sadness;
    }

    public Double getSurprise() {
        return surprise;
    }

    public void setSurprise(Double surprise) {
        this.surprise = surprise;
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

    public String getMostEmotion() {
        return mostEmotion;
    }

    public void setMostEmotion(String mostEmotion) {
        this.mostEmotion = mostEmotion;
    }

    public Map<String, Double> getMap() {
        return map;
    }

    public void setMap(Map<String, Double> anotherMap) {
        for (Map.Entry<String, Double> pair : anotherMap.entrySet()) {
            map.put(pair.getKey(), pair.getValue() + anotherMap.get(pair.getKey()));
        }
    }

    private void setMapDefault() {
        map = new HashMap<>();
        map.put("contempt", 0d);
        map.put("surprise", 0d);
        map.put("happiness", 0d);
        map.put("neutral", 0d);
        map.put("sadness", 0d);
        map.put("disgust", 0d);
        map.put("anger", 0d);
        map.put("fear", 0d);
    }
}
