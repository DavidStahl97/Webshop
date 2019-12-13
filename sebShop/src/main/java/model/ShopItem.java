package model;

import java.io.Serializable;

public class ShopItem implements Serializable {

    private static final long serialVersionUID = 6446548872534298559L;
    private String id;
    private String description;
    private String itemType;
    private String suitedFor;
    private String brand;
    private String color;
    private String imgPath;
    private double price;

    public ShopItem (){}

    public ShopItem(String id, String description, String itemType, String suitedFor, String brand, String color, String imgPath, double price) {
        this.id = id;
        this.description = description;
        this.itemType = itemType;
        this.suitedFor = suitedFor;
        this.brand = brand;
        this.color = color;
        this.imgPath = imgPath;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getSuitedFor() {
        return suitedFor;
    }

    public void setSuitedFor(String suitedFor) {
        this.suitedFor = suitedFor;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ShopItem{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", itemType='" + itemType + '\'' +
                ", suitedFor='" + suitedFor + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", price=" + price +
                '}';
    }

}


