package com.habibu.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name = "tags")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tag_id;
    private String description;



    public Long getTag_id() {
        return tag_id;
    }

    public Long getTag_Id(){
        return tag_id;
    }

    public void setTag_id(Long tag_id){
        this.tag_id = tag_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
