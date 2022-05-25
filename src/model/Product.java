/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Product {
    int id;
    String title, price, categoryName, description, thumbnail;
    String created_at, updated_at;
    
    int idCat, count;

    public Product() {
    }

    public Product(int id, String title, String price, String categoryName, String description, String thumbnail, String created_at, String updated_at, int idCat, int count) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.categoryName = categoryName;
        this.description = description;
        this.thumbnail = thumbnail;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.idCat = idCat;
        this.count = count;
    }

    public Product(int id, String title, String price, String categoryName, String description, String thumbnail, String created_at, String updated_at, int count) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.categoryName = categoryName;
        this.description = description;
        this.thumbnail = thumbnail;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.count = count;
    }

    public Product(String title, String price, String description, String thumbnail, String created_at, String updated_at, int idCat, int count) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.thumbnail = thumbnail;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.idCat = idCat;
        this.count = count;
    }

    public Product(int id, String title, String price, String description, String thumbnail, String updated_at, int idCat) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.thumbnail = thumbnail;
        this.updated_at = updated_at;
        this.idCat = idCat;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    
    
}
