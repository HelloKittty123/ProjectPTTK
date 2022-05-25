/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

/**
 *
 * @author Admin
 */
public class ProductController {
    public static List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        
        Connection conn = null;
        Statement statement = null;
        
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "select product.*, category.id idCat, category.name categoryName from category, product where product.category_id = category.id";
//            sql = "select product.*, category.id idCat, category.name categoryName, "
//                    + "userCreated.id userCreatedId, userCreated.fullname userCreatedName, "
//                    + "userCreated.role_id userCreatedRoleName, roleCreated.id roleCreatedId, "
//                    + "roleCreated.name roleCreatedName "
//                    + "userUpdated.id userUpdatedId, userUpdated.fullname userUpdatedName, "
//                    + "userUpdated.role_id userCreatedRoleName, roleCreated.id roleCreatedId "
//                    + "from product join category on idCat = product.category_id "
//                    + "join user userCreated  on userCreated.id = product.created_staff_id "
//                    + "join role roleCreated on userCreated.role_id = roleCreated.id";
            statement = (Statement) conn.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                Product prd = new Product(resultSet.getInt("id"),
                    resultSet.getString("categoryName"),
                    resultSet.getString("title"),
                    resultSet.getString("price"),
                    resultSet.getString("description"),
                    resultSet.getString("thumbnail"),
                    resultSet.getString("created_at"),
                    resultSet.getString("updated_at"),
                    resultSet.getInt("idCat"), 
                    resultSet.getInt("count"));
                products.add(prd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return products;
    }
    
    public static void insert(Product prd) {
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "insert into product(title, category_id, price, description, thumbnail, created_at, updated_at) values(?, ?, ?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, prd.getTitle());
            statement.setString(2, String.valueOf(prd.getIdCat()));
            statement.setString(3, prd.getPrice());
            statement.setString(4, prd.getDescription());
            statement.setString(5, prd.getThumbnail());
            statement.setString(6, prd.getCreated_at());
            statement.setString(7, prd.getUpdated_at());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static void update(Product prd) {
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "update product set title = ?, category_id = ?, price = ?, description = ?, thumbnail = ?,  updated_at = ? where id = ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, prd.getTitle());
            statement.setInt(2, prd.getIdCat());
            statement.setString(3, prd.getPrice());
            statement.setString(4, prd.getDescription());
            statement.setString(5, prd.getThumbnail());
            statement.setString(6, prd.getUpdated_at());
            statement.setInt(7, prd.getId());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static void delete(int id) {
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "delete from product where id = ?";
            statement = conn.prepareCall(sql);
            
            statement.setInt(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static List<Product> findByTitleProduct(String title) {
        List<Product> products = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement statement = null;
        try {
           
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "select product.*, category.name categoryName "
                    + "from product join category "
                    + "on category.id = category_id"
                    + "where title like ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, title + "%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Product prd = new Product(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("price"),
                    resultSet.getString("categoryName"),
                    resultSet.getString("description"),
                    resultSet.getString("thumbnail"),
                    resultSet.getString("created_at"),
                    resultSet.getString("updated_at"),
                    resultSet.getInt("count")
                );
                products.add(prd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return products;
    }

//    public static List<Product> findByCat(String name_cat) {
//        List<Product> products = new ArrayList<>();
//        
//        Connection conn = null;
//        PreparedStatement statement = null;
//        try {
//            
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
//            
//            //query
//            String sql = "select product.*, category.name categoryName from category "
//                    + "join product on category.id = product.category_id where category.name = ?";
//            statement = conn.prepareStatement(sql);
//            statement.setString(1, name_cat );
//            
//            ResultSet resultSet = statement.executeQuery();
//            
//            while (resultSet.next()) {
//                Product prd = new Product(
//                    resultSet.getInt("id"),
//                    resultSet.getString("title"),
//                    resultSet.getString("categoryName"),
//                    resultSet.getString("price"),
//                    resultSet.getString("description"),
//                    resultSet.getString("thumbnail"),
//                    resultSet.getString("created_at"),
//                    resultSet.getString("updated_at"));
//                products.add(prd);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if(statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//        //ket thuc.
//        
//        return products;
//    }
            
    
}


