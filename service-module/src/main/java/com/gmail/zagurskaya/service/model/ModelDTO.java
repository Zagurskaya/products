package com.gmail.zagurskaya.service.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ModelDTO {

    private Long id;
    @NotNull
    @Size(max = 50)
    private String name;

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

    @Override
    public String toString() {
        return "ModelDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
