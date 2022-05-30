/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BillImport;
import model.Product;

/**
 *
 * @author Dell
 */
public class BillImportController {
    public static List<BillImport> findAll() {
        List<BillImport> billImportList = new ArrayList<>();
        
        Connection conn = null;
        Statement statement = null;
        
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "select bill_import.*, product.title productTitle, "
                    + "supplier.name supplierName, staff.fullname staffName, "
                    + "carrier.fullname carrierName "
                    + "from bill_import join product on bill_import.id_product = product.id "
                    + "join supplier on supplier.id = bill_import.id_supplier "
                    + "join user staff on staff.id = bill_import.id_create_staff "
                    + "join user carrier on carrier.id = bill_import.id_carrier";
            statement = (Statement) conn.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                BillImport billImport = new BillImport( 
                    resultSet.getInt("bill_import.id"),
                    resultSet.getInt("bill_import.id_product"),
                    resultSet.getInt("bill_import.count"),
                    resultSet.getInt("bill_import.id_create_staff"),
                    resultSet.getInt("bill_import.id_carrier"),
                    resultSet.getInt("bill_import.id_supplier"),
                    resultSet.getInt("bill_import.price"),
                    resultSet.getInt("bill_import.status"),
                    resultSet.getString("productTitle"),
                    resultSet.getString("staffName"),
                    resultSet.getString("carrierName"),
                    resultSet.getString("supplierName"),
                    resultSet.getString("create_time"),
                    resultSet.getString("update_time")
                );
                billImportList.add(billImport);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillImportController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillImportController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillImportController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return billImportList;
    }
    
    public static void insert(BillImport billImport) {
        Connection conn = null;
        java.sql.PreparedStatement statement = null;
        try {
            //lay tat ca danh mục
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "insert into bill_import(id_product, count, price, id_supplier, "
                    + "create_time, update_time, id_create_staff, id_carrier, status)"
                    + " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = conn.prepareCall(sql);
            statement.setInt(1, billImport.getIdProduct());
            statement.setInt(2, billImport.getCount());
            statement.setInt(3, billImport.getPrice());
            statement.setInt(4, billImport.getIdSupplier());
            statement.setString(5, billImport.getCreateTime());
            statement.setString(6, billImport.getUpdateTime());
            statement.setInt(7, billImport.getIdCreateStaff());
            statement.setInt(8, billImport.getIdCarrier());
            statement.setInt(9, billImport.getStatus());
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(BillImportController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillImportController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillImportController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void update(BillImport billImport) {
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "update bill_import set id_product = ?, count = ?, price = ?, "
                    + "id_supplier = ?, update_time = ?, id_carrier = ? "
                    + "where id = ?";
            statement = conn.prepareCall(sql);
            statement.setInt(1, billImport.getIdProduct());
            statement.setInt(2, billImport.getCount());
            statement.setInt(3, billImport.getPrice());
            statement.setInt(4, billImport.getIdSupplier());
            statement.setString(5, billImport.getUpdateTime());
            statement.setInt(6, billImport.getIdCarrier());
            statement.setInt(7, billImport.getId());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BillImportController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillImportController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillImportController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void updateStatus(BillImport billImport) {
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "update bill_import set status = ? where id = ?";
            statement = conn.prepareCall(sql);
            statement.setInt(1, billImport.getStatus());
            statement.setInt(2, billImport.getId());
            statement.execute();
            
            Product product = ProductController.findByIdProduct(billImport.getIdProduct());
            int count = product.getCount() + billImport.getCount();
            sql = "update product set count = ? where id = ?";
            statement = conn.prepareCall(sql);
            statement.setInt(1, count);
            statement.setInt(2, billImport.getIdProduct());
            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(BillImportController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillImportController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillImportController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void delete(int id) {
        Connection conn = null;
        java.sql.PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            
            String sql = "delete from bill_import where id = ?";
            statement = conn.prepareCall(sql);
            
            statement.setInt(1, id);
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(BillImportController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillImportController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillImportController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static List<BillImport> findByNameSupplier(String fullname) {
        List<BillImport> billImportList = new ArrayList<>();
        
        Connection conn = null;
        java.sql.PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "select bill_import.*, product.title productTitle, "
                    + "supplier.name supplierName, staff.fullname staffName, "
                    + "carrier.fullname carrierName "
                    + "from bill_import join product on bill_import.id_product = product.id "
                    + "join supplier on supplier.id = bill_import.id_supplier "
                    + "join user staff on staff.id = bill_import.id_create_staff "
                    + "join user carrier on carrier.id = bill_import.id_carrier "
                    + "where supplier.name like ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, fullname + "%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                BillImport billImport = new BillImport( 
                    resultSet.getInt("bill_import.id"),
                    resultSet.getInt("bill_import.id_product"),
                    resultSet.getInt("bill_import.count"),
                    resultSet.getInt("bill_import.id_create_staff"),
                    resultSet.getInt("bill_import.id_carrier"),
                    resultSet.getInt("bill_import.id_supplier"),
                    resultSet.getInt("bill_import.price"),
                    resultSet.getInt("bill_import.status"),
                    resultSet.getString("productTitle"),
                    resultSet.getString("staffName"),
                    resultSet.getString("carrierName"),
                    resultSet.getString("supplierName"),
                    resultSet.getString("create_time"),
                    resultSet.getString("update_time")
                );
                billImportList.add(billImport);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return billImportList;
    }
}
