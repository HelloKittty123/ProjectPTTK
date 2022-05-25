/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Supplier;

/**
 *
 * @author Dell
 */
public class SupplierController {
   public static List<Supplier> findAll() {
        List<Supplier> supplierList = new ArrayList<>();
        
        Connection conn = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "select * from supplier";
            statement = (Statement) conn.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                Supplier supplier = new Supplier(resultSet.getInt("id"), 
                        resultSet.getString("name"), 
                        resultSet.getString("phone_number"), 
                        resultSet.getString("email"), 
                        resultSet.getString("address"),
                        resultSet.getString("created_time"),
                        resultSet.getString("updated_time"));
                supplierList.add(supplier);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return supplierList;
    }
    
    public static void insert(Supplier supplier) {
        Connection conn = null;
        java.sql.PreparedStatement statement = null;
        try {
            //lay tat ca danh mục
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "insert into supplier(name, phone_number, email, address, "
                    + "created_time, updated_time) values(?, ?, ?, ?, ?, ?)";
            statement = conn.prepareCall(sql);
            
            statement.setString(1, supplier.getName());
            statement.setString(2, supplier.getPhoneNumber());
            statement.setString(3, supplier.getEmail());
            statement.setString(4, supplier.getAddress());
            statement.setString(5, supplier.getCreatedTime());
            statement.setString(6, supplier.getUpdatedTime());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void update(Supplier supplier) {
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "update supplier set name = ?, phone_number = ?, email = ?, address = ?, updated_time = ? where id = ?";
            statement = conn.prepareCall(sql);
            
            statement.setString(1, supplier.getName());
            statement.setString(2, supplier.getPhoneNumber());
            statement.setString(3, supplier.getEmail());
            statement.setString(4, supplier.getAddress());
            statement.setString(5, supplier.getUpdatedTime());
            statement.setInt(6, supplier.getId());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static List<Supplier> findByNameSupplier(String name) {
        List<Supplier> supplierList = new ArrayList<>();
        
        Connection conn = null;
        java.sql.PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "select * from supplier where name like ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, name + "%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Supplier supplier = new Supplier(resultSet.getInt("id"), 
                        resultSet.getString("name"), 
                        resultSet.getString("phone_number"), 
                        resultSet.getString("email"), 
                        resultSet.getString("address"),
                        resultSet.getString("created_time"),
                        resultSet.getString("updated_time"));
                supplierList.add(supplier);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SupplierController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return supplierList;
    }
}
