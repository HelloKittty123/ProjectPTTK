/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dell
 */
public class BillImport {
    int id, idProduct, count, idCreateStaff, idCarrier, idSupplier;
    String nameProduct, nameCreateStaff, nameCarrier, nameSupplier, createTime;

    public BillImport() {
    }

    public BillImport(int id, int idProduct, int count, int idCreateStaff, int idCarrier, int idSupplier, String nameProduct, String nameCreateStaff, String nameCarrier, String nameSupplier, String createTime) {
        this.id = id;
        this.idProduct = idProduct;
        this.count = count;
        this.idCreateStaff = idCreateStaff;
        this.idCarrier = idCarrier;
        this.idSupplier = idSupplier;
        this.nameProduct = nameProduct;
        this.nameCreateStaff = nameCreateStaff;
        this.nameCarrier = nameCarrier;
        this.nameSupplier = nameSupplier;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getIdCreateStaff() {
        return idCreateStaff;
    }

    public void setIdCreateStaff(int idCreateStaff) {
        this.idCreateStaff = idCreateStaff;
    }

    public int getIdCarrier() {
        return idCarrier;
    }

    public void setIdCarrier(int idCarrier) {
        this.idCarrier = idCarrier;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getNameCreateStaff() {
        return nameCreateStaff;
    }

    public void setNameCreateStaff(String nameCreateStaff) {
        this.nameCreateStaff = nameCreateStaff;
    }

    public String getNameCarrier() {
        return nameCarrier;
    }

    public void setNameCarrier(String nameCarrier) {
        this.nameCarrier = nameCarrier;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    
    
}
