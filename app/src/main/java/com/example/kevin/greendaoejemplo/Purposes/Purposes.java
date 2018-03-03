package com.example.kevin.greendaoejemplo.Purposes;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.util.Date;

/**
 * Created by KEVIN on 28/2/2018.
 */

@Entity
public class Purposes {


    @Id(autoincrement = true)
    private Long Id;

    private String name;

    private String description;

    private int percentage;

    private Date date;

    private boolean state;

    @Generated(hash = 1203198114)
    public Purposes(Long Id, String name, String description, int percentage,
            Date date, boolean state) {
        this.Id = Id;
        this.name = name;
        this.description = description;
        this.percentage = percentage;
        this.date = date;
        this.state = state;
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

    public int getPercentage() {
        return this.percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getState() {
        return this.state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    
}
