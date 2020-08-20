package com.gmail.zagurskaya.service.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductDTO {

    private Long id;
    @NotNull
    @Size(max = 50)
    private String name;
    @NotNull
    @Size(max = 50)
    private String upperCaseName;
    @NotNull
    @Size(max = 50)
    private String lowerCaseName;
    @NotNull
    private Long countUpperCaseName;
    @NotNull
    private Long countLowerCaseName;

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

    public String getUpperCaseName() {
        return upperCaseName;
    }

    public void setUpperCaseName(String upperCaseName) {
        this.upperCaseName = upperCaseName;
    }

    public String getLowerCaseName() {
        return lowerCaseName;
    }

    public void setLowerCaseName(String lowerCaseName) {
        this.lowerCaseName = lowerCaseName;
    }

    public Long getCountUpperCaseName() {
        return countUpperCaseName;
    }

    public void setCountUpperCaseName(Long countUpperCaseName) {
        this.countUpperCaseName = countUpperCaseName;
    }

    public Long getCountLowerCaseName() {
        return countLowerCaseName;
    }

    public void setCountLowerCaseName(Long countLowerCaseName) {
        this.countLowerCaseName = countLowerCaseName;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", upperCaseName='" + upperCaseName + '\'' +
                ", lowerCaseName='" + lowerCaseName + '\'' +
                ", countUpperCaseName=" + countUpperCaseName +
                ", countLowerCaseName=" + countLowerCaseName +
                '}';
    }
}
