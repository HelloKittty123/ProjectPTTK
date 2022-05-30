/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import model.User;

/**
 *
 * @author Admin
 */
public class UserController {
    
    public static List<User> findAll() {
        List<User> users = new ArrayList<>();
        
        Connection conn = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "select user.*, role.id idRole, role.name roleName "
                    + "from role join user on role.id = user.role_id";
            statement = (Statement) conn.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                User user = new User( resultSet.getInt("id"),
                    resultSet.getString("fullname"),
                    resultSet.getString("email"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("address"),
                    resultSet.getString("password"),
                    resultSet.getString("roleName"),
                    resultSet.getString("created_at"),
                    resultSet.getString("updated_at"),
                    resultSet.getString("gender"),
                    resultSet.getInt("idRole"),
                    resultSet.getInt("status")
                );
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return users;
    }
    
    public static void insert(User user) {
        Connection conn = null;
        java.sql.PreparedStatement statement = null;
        try {
            //lay tat ca danh mục
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "insert into user(fullname, gender, email, phone_number, address,"
                    + " password, role_id, created_at, updated_at, status) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = conn.prepareCall(sql);
            
            statement.setString(1, user.getFullname());
            statement.setString(2, user.getGender());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPhoneNumber());
            statement.setString(5, user.getAddress());
            statement.setString(6, user.getPassword());
            statement.setString(7, String.valueOf(user.getIdRole()));
            statement.setString(8, user.getCreated_at());
            statement.setString(9, user.getUpdated_at());
            statement.setInt(10, user.getStatus());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void update(User user) {
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "update user set fullname = ?, gender = ?, email = ?, "
                    + "phone_number = ?, address = ?, password = ?,  updated_at = ?, "
                    + "role_id = ?, status = ? where id = ?";
            statement = conn.prepareCall(sql);
            
            statement.setString(1, user.getFullname());
            statement.setString(2, user.getGender());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPhoneNumber());
            statement.setString(5, user.getAddress());
            statement.setString(6, user.getPassword());
            statement.setString(7, user.getUpdated_at());
            statement.setInt(8, user.getIdRole());
            statement.setInt(9, user.getStatus());
            statement.setInt(10, user.getId());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static List<User> findByFullnameUser(String fullname) {
        List<User> users = new ArrayList<>();
        
        Connection conn = null;
        java.sql.PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "select user.*, role.id idRole, role.name roleName from role, user where user.role_id = role.id and fullname like ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, fullname + "%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                User user = new User( resultSet.getInt("id"),
                    resultSet.getString("gender"),
                    resultSet.getString("fullname"),
                    resultSet.getString("email"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("address"),
                    resultSet.getString("password"),
                    resultSet.getString("roleName"),
                    resultSet.getString("created_at"),
                    resultSet.getString("updated_at"),
                    resultSet.getInt("idRole"),
                    resultSet.getInt("status")
                );
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return users;
    }
    
    public static List<User> findAllStaff() {
        List<User> users = new ArrayList<>();
        
        Connection conn = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "select user.*, role.id idRole, role.name roleName "
                    + "from user join role on role.id = user.role_id "
                    + "where user.role_id = 4 or user.role_id = 3 or user.role_id = 2 or user.role_id = 1";
            statement = (Statement) conn.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                User user = new User( resultSet.getInt("id"),
                    resultSet.getString("fullname"),
                    resultSet.getString("email"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("address"),
                    resultSet.getString("password"),
                    resultSet.getString("roleName"),
                    resultSet.getString("created_at"),
                    resultSet.getString("updated_at"),
                    resultSet.getString("gender"),
                    resultSet.getInt("idRole"),
                    resultSet.getInt("status")
                );
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return users;
    }
    
    public static List<User> findAllCustom() {
        List<User> users = new ArrayList<>();
        
        Connection conn = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "select user.*, role.id idRole, role.name roleName "
                    + "from user join role on role.id = user.role_id "
                    + "where user.role_id = 5";
            statement = (Statement) conn.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                User user = new User( resultSet.getInt("id"),
                    resultSet.getString("fullname"),
                    resultSet.getString("email"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("address"),
                    resultSet.getString("password"),
                    resultSet.getString("roleName"),
                    resultSet.getString("created_at"),
                    resultSet.getString("updated_at"),
                    resultSet.getString("gender"),
                    resultSet.getInt("idRole"),
                    resultSet.getInt("status")
                );
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return users;
    }
    
    public static List<User> findAllCarrier() {
        List<User> users = new ArrayList<>();
        
        Connection conn = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "select user.*, role.id idRole, role.name roleName "
                    + "from user join role on role.id = user.role_id "
                    + "where user.role_id = 4";
            statement = (Statement) conn.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                User user = new User( resultSet.getInt("id"),
                    resultSet.getString("fullname"),
                    resultSet.getString("email"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("address"),
                    resultSet.getString("password"),
                    resultSet.getString("roleName"),
                    resultSet.getString("created_at"),
                    resultSet.getString("updated_at"),
                    resultSet.getString("gender"),
                    resultSet.getInt("idRole"),
                    resultSet.getInt("status")
                );
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return users;
    }
    
    public static List<User> findAllCarrierOnWork() {
        List<User> users = new ArrayList<>();
        
        Connection conn = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_dam_cuoi", "root", "trung123Aa");
            
            //query
            String sql = "select user.*, role.id idRole, role.name roleName "
                    + "from user join role on role.id = user.role_id "
                    + "where user.role_id = 4 and user.status = 0";
            statement = (Statement) conn.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                User user = new User( resultSet.getInt("id"),
                    resultSet.getString("fullname"),
                    resultSet.getString("email"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("address"),
                    resultSet.getString("password"),
                    resultSet.getString("roleName"),
                    resultSet.getString("created_at"),
                    resultSet.getString("updated_at"),
                    resultSet.getString("gender"),
                    resultSet.getInt("idRole"),
                    resultSet.getInt("status")
                );
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return users;
    }

}
