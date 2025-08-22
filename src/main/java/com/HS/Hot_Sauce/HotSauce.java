package com.HS.Hot_Sauce;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Maps class to a database table--allows JPA operations (CRUD)
@Table(name = "sauce_statistics")
public class HotSauce
{
    // @Column annotation tells springboot where to reference that column
    @Column (name = "name")
    private String name;

    @Column (name = "scoville heat units")
    private String scovilleHeatUnits;

    @Column (name = "scoville level")
    private String scovilleLevel;

    @Column (name = "producer")
    private String producer;

    @Id // Marks this column as the primary key
    @Column (name = "id")
    private String id;

    public HotSauce() {}

    public HotSauce(String name, String scovilleHeatUnits, String scovilleLevel, String producer, String id) {
        this.name = name;
        this.scovilleHeatUnits = scovilleHeatUnits;
        this.scovilleLevel = scovilleLevel;
        this.producer = producer;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScovilleHeatUnits() {
        return scovilleHeatUnits;
    }

    public void setScovilleHeatUnits(String scovilleHeatUnits) {
        this.scovilleHeatUnits = scovilleHeatUnits;
    }

    public String getScovilleLevel() {
        return scovilleLevel;
    }

    public void setScovilleLevel(String scovilleLevel) {
        this.scovilleLevel = scovilleLevel;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
