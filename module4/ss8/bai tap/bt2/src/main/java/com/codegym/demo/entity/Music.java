package com.codegym.demo.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Component
public class Music {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Size(max = 800)
    private String name;

    @NotBlank
    @Size(max = 300)
    private String singer;

    @NotBlank
    @Size(max = 1000)
    private String type;

    public Music() {
    }

    public Music(Long id, @NotBlank @Size(max = 800) String name, @NotBlank @Size(max = 300) String singer, @NotBlank @Size(max = 1000) String type) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
