/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Dell
 */
public class BillExportController {
    int id, orderId, createStaffId, CarrierId;
    Double total;
    String fullName, phoneNumber, email, address, note, createTime;

    public BillExportController() {
    }

    public BillExportController(int id, int orderId, int createStaffId, int CarrierId, Double total, String fullName, String phoneNumber, String email, String address, String note, String createTime) {
        this.id = id;
        this.orderId = orderId;
        this.createStaffId = createStaffId;
        this.CarrierId = CarrierId;
        this.total = total;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.note = note;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCreateStaffId() {
        return createStaffId;
    }

    public void setCreateStaffId(int createStaffId) {
        this.createStaffId = createStaffId;
    }

    public int getCarrierId() {
        return CarrierId;
    }

    public void setCarrierId(int CarrierId) {
        this.CarrierId = CarrierId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    
    
    
    
}
