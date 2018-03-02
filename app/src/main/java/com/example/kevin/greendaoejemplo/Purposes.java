package com.example.kevin.greendaoejemplo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by KEVIN on 28/2/2018.
 */

@Entity
public class Purposes {


    @Id(autoincrement = true)
    private Long Id;

    private String name;

    private String description;

    private double percentage;

    @Generated(hash = 272311358)
    public Purposes(Long Id, String name, String description, double percentage) {
        this.Id = Id;
        this.name = name;
        this.description = description;
        this.percentage = percentage;
    }

    @Generated(hash = 1209183919)
    public Purposes() {
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPercentage() {
        return this.percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }


}
