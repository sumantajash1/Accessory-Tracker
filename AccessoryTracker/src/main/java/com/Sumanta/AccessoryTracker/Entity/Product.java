package com.Sumanta.AccessoryTracker.Entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product_data")
@Component
public class Product {
	@Id
	private String id;
	private String name;
    private String type;
    private String place;
    private String warranty;

    public Product() {
    }

    public Product(String id, String name, String type, String place, String warranty) {
    	this.id = id;
        this.name = name;
        this.type = type;
        this.place = place;
        this.warranty = warranty;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id; 
    }
    
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return this.place;
    }
    
    public void setPlace(String place) {
        this.place = place;
    }

    public String getWarranty() {
        return this.warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", place='" + place + '\'' +
                ", warranty=" + warranty +
                '}';
    }
}
