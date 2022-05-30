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
import model.BillExport;

/**
 *
 * @author Dell
 */
public class BillExportController {
    public static List<BillExport> findAll() {
        List<BillExport> billExportList = new ArrayList<>();
        
        Connection conn = null;
        Statement statement = null;
        
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "select bill_export.*, orders.fullname, orders.phone_number, "
                    + "orders.email, orders.address, orders.note, orders.total, "
                    + "staff.fullname nameStaff, roleStaff.name roleStaffName,  "
                    + "carrier.fullname nameCarrier, roleCarrier.name roleCarrierName "
                    + "from bill_export join orders on bill_export.order_id = orders.id "
                    + "join user staff on staff.id = bill_export.id_create_staff "
                    + "join user carrier on carrier.id = bill_export.id_carrier "
                    + "join role roleStaff on roleStaff.id = staff.role_id "
                    + "join role roleCarrier on roleCarrier.id = carrier.role_id "
                    + "where orders.status = 1";
            statement = (Statement) conn.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                BillExport billExport = new BillExport( 
                    resultSet.getInt("bill_export.id"),
                    resultSet.getInt("bill_export.order_id"),
                    resultSet.getInt("bill_export.id_create_staff"),
                    resultSet.getInt("bill_export.id_carrier"),
                    resultSet.getString("fullname"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("email"),
                    resultSet.getString("address"),
                    resultSet.getString("note"),
                    resultSet.getString("create_time"),
                    resultSet.getString("nameStaff"),
                    resultSet.getString("nameCarrier"),
                    resultSet.getString("total")
                );
                billExportList.add(billExport);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillExportController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillExportController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillExportController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return billExportList;
    }
    
    public static void insert(BillExport billExport) {
        Connection conn = null;
        java.sql.PreparedStatement statement = null;
        try {
            //lay tat ca danh mục
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "insert into bill_export(order_id, create_time, id_create_staff, "
                    + "id_carrier) values(?, ?, ?, ?)";
            statement = conn.prepareCall(sql);
            statement.setInt(1, billExport.getOrderId());
            statement.setString(2, billExport.getCreateTime());
            statement.setInt(3, billExport.getCreateStaffId());
            statement.setInt(4, billExport.getCarrierId());
            statement.execute();
            
            sql = "update orders set status = 1 where id = ?";
            statement = conn.prepareCall(sql);
            statement.setInt(1, billExport.getOrderId());
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(BillExportController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillExportController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillExportController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
}
