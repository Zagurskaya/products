package com.gmail.zagurskaya.repository.model;

import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "uppercase")
    private String upperCaseName;

    @Column(name = "lowercase")
    private String lowerCaseName;

    @Where(clause = "exists (select * from model where name = product.uppercase)")
    private List<Model> modelsUpperCaseList = new ArrayList<>();


    @Where(clause = "exists (select * from model where name = product.lowercase)")
    private List<Model> modelsLowerCaseList = new ArrayList<>();

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

    public List<Model> getModelsUpperCaseList() {
        return modelsUpperCaseList;
    }

    public void setModelsUpperCaseList(List<Model> modelsUpperCaseList) {
        this.modelsUpperCaseList = modelsUpperCaseList;
    }

    public List<Model> getModelsLowerCaseList() {
        return modelsLowerCaseList;
    }

    public void setModelsLowerCaseList(List<Model> modelsLowerCaseList) {
        this.modelsLowerCaseList = modelsLowerCaseList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", upperCaseName='" + upperCaseName + '\'' +
                ", lowerCaseName='" + lowerCaseName + '\'' +
                '}';
    }
}
