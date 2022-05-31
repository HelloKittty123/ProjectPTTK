/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import controller.BillExportController;
import controller.BillImportController;
import controller.CategoryController;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Category;
import controller.FeedBackController;
import controller.OrderController;
import model.Product;
import controller.ProductController;
import controller.RoleController;
import controller.SupplierController;
import model.Role;
import model.User;
import controller.UserController;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import model.BillExport;
import model.BillImport;
import model.Feedback;
import model.Order;
import model.Supplier;
/**
 *
 * @author Admin
 */
public class AppManager extends javax.swing.JFrame {
    DefaultTableModel tableModelProduct;
    DefaultTableModel tableModelUser;
    DefaultTableModel tableModelFeedback; 
    DefaultTableModel tableModelOrder;
    DefaultTableModel tableModelSupplier;
    DefaultTableModel tableModelBillExport;
    DefaultTableModel tableModelBillImport;
    DefaultTableModel tableModelCustom;
    
    
    List<Product> products = new ArrayList<>();
    List<Category> categoryList = new ArrayList<>();
    List<User> staffList = new ArrayList<>();
    List<User> carrierList = new ArrayList<>();
    List<User> customList = new ArrayList<>();
    List<Role> roleList = new ArrayList<>();
    List<Feedback> feedbackList = new ArrayList<>();
    List<Order> orderList = new ArrayList<>();
    List<BillExport> billExportList = new ArrayList<>();
    List<BillImport> billImportList = new ArrayList<>();
    List<Supplier> supplierList = new ArrayList<>();
    
    OrderProductFrm orderProductFrm;
    BillExportFrm billExportFrm;
    LoginFrm loginFrm;
    
    int id_user = 0;

    /**
     * Creates new form NewJFrame
     */
    public AppManager() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        loginFrm = new LoginFrm(this, rootPaneCheckingEnabled);
        while(id_user == 0) {
            loginFrm.setVisible(true);
            id_user = loginFrm.getStaffId();
        }
        
        
        tableModelProduct = (DefaultTableModel) tableProduct.getModel();
        tableModelUser = (DefaultTableModel) tableStaff.getModel();
        tableModelFeedback = (DefaultTableModel) tableFeedback.getModel();
        tableModelOrder = (DefaultTableModel) tableOrder.getModel();
        tableModelSupplier = (DefaultTableModel) tableSupplier.getModel();
        tableModelBillExport = (DefaultTableModel) tableBillExport.getModel();
        tableModelBillImport = (DefaultTableModel) tableBillImport.getModel();
        tableModelCustom = (DefaultTableModel) tableCustom.getModel();
        
        showProduct();
        showStaff();
        showFeedback();
        showOrder();
        showBillExport();
        showBillImport();
        showSupplier();
        showCustom();
        
        tableProduct.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                int selectedIndex = tableProduct.getSelectedRow();
                Product prd = products.get(selectedIndex);
                
                txtTitleProduct.setText(prd.getTitle());
                boxCategory.setSelectedItem(prd.getCategoryName());
                txtPrice.setText(prd.getPrice());
                txtDescProduct.setText(prd.getDescription());
                txtThumbProduct.setText(prd.getThumbnail());
                
                btnDeleteProduct.setEnabled(true);
                btnUpdateProduct.setEnabled(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        
        });
        
        tableStaff.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                int selectedIndex = tableStaff.getSelectedRow();
                User staff = staffList.get(selectedIndex);
                
                txtFullname.setText(staff.getFullname());
                boxGender.setSelectedItem(staff.getGender());
                txtEmail.setText(staff.getEmail());
                txtPhonenumber.setText(staff.getPhoneNumber());
                txtAddress.setText(staff.getAddress());
                boxRole.setSelectedItem(staff.getRoleName());
                txtPassword.setText(staff.getPassword());
                cbStatusStaff.setSelectedIndex(staff.getStatus());
                
                btnUpdateStaff.setEnabled(true);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        
        });
        
        tableOrder.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                int selectedIndex = tableOrder.getSelectedRow();
                Order order = orderList.get(selectedIndex);
                
                txtFullnameOrder.setText(order.getFullname());
                txtEmailOrder.setText(order.getEmail());
                txtPhoneNumberOrder.setText(order.getPhoneNumber());
                txtAddressOrder.setText(order.getAddress());
                txtNoteOrder.setText(order.getNote());
                
                btnCreateBillExport.setEnabled(true);
                btnDeleteOrder.setEnabled(true);
                btnShowProductOrder.setEnabled(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        
        });
        
        tableBillImport.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                int selectedIndex = tableBillImport.getSelectedRow();
                BillImport billImport = billImportList.get(selectedIndex);
                
                cbSupplier.setSelectedItem(billImport.getNameSupplier());
                cbProduct.setSelectedItem(billImport.getNameProduct());
                txtCountProduct.setText(String.valueOf(billImport.getCount()));
                txtPriceProduct.setText(String.valueOf(billImport.getPrice()));
                cbCarrierBillImport.setSelectedItem(billImport.getNameCarrier());
                
                btnEditBillImport.setEnabled(true);
                btnDeleteBillImport.setEnabled(true);
                btnSuccessBillImport.setEnabled(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        
        });
        
        tableSupplier.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                int selectedIndex = tableSupplier.getSelectedRow();
                Supplier supplier = supplierList.get(selectedIndex);
                
                txtSupplier.setText(supplier.getName());
                txtEmailSupplier.setText(supplier.getEmail());
                txtPhoneSupplier.setText(supplier.getPhoneNumber());
                txtAddressSupplier.setText(supplier.getAddress());
                
                btnUpdateSupplier.setEnabled(true);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        
        });
        
        
        showComboBox_Category();
        showComboBox_RoleUser();
        showComboBox_Supplier();
        showComboBox_Product();
        showComboBox_Carrier();
    }
    
    public void showComboBox_Category() {
        DefaultComboBoxModel<String> comboBoxModelProduct = (DefaultComboBoxModel<String>) boxCategory.getModel();
        comboBoxModelProduct.removeAllElements();
        categoryList = CategoryController.findAll();
        categoryList.forEach(category -> {
            comboBoxModelProduct.addElement(category.getName());
        });
    }
    
    public void showComboBox_RoleUser() {
        DefaultComboBoxModel<String> comboBoxModelUser = (DefaultComboBoxModel<String>) boxRole.getModel();
        comboBoxModelUser.removeAllElements();
        roleList = RoleController.findAll();
        roleList.forEach(role -> {
            if(role.getId() != 5){
                comboBoxModelUser.addElement(role.getName());
            }
        });
    }
    
    public void showComboBox_Supplier() {
        DefaultComboBoxModel<String> comboBoxModelSupplier = (DefaultComboBoxModel<String>) cbSupplier.getModel();
        comboBoxModelSupplier.removeAllElements();
        supplierList = SupplierController.findAll();
        supplierList.forEach(supplier -> { 
            comboBoxModelSupplier.addElement(supplier.getName());
        });
    }
    
    public void showComboBox_Product() {
        DefaultComboBoxModel<String> comboBoxModelProduct = (DefaultComboBoxModel<String>) cbProduct.getModel();
        comboBoxModelProduct.removeAllElements();
        products = ProductController.findAll();
        products.forEach(product -> {
            comboBoxModelProduct.addElement(product.getTitle());
        });
    }
    
    public void showComboBox_Carrier() {
        DefaultComboBoxModel<String> comboBoxModelCarrier = (DefaultComboBoxModel<String>) cbCarrierBillImport.getModel();
        comboBoxModelCarrier.removeAllElements();
        carrierList = UserController.findAllCarrierOnWork();
        carrierList.forEach(carrier -> {
            comboBoxModelCarrier.addElement(carrier.getFullname());
        });
    }
    
    private void showProduct() {
        products = ProductController.findAll();
        
        tableModelProduct.setRowCount(0);
        
        products.forEach((prd) -> {
            tableModelProduct.addRow(new Object[] {
                tableModelProduct.getRowCount() + 1,
                prd.getTitle(),
                prd.getCategoryName(),
                prd.getPrice(),
                prd.getDescription(),
                prd.getThumbnail(),
                prd.getCount(),
                prd.getCreated_at(),
                prd.getUpdated_at()
            });
        });
    } 
    
    private void showStaff() {
        staffList = UserController.findAllStaff();
        
        tableModelUser.setRowCount(0);
        
        staffList.forEach((staff) -> {
            tableModelUser.addRow(new Object[] {tableModelUser.getRowCount() + 1,
                staff.getFullname(),
                staff.getGender(),
                staff.getEmail(),
                staff.getPhoneNumber(),
                staff.getAddress(),
                staff.getRoleName(),
                staff.getPassword(),
                staff.getCreated_at(),
                staff.getUpdated_at(),
                staff.getStatus()
            });
        });
    }
    
    private void showCustom() {
        customList = UserController.findAllCustom();
        
        tableModelCustom.setRowCount(0);
        
        customList.forEach((custom) -> {
            tableModelCustom.addRow(new Object[] {tableModelUser.getRowCount() + 1,
                custom.getFullname(),
                custom.getGender(),
                custom.getEmail(),
                custom.getPhoneNumber(),
                custom.getAddress(),
                custom.getRoleName(),
                custom.getPassword(),
                custom.getCreated_at(),
                custom.getUpdated_at()});
        });
    }
    
    private void showFeedback() {
        feedbackList = FeedBackController.findAll();
        
        tableModelFeedback.setRowCount(0);
        
        feedbackList.forEach((feedback) -> {
            tableModelFeedback.addRow(new Object[] {tableModelFeedback.getRowCount() + 1,
                feedback.getEmail(),
                feedback.getFullname(),
                feedback.getPhoneNumber(),
                feedback.getAddress(),
                feedback.getNote(),
                feedback.getPhoneNumber(),
                feedback.getCreated_at()});
        });
    }
    
    private void showOrder() {
        orderList = OrderController.findAll();
        
        tableModelOrder.setRowCount(0);
        
        orderList.forEach((order) -> {
            tableModelOrder.addRow(new Object[] {tableModelOrder.getRowCount() + 1,
                order.getFullname(),
                order.getEmail(),
                order.getPhoneNumber(),
                order.getAddress(),
                order.getNote(),
                order.getTotalMoney(),
                order.getCreateTime(),
                order.getStatus()});
        });
    }
    
    private void showBillExport() {
        billExportList = BillExportController.findAll();
        
        tableModelBillExport.setRowCount(0);
        
        billExportList.forEach((billExport) -> {
            tableModelBillExport.addRow(new Object[] {tableModelBillExport.getRowCount() + 1,
                billExport.getFullName(),
                billExport.getEmail(),
                billExport.getPhoneNumber(),
                billExport.getAddress(),
                billExport.getNote(),
                billExport.getTotal(),
                billExport.getCreateTime(),
                billExport.getNameCarrier(),
                billExport.getNameStaff()
            });
        });
    }
    
    private void showBillImport() {
        billImportList = BillImportController.findAll();
        
        tableModelBillImport.setRowCount(0);
        
        billImportList.forEach((billImport) -> {
            tableModelBillImport.addRow(new Object[] {tableModelBillImport.getRowCount() + 1,
                billImport.getNameSupplier(),
                billImport.getNameProduct(),
                billImport.getCount(),
                billImport.getPrice(),
                billImport.getNameCarrier(),
                billImport.getCreateTime(),
                billImport.getNameCreateStaff(),
                billImport.getStatus()
            });
        });
    }
    
    private void showSupplier() {
        supplierList = SupplierController.findAll();
        
        tableModelSupplier.setRowCount(0);
        
        supplierList.forEach((supplier) -> {
            tableModelSupplier.addRow(new Object[] {tableModelSupplier.getRowCount() + 1,
                supplier.getName(),
                supplier.getPhoneNumber(),
                supplier.getEmail(),
                supplier.getAddress(),
                supplier.getCreatedTime(),
                supplier.getUpdatedTime()});
        });
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jplProduct = new javax.swing.JPanel();
        infoProduct = new javax.swing.JPanel();
        Name = new javax.swing.JLabel();
        txtTitleProduct = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        Desc = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        Category = new javax.swing.JLabel();
        btnInsertProduct = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        btnResetProduct = new javax.swing.JButton();
        btnFindProduct = new javax.swing.JButton();
        btnUpdateProduct = new javax.swing.JButton();
        boxCategory = new javax.swing.JComboBox<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtDescProduct = new javax.swing.JTextArea();
        txtThumbProduct = new javax.swing.JTextField();
        Desc1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        jlbThumbProduct = new javax.swing.JLabel();
        btnSelectImg = new javax.swing.JButton();
        jplGuest = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableCustom = new javax.swing.JTable();
        btnFindCustom = new javax.swing.JButton();
        jplStaff = new javax.swing.JPanel();
        jlbGender = new javax.swing.JLabel();
        jlbName = new javax.swing.JLabel();
        jlbPhoneNumber = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtFullname = new javax.swing.JTextField();
        txtPhonenumber = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        btnInsertStaff = new javax.swing.JButton();
        btnUpdateStaff = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableStaff = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btnFindStaff = new javax.swing.JButton();
        btnResetStaff = new javax.swing.JButton();
        boxGender = new javax.swing.JComboBox<>();
        txtPassword = new javax.swing.JPasswordField();
        jlbEmail = new javax.swing.JLabel();
        boxRole = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cbStatusStaff = new javax.swing.JComboBox<>();
        jplResponse = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableFeedback = new javax.swing.JTable();
        btnFindResponse = new javax.swing.JButton();
        jplStatistic = new javax.swing.JPanel();
        jplSupplier = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSupplier = new javax.swing.JTextField();
        txtPhoneSupplier = new javax.swing.JTextField();
        txtEmailSupplier = new javax.swing.JTextField();
        txtAddressSupplier = new javax.swing.JTextField();
        btnAddSupplier = new javax.swing.JButton();
        btnUpdateSupplier = new javax.swing.JButton();
        btnFindSupplier = new javax.swing.JButton();
        btnResetSupplier = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableSupplier = new javax.swing.JTable();
        jplBillManage = new javax.swing.JTabbedPane();
        jplBillExport = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tableBillExport = new javax.swing.JTable();
        jplBill = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableOrder = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        btnDeleteOrder = new javax.swing.JButton();
        btnShowProductOrder = new javax.swing.JButton();
        btnFindOrder = new javax.swing.JButton();
        btnResetOrder = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtFullnameOrder = new javax.swing.JTextField();
        txtEmailOrder = new javax.swing.JTextField();
        txtPhoneNumberOrder = new javax.swing.JTextField();
        txtAddressOrder = new javax.swing.JTextField();
        txtNoteOrder2 = new javax.swing.JScrollPane();
        txtNoteOrder = new javax.swing.JTextArea();
        btnCreateBillExport = new javax.swing.JButton();
        jplBillImport = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tableBillImport = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbProduct = new javax.swing.JComboBox<>();
        cbSupplier = new javax.swing.JComboBox<>();
        cbCarrierBillImport = new javax.swing.JComboBox<>();
        txtPriceProduct = new javax.swing.JTextField();
        btnEditBillImport = new javax.swing.JButton();
        btnAddBillImport = new javax.swing.JButton();
        btnResetBillImport = new javax.swing.JButton();
        btnDeleteBillImport = new javax.swing.JButton();
        btnFindBillImport = new javax.swing.JButton();
        txtCountProduct = new javax.swing.JTextField();
        btnSuccessBillImport = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HỆ THỐNG QUẢN LÝ DỊCH VỤ ĐÁM CƯỚI", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        jTabbedPane1.setAutoscrolls(true);

        infoProduct.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập thông tin sản phẩm"));

        Name.setText("Tên Sản Phẩm:");

        Desc.setText("Mô Tả:");

        Price.setText("Giá:");

        Category.setText("Danh Mục Sản Phẩm:");

        btnInsertProduct.setText("Thêm");
        btnInsertProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertProductActionPerformed(evt);
            }
        });

        btnDeleteProduct.setText("Xóa");
        btnDeleteProduct.setEnabled(false);
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });

        btnResetProduct.setText("Reset");
        btnResetProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetProductActionPerformed(evt);
            }
        });

        btnFindProduct.setText("Tìm kiếm");
        btnFindProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindProductActionPerformed(evt);
            }
        });

        btnUpdateProduct.setText("Sửa");
        btnUpdateProduct.setEnabled(false);
        btnUpdateProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProductActionPerformed(evt);
            }
        });

        boxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCategoryActionPerformed(evt);
            }
        });

        txtDescProduct.setColumns(20);
        txtDescProduct.setLineWrap(true);
        txtDescProduct.setRows(5);
        jScrollPane9.setViewportView(txtDescProduct);

        txtThumbProduct.setEditable(false);
        txtThumbProduct.setBackground(new java.awt.Color(204, 204, 204));

        Desc1.setText("Link hình ảnh:");

        javax.swing.GroupLayout infoProductLayout = new javax.swing.GroupLayout(infoProduct);
        infoProduct.setLayout(infoProductLayout);
        infoProductLayout.setHorizontalGroup(
            infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoProductLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoProductLayout.createSequentialGroup()
                        .addComponent(btnInsertProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnUpdateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnFindProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnResetProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(infoProductLayout.createSequentialGroup()
                        .addGroup(infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Category, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Desc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Desc1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85)
                        .addGroup(infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtThumbProduct)
                            .addComponent(txtPrice)
                            .addComponent(boxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(txtTitleProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        infoProductLayout.setVerticalGroup(
            infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoProductLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitleProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Category, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Desc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Desc1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(txtThumbProduct))
                .addGap(0, 30, Short.MAX_VALUE)
                .addGroup(infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên Sản Phẩm", "Danh Mục sản Phẩm", "Giá", "Mô Tả", "Hình ảnh", "Số lượng tồn kho", "Ngày tạo", "Ngày update"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableProduct.setRowHeight(28);
        tableProduct.setShowGrid(true);
        jScrollPane2.setViewportView(tableProduct);
        if (tableProduct.getColumnModel().getColumnCount() > 0) {
            tableProduct.getColumnModel().getColumn(0).setMinWidth(5);
            tableProduct.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableProduct.getColumnModel().getColumn(0).setMaxWidth(100);
            tableProduct.getColumnModel().getColumn(1).setMinWidth(100);
            tableProduct.getColumnModel().getColumn(1).setPreferredWidth(120);
            tableProduct.getColumnModel().getColumn(1).setMaxWidth(150);
            tableProduct.getColumnModel().getColumn(2).setMinWidth(100);
            tableProduct.getColumnModel().getColumn(2).setPreferredWidth(120);
            tableProduct.getColumnModel().getColumn(2).setMaxWidth(200);
            tableProduct.getColumnModel().getColumn(3).setMinWidth(50);
            tableProduct.getColumnModel().getColumn(3).setPreferredWidth(100);
            tableProduct.getColumnModel().getColumn(3).setMaxWidth(150);
        }

        jlbThumbProduct.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Hình ảnh")));

        btnSelectImg.setText("Chọn");
        btnSelectImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectImgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jplProductLayout = new javax.swing.GroupLayout(jplProduct);
        jplProduct.setLayout(jplProductLayout);
        jplProductLayout.setHorizontalGroup(
            jplProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplProductLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jplProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplProductLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 118, Short.MAX_VALUE))
                    .addGroup(jplProductLayout.createSequentialGroup()
                        .addComponent(infoProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jplProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jplProductLayout.createSequentialGroup()
                                .addComponent(jlbThumbProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jplProductLayout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(btnSelectImg, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jplProductLayout.setVerticalGroup(
            jplProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jplProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jplProductLayout.createSequentialGroup()
                        .addComponent(jlbThumbProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSelectImg, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(338, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý sản phẩm", jplProduct);

        tableCustom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Họ và tên", "Giới tính", "Email", "Số điện thoại", "Địa chỉ", "Mật khẩu", "Ngày tạo", "Ngày update"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCustom.setRowHeight(28);
        tableCustom.setShowGrid(true);
        jScrollPane7.setViewportView(tableCustom);
        if (tableCustom.getColumnModel().getColumnCount() > 0) {
            tableCustom.getColumnModel().getColumn(0).setMinWidth(5);
            tableCustom.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableCustom.getColumnModel().getColumn(0).setMaxWidth(100);
            tableCustom.getColumnModel().getColumn(2).setResizable(false);
        }

        btnFindCustom.setText("Tìm kiếm");
        btnFindCustom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindCustomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jplGuestLayout = new javax.swing.GroupLayout(jplGuest);
        jplGuest.setLayout(jplGuestLayout);
        jplGuestLayout.setHorizontalGroup(
            jplGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1076, Short.MAX_VALUE)
            .addGroup(jplGuestLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnFindCustom, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jplGuestLayout.setVerticalGroup(
            jplGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplGuestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFindCustom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(548, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý khách hàng", jplGuest);

        jlbGender.setText("Giới tính: ");

        jlbName.setText("Họ và tên:");

        jlbPhoneNumber.setText("Số điện thoại: ");

        jLabel7.setText("Địa chỉ: ");

        jLabel8.setText("Quyền: ");

        btnInsertStaff.setText("Thêm");
        btnInsertStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertStaffActionPerformed(evt);
            }
        });

        btnUpdateStaff.setText("Sửa");
        btnUpdateStaff.setEnabled(false);
        btnUpdateStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStaffActionPerformed(evt);
            }
        });

        tableStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Họ và tên", "Giới tính", "Email", "Số điện thoại", "Địa chỉ", "Quyền", "Mật khẩu", "Ngày tạo", "Ngày update", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableStaff.setRowHeight(28);
        tableStaff.setShowGrid(true);
        jScrollPane4.setViewportView(tableStaff);
        if (tableStaff.getColumnModel().getColumnCount() > 0) {
            tableStaff.getColumnModel().getColumn(0).setMinWidth(5);
            tableStaff.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableStaff.getColumnModel().getColumn(0).setMaxWidth(100);
            tableStaff.getColumnModel().getColumn(2).setResizable(false);
            tableStaff.getColumnModel().getColumn(6).setMinWidth(50);
            tableStaff.getColumnModel().getColumn(6).setPreferredWidth(70);
            tableStaff.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        jLabel9.setText("Trạng thái:");

        btnFindStaff.setText("Tìm Kiếm");
        btnFindStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindStaffActionPerformed(evt);
            }
        });

        btnResetStaff.setText("Reset");
        btnResetStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetStaffActionPerformed(evt);
            }
        });

        boxGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        boxGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxGenderActionPerformed(evt);
            }
        });

        jlbEmail.setText("Email:");

        boxRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxRoleActionPerformed(evt);
            }
        });

        jLabel13.setText("Mật Khẩu:");

        cbStatusStaff.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang làm", "Nghỉ việc" }));

        javax.swing.GroupLayout jplStaffLayout = new javax.swing.GroupLayout(jplStaff);
        jplStaff.setLayout(jplStaffLayout);
        jplStaffLayout.setHorizontalGroup(
            jplStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplStaffLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jplStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbName, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jplStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplStaffLayout.createSequentialGroup()
                        .addGroup(jplStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(txtPhonenumber, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(txtFullname, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(boxGender, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword))
                        .addGap(100, 100, 100)
                        .addGroup(jplStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnInsertStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdateStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnResetStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFindStaff, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(boxRole, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbStatusStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(254, 334, Short.MAX_VALUE))
            .addGroup(jplStaffLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jplStaffLayout.setVerticalGroup(
            jplStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplStaffLayout.createSequentialGroup()
                .addGroup(jplStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplStaffLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnInsertStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jplStaffLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jplStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jplStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxGender, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jplStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplStaffLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnFindStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnResetStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jplStaffLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jplStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jplStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jplStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jplStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxRole, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jplStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jplStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbStatusStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý nhân viên", jplStaff);

        tableFeedback.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên tài khoản", "Tên khách hàng", "SĐT", "Địa chỉ", "Nội Dung", "SĐT", "Ngày tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableFeedback.setRowHeight(30);
        tableFeedback.setShowGrid(true);
        jScrollPane5.setViewportView(tableFeedback);
        if (tableFeedback.getColumnModel().getColumnCount() > 0) {
            tableFeedback.getColumnModel().getColumn(0).setMinWidth(5);
            tableFeedback.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableFeedback.getColumnModel().getColumn(0).setMaxWidth(100);
            tableFeedback.getColumnModel().getColumn(1).setMinWidth(100);
            tableFeedback.getColumnModel().getColumn(1).setPreferredWidth(150);
            tableFeedback.getColumnModel().getColumn(1).setMaxWidth(200);
            tableFeedback.getColumnModel().getColumn(6).setMinWidth(100);
            tableFeedback.getColumnModel().getColumn(6).setPreferredWidth(120);
            tableFeedback.getColumnModel().getColumn(6).setMaxWidth(150);
            tableFeedback.getColumnModel().getColumn(7).setMinWidth(100);
            tableFeedback.getColumnModel().getColumn(7).setPreferredWidth(160);
            tableFeedback.getColumnModel().getColumn(7).setMaxWidth(200);
        }

        btnFindResponse.setText("Tìm kiếm");
        btnFindResponse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindResponseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jplResponseLayout = new javax.swing.GroupLayout(jplResponse);
        jplResponse.setLayout(jplResponseLayout);
        jplResponseLayout.setHorizontalGroup(
            jplResponseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplResponseLayout.createSequentialGroup()
                .addGroup(jplResponseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplResponseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jplResponseLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnFindResponse, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jplResponseLayout.setVerticalGroup(
            jplResponseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplResponseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFindResponse, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(523, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý Phản hồi", jplResponse);

        javax.swing.GroupLayout jplStatisticLayout = new javax.swing.GroupLayout(jplStatistic);
        jplStatistic.setLayout(jplStatisticLayout);
        jplStatisticLayout.setHorizontalGroup(
            jplStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1076, Short.MAX_VALUE)
        );
        jplStatisticLayout.setVerticalGroup(
            jplStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1022, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Thống kê", jplStatistic);

        jLabel1.setText("Tên nhà cung cấp:");

        jLabel2.setText("SĐT:");

        jLabel3.setText("Email: ");

        jLabel4.setText("Địa chỉ:");

        txtSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupplierActionPerformed(evt);
            }
        });

        btnAddSupplier.setText("Thêm");
        btnAddSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSupplierActionPerformed(evt);
            }
        });

        btnUpdateSupplier.setText("Sửa");
        btnUpdateSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSupplierActionPerformed(evt);
            }
        });

        btnFindSupplier.setText("Tìm kiếm");
        btnFindSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindSupplierActionPerformed(evt);
            }
        });

        btnResetSupplier.setText("Reset");
        btnResetSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetSupplierActionPerformed(evt);
            }
        });

        tableSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên nhà cung cấp", "SĐT", "Email", "Địa chỉ", "Ngày tạo", "Ngày sửa"
            }
        ));
        jScrollPane3.setViewportView(tableSupplier);

        javax.swing.GroupLayout jplSupplierLayout = new javax.swing.GroupLayout(jplSupplier);
        jplSupplier.setLayout(jplSupplierLayout);
        jplSupplierLayout.setHorizontalGroup(
            jplSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplSupplierLayout.createSequentialGroup()
                .addGroup(jplSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplSupplierLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(jplSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(63, 63, 63)
                        .addGroup(jplSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSupplier)
                            .addComponent(txtPhoneSupplier)
                            .addComponent(txtEmailSupplier)
                            .addComponent(txtAddressSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
                        .addGap(93, 93, 93)
                        .addGroup(jplSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnResetSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdateSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFindSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)))
                    .addGroup(jplSupplierLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(238, Short.MAX_VALUE))
        );
        jplSupplierLayout.setVerticalGroup(
            jplSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplSupplierLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jplSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnAddSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jplSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplSupplierLayout.createSequentialGroup()
                        .addGroup(jplSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPhoneSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jplSupplierLayout.createSequentialGroup()
                        .addGroup(jplSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jplSupplierLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(txtEmailSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jplSupplierLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btnUpdateSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jplSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFindSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jplSupplierLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jplSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAddressSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25)
                .addComponent(btnResetSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(302, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý nhà cung cấp", jplSupplier);

        tableBillExport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên khách hàng", "Email khách hàng", "SĐT", "Địa chỉ khách hàng", "Ghi chú", "Tổng tiền ", "Ngày tạo", "Người tạo", "Người giao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(tableBillExport);
        if (tableBillExport.getColumnModel().getColumnCount() > 0) {
            tableBillExport.getColumnModel().getColumn(0).setMinWidth(5);
            tableBillExport.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableBillExport.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        javax.swing.GroupLayout jplBillExportLayout = new javax.swing.GroupLayout(jplBillExport);
        jplBillExport.setLayout(jplBillExportLayout);
        jplBillExportLayout.setHorizontalGroup(
            jplBillExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplBillExportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                .addGap(212, 212, 212))
        );
        jplBillExportLayout.setVerticalGroup(
            jplBillExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplBillExportLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(651, Short.MAX_VALUE))
        );

        jplBillManage.addTab("Hóa đơn xuất", jplBillExport);

        tableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên khách hàng", "Email khách hàng", "SĐT", "Địa chỉ khách hàng", "Ghi chú", "Tổng tiền ", "Ngày tạo", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(tableOrder);
        if (tableOrder.getColumnModel().getColumnCount() > 0) {
            tableOrder.getColumnModel().getColumn(0).setMinWidth(5);
            tableOrder.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableOrder.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        btnDeleteOrder.setText("Xóa");
        btnDeleteOrder.setEnabled(false);
        btnDeleteOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteOrderActionPerformed(evt);
            }
        });

        btnShowProductOrder.setText("Show List Order");
        btnShowProductOrder.setEnabled(false);
        btnShowProductOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowProductOrderActionPerformed(evt);
            }
        });

        btnFindOrder.setText("Tìm kiếm");
        btnFindOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindOrderActionPerformed(evt);
            }
        });

        btnResetOrder.setText("Reset");
        btnResetOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetOrderActionPerformed(evt);
            }
        });

        jLabel15.setText("Tên khách hàng:");

        jLabel16.setText("Email khách hàng:");

        jLabel17.setText("SĐT khách hàng: ");

        jLabel18.setText("Địa chỉ khách hàng:");

        jLabel19.setText("Ghi chú:");

        txtFullnameOrder.setEditable(false);

        txtEmailOrder.setEditable(false);

        txtPhoneNumberOrder.setEditable(false);
        txtPhoneNumberOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneNumberOrderActionPerformed(evt);
            }
        });

        txtAddressOrder.setEditable(false);

        txtNoteOrder.setEditable(false);
        txtNoteOrder.setColumns(20);
        txtNoteOrder.setLineWrap(true);
        txtNoteOrder.setRows(5);
        txtNoteOrder2.setViewportView(txtNoteOrder);

        btnCreateBillExport.setText("Tạo hóa đơn xuất");
        btnCreateBillExport.setEnabled(false);
        btnCreateBillExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateBillExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtAddressOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(txtNoteOrder2))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPhoneNumberOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEmailOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(txtFullnameOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnCreateBillExport, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(btnDeleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnShowProductOrder)
                        .addGap(52, 52, 52)
                        .addComponent(btnFindOrder)
                        .addGap(52, 52, 52)
                        .addComponent(btnResetOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFullnameOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhoneNumberOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddressOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoteOrder2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnCreateBillExport, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnShowProductOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnFindOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnResetOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jplBillLayout = new javax.swing.GroupLayout(jplBill);
        jplBill.setLayout(jplBillLayout);
        jplBillLayout.setHorizontalGroup(
            jplBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplBillLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jplBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane10))
                .addGap(51, 51, 51))
        );
        jplBillLayout.setVerticalGroup(
            jplBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplBillLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(271, Short.MAX_VALUE))
        );

        jplBillManage.addTab("Quản lý đơn hàng", jplBill);

        tableBillImport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Nhà cung cấp", "Sản phẩm", "Số lượng", "Giá thành", "Người giao hàng", "Ngày tạo", "Người tạo", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane12.setViewportView(tableBillImport);
        if (tableBillImport.getColumnModel().getColumnCount() > 0) {
            tableBillImport.getColumnModel().getColumn(0).setMinWidth(5);
            tableBillImport.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableBillImport.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jLabel5.setText("Nhà cung cấp:");

        jLabel6.setText("Số lượng:");

        jLabel10.setText("Giá thành:");

        jLabel11.setText("Sản phẩm:");

        jLabel12.setText("Người giao hàng:");

        btnEditBillImport.setText("Sửa");
        btnEditBillImport.setEnabled(false);
        btnEditBillImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditBillImportActionPerformed(evt);
            }
        });

        btnAddBillImport.setText("Thêm");
        btnAddBillImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBillImportActionPerformed(evt);
            }
        });

        btnResetBillImport.setText("Reset");
        btnResetBillImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetBillImportActionPerformed(evt);
            }
        });

        btnDeleteBillImport.setText("Xoá");
        btnDeleteBillImport.setEnabled(false);
        btnDeleteBillImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBillImportActionPerformed(evt);
            }
        });

        btnFindBillImport.setText("Tìm kiếm");
        btnFindBillImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindBillImportActionPerformed(evt);
            }
        });

        btnSuccessBillImport.setText("Xuất hóa đơn");
        btnSuccessBillImport.setEnabled(false);
        btnSuccessBillImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuccessBillImportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jplBillImportLayout = new javax.swing.GroupLayout(jplBillImport);
        jplBillImport.setLayout(jplBillImportLayout);
        jplBillImportLayout.setHorizontalGroup(
            jplBillImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplBillImportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                .addGap(212, 212, 212))
            .addGroup(jplBillImportLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jplBillImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jplBillImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbCarrierBillImport, 0, 168, Short.MAX_VALUE)
                    .addComponent(cbProduct, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbSupplier, 0, 168, Short.MAX_VALUE)
                    .addComponent(txtPriceProduct)
                    .addComponent(txtCountProduct))
                .addGap(141, 141, 141)
                .addGroup(jplBillImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSuccessBillImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddBillImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditBillImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteBillImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnResetBillImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFindBillImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jplBillImportLayout.setVerticalGroup(
            jplBillImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplBillImportLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jplBillImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddBillImport, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jplBillImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditBillImport, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jplBillImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteBillImport, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCountProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 19, Short.MAX_VALUE)
                .addGroup(jplBillImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(btnFindBillImport, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(txtPriceProduct))
                .addGap(20, 20, 20)
                .addGroup(jplBillImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCarrierBillImport, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetBillImport, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSuccessBillImport, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(358, Short.MAX_VALUE))
        );

        jplBillManage.addTab("Hóa đơn nhập", jplBillImport);

        jTabbedPane1.addTab("Quản lý hóa đơn", jplBillManage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1093, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectImgActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // chỉ hiện thị file
        int returnValue = fileChooser.showOpenDialog(this);
        if(returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            // lấy đường dẫn file
            String pathFile = file.getAbsolutePath();
            String[] str_arr=pathFile.replaceAll(Pattern.quote("\\"), "\\\\").split("\\\\"); //chuyển dấu \ -> \\ và cắt chuỗi bởi dấu \\
            String pathLink = "../" + str_arr[str_arr.length - 2] + "/" + str_arr[str_arr.length - 1];
            System.out.println(pathLink);
            BufferedImage b;
            try {
                b = ImageIO.read(file);
                jlbThumbProduct.setIcon(new ImageIcon(b.getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
                txtThumbProduct.setText(pathLink);
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnSelectImgActionPerformed

    private void boxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxCategoryActionPerformed

    private void btnUpdateProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProductActionPerformed
        // TODO add your handling code here:

        String tenSP = null, danhmuc = null, gia = null, mota = null, hinhanh = null;
        int id_Cat = 0;
        boolean isOK = true;
        int selectedIndex = tableProduct.getSelectedRow();
        if(selectedIndex >= 0) {
            Product prd1 = products.get(selectedIndex);

            if(txtTitleProduct.getText().length() > 0) {
                tenSP = txtTitleProduct.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập tên sản phẩm");
            }

            danhmuc = boxCategory.getSelectedItem().toString();
            for(Category category : categoryList) {
                if(category.getName().equals(danhmuc)) {
                    id_Cat = category.getId();
                }
            }

            if(txtPrice.getText().length() > 0) {
                gia = txtPrice.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập giá sản phẩm");
            }

            if(txtDescProduct.getText().length() > 0) {
                mota = txtDescProduct.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập mô tả sản phẩm");
            }

            if(txtThumbProduct.getText().length() > 0) {
                hinhanh = txtThumbProduct.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập hình ảnh sản phẩm");
            }

            if(isOK) {
                Date dateNow = new Date();
                SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Product product = new Product(prd1.getId(), tenSP, gia, mota, hinhanh, formatDate.format(dateNow), id_Cat);
                ProductController.update(product);
                JOptionPane.showMessageDialog(rootPane, "Bạn đã cập nhật thành công!");
                txtTitleProduct.setText("");
                txtPrice.setText("");
                txtDescProduct.setText("");
                txtThumbProduct.setText("");
                btnUpdateProduct.setEnabled(false);
                btnDeleteProduct.setEnabled(false);
                showProduct();
            }
        }
    }//GEN-LAST:event_btnUpdateProductActionPerformed

    private void btnFindProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindProductActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(this,"Nhập tên sản phẩm cần tìm kiếm!");
        if(input != null && input.length() > 0 ){
            products = ProductController.findByTitleProduct(input);

            tableModelProduct.setRowCount(0);
            products.forEach((product) -> {
                tableModelProduct.addRow(new Object[] {tableModelProduct.getRowCount() + 1,
                    product.getTitle(),
                    product.getCategoryName(),
                    product.getPrice(),
                    product.getDescription(),
                    product.getThumbnail(),
                    product.getCreated_at(),
                    product.getUpdated_at()});
        });
        } else {
            showProduct();
        }
    }//GEN-LAST:event_btnFindProductActionPerformed

    private void btnResetProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetProductActionPerformed
        txtTitleProduct.setText("");
        txtPrice.setText("");
        txtDescProduct.setText("");
        jlbThumbProduct.setText("");

        btnUpdateProduct.setEnabled(false);
        btnDeleteProduct.setEnabled(false);
        showProduct();
    }//GEN-LAST:event_btnResetProductActionPerformed

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tableProduct.getSelectedRow();
        if (selectedIndex >= 0 ){
            Product prd = products.get(selectedIndex);

            int option = JOptionPane.showConfirmDialog(this, "Ban co chac chan muon xoa?");

            if(option == 0){
                ProductController.delete(prd.getId());

                btnDeleteProduct.setEnabled(false);
                JOptionPane.showMessageDialog(rootPane, "Bạn đã xóa thành công");
                showProduct();
            }
        }
    }//GEN-LAST:event_btnDeleteProductActionPerformed

    private void btnInsertProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertProductActionPerformed
        // TODO add your handling code here:
        String title = txtTitleProduct.getText();
        Category category = categoryList.get(boxCategory.getSelectedIndex());
        int idCat = category.getId();
        String price = txtPrice.getText();
        String description = txtDescProduct.getText();
        String thumbnail = txtThumbProduct.getText();
        Date dateNow = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Product prd = new Product(title, price, description, thumbnail, formatDate.format(dateNow), formatDate.format(dateNow), idCat, 0);

        ProductController.insert(prd);

        txtTitleProduct.setText("");
        txtPrice.setText("");
        txtDescProduct.setText("");
        jlbThumbProduct.setText("");

        btnUpdateProduct.setEnabled(false);
        btnDeleteProduct.setEnabled(false);
        showProduct();
    }//GEN-LAST:event_btnInsertProductActionPerformed

    private void btnResetStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetStaffActionPerformed
        // TODO add your handling code here:
        txtFullname.setText("");
        txtEmail.setText("");
        txtPhonenumber.setText("");
        txtAddress.setText("");
        txtPassword.setText("");

        btnUpdateStaff.setEnabled(false);
        showStaff();
    }//GEN-LAST:event_btnResetStaffActionPerformed

    private void btnFindStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindStaffActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(this,"Nhap ten nguoi dung can tim kiem!");
        if(input != null && input.length() > 0 ){
            staffList = UserController.findByFullnameUser(input);

            tableModelUser.setRowCount(0);
            staffList.forEach((user) -> {
                tableModelUser.addRow(new Object[] {tableModelUser.getRowCount() + 1,
                    user.getFullname(),
                    user.getEmail(),
                    user.getPhoneNumber(),
                    user.getAddress(),
                    user.getRoleName(),
                    user.getCreated_at(),
                    user.getUpdated_at()});
        });
        } else {
            showStaff();
        }
    }//GEN-LAST:event_btnFindStaffActionPerformed

    private void btnUpdateStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStaffActionPerformed
        // TODO add your handling code here:

        String fullname = null, gender = null, email = null, phoneNumber = null,
                address = null, password = null, roleName = null;
        int idRole = 0, status = 0;
        boolean isOK = true;
        int selectedIndex = tableStaff.getSelectedRow();
        if(selectedIndex >= 0) {
            User userFind = staffList.get(selectedIndex);

            if(txtFullname.getText().length() > 0) {
                fullname = txtFullname.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập tên");
            }

            gender = boxGender.getSelectedItem().toString();
        
            if(txtEmail.getText().length() > 0) {
                email = txtEmail.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập Email!!");
            }

            if(txtPhonenumber.getText().length() > 0) {
                phoneNumber = txtPhonenumber.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập so dien thoai");
            }

            if(txtAddress.getText().length() > 0) {
                address = txtAddress.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập địa chỉ");
            }
            
            roleName = boxRole.getSelectedItem().toString();
            for(Role role : roleList) {
                if(role.getName().equals(roleName)) {
                    idRole = role.getId();
                }
            }

            if(txtPassword.getPassword().length > 0) {
                password = new String(txtPassword.getPassword());
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập mật khẩu");
            }
            
            status = cbStatusStaff.getSelectedIndex();
            
            

            if(isOK) {
                Date dateNow = new Date();
                SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                User user = new User(userFind.getId(), fullname, email, phoneNumber, address, password, formatDate.format(dateNow), gender, idRole, status);

                UserController.update(user);
                JOptionPane.showMessageDialog(rootPane, "Bạn đã cập nhật thành công!");
            }
        }

        txtFullname.setText("");
        txtEmail.setText("");
        txtPhonenumber.setText("");
        txtAddress.setText("");
        txtPassword.setText("");

        btnUpdateStaff.setEnabled(false);
        showStaff();
        showComboBox_Carrier();
    }//GEN-LAST:event_btnUpdateStaffActionPerformed

    private void btnInsertStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertStaffActionPerformed
        // TODO add your handling code here:
        int idRole = 0;
        String fullname = null, gender = null, email = null, phoneNumber = null, 
                address = null, roleName = null, password = null;
        boolean isOK = true;
        if(txtFullname.getText().length() > 0) {
                fullname = txtFullname.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập tên");
            }

            gender = boxGender.getSelectedItem().toString();
        
            if(txtEmail.getText().length() > 0) {
                email = txtEmail.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập Email!!");
            }

            if(txtPhonenumber.getText().length() > 0) {
                phoneNumber = txtPhonenumber.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập so dien thoai");
            }

            if(txtAddress.getText().length() > 0) {
                address = txtAddress.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập địa chỉ");
            }
            
            roleName = boxRole.getSelectedItem().toString();
            for(Role role : roleList) {
                if(role.getName().equals(roleName)) {
                    idRole = role.getId();
                }
            }

            if(txtPassword.getPassword().length > 0) {
                password = new String(txtPassword.getPassword());
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập mật khẩu");
            }
        
        if(isOK) {
                Date dateNow = new Date();
                SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                User user = new User(fullname, email, phoneNumber, address, password, formatDate.format(dateNow), formatDate.format(dateNow), gender, idRole, 0);

                UserController.insert(user);
                JOptionPane.showMessageDialog(rootPane, "Bạn đã cập nhật thành công!");
                
                txtFullname.setText("");
                boxGender.setSelectedIndex(0);
                txtEmail.setText("");
                txtPhonenumber.setText("");
                txtAddress.setText("");
                boxRole.setSelectedIndex(0);
                txtPassword.setText("");

                btnUpdateStaff.setEnabled(false);
                showStaff();
                showComboBox_Carrier();
            }
    }//GEN-LAST:event_btnInsertStaffActionPerformed

    private void boxGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxGenderActionPerformed

    private void boxRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxRoleActionPerformed

    private void btnDeleteOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteOrderActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tableOrder.getSelectedRow();
        if (selectedIndex >= 0 ){
            Order order = orderList.get(selectedIndex);

            int option = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn muốn xóa không?");

            if(option == 0){
                OrderController.delete(order.getId());

                txtFullnameOrder.setText("");
                txtEmailOrder.setText("");
                txtPhoneNumberOrder.setText("");
                txtAddressOrder.setText("");
                txtNoteOrder.setText("");

                btnDeleteOrder.setEnabled(false);
                JOptionPane.showMessageDialog(rootPane, "Bạn đã xóa thành công");
                showOrder();
            }
        }
    }//GEN-LAST:event_btnDeleteOrderActionPerformed

    private void btnShowProductOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowProductOrderActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tableOrder.getSelectedRow();
        if(selectedIndex >= 0) {
            Order order = orderList.get(selectedIndex);
            orderProductFrm = new OrderProductFrm(this, rootPaneCheckingEnabled);
            orderProductFrm.getUser_id(order);
            orderProductFrm.setVisible(true);
            showOrder();
        }
    }//GEN-LAST:event_btnShowProductOrderActionPerformed

    private void btnFindOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindOrderActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(this,"Nhập tên khách hàng cần tìm kiếm!");
        if(input != null && input.length() > 0 ){
            orderList = OrderController.findByFullnameOrder(input);

            tableModelOrder.setRowCount(0);
            orderList.forEach((order) -> {
                tableModelOrder.addRow(new Object[] {tableModelOrder.getRowCount() + 1,
                    order.getFullname(),
                    order.getEmail(),
                    order.getPhoneNumber(),
                    order.getAddress(),
                    order.getNote(),
                    order.getTotalMoney(),
                    order.getCreateTime()});
        });
        } else {
            showOrder();
        }
    }//GEN-LAST:event_btnFindOrderActionPerformed

    private void btnResetOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetOrderActionPerformed
        // TODO add your handling code here:
        txtFullnameOrder.setText("");
        txtEmailOrder.setText("");
        txtPhoneNumberOrder.setText("");
        txtAddressOrder.setText("");
        txtNoteOrder.setText("");

        btnDeleteOrder.setEnabled(false);
        btnShowProductOrder.setEnabled(false);
        showOrder();
    }//GEN-LAST:event_btnResetOrderActionPerformed

    private void txtPhoneNumberOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneNumberOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneNumberOrderActionPerformed

    private void btnCreateBillExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateBillExportActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tableOrder.getSelectedRow();
        if (selectedIndex >= 0){
            Order order = orderList.get(selectedIndex);
            if(order.getStatus() == 1) {
                JOptionPane.showMessageDialog(rootPane, "Hóa đơn này đã được xuất");
            }
            else {
                billExportFrm = new BillExportFrm(this, rootPaneCheckingEnabled);
                billExportFrm.showData(order, id_user);
                billExportFrm.setVisible(true);   
                txtFullnameOrder.setText("");
                txtEmailOrder.setText("");
                txtPhoneNumberOrder.setText("");
                txtAddressOrder.setText("");
                txtNoteOrder.setText("");

                btnCreateBillExport.setEnabled(false);
                btnDeleteOrder.setEnabled(false);
                showOrder();
                showBillExport();
            }
        }
    }//GEN-LAST:event_btnCreateBillExportActionPerformed

    private void btnFindCustomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindCustomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFindCustomActionPerformed

    private void btnFindResponseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindResponseActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(this,"Nhập tên khách hàng cần tìm kiếm: ");
        if(input != null && input.length() > 0 ){
            feedbackList = FeedBackController.findByFullnameUser(input);

            tableModelFeedback.setRowCount(0);
            feedbackList.forEach((feedback) -> {
                tableModelFeedback.addRow(new Object[] {tableModelFeedback.getRowCount() + 1,
                feedback.getEmail(),
                feedback.getFullname(),
                feedback.getPhoneNumber(),
                feedback.getAddress(),
                feedback.getNote(),
                feedback.getPhoneNumber(),
                feedback.getCreated_at()});
            });
        } else {
            showFeedback();
        }
    }//GEN-LAST:event_btnFindResponseActionPerformed

    private void txtSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupplierActionPerformed

    private void btnAddSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSupplierActionPerformed
        // TODO add your handling code here:
        String name = null, email = null, phoneNumber = null, 
                address = null;
        boolean isOK = true;
        if(txtSupplier.getText().length() > 0) {
                name = txtSupplier.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập tên");
            }
        
            if(txtEmailSupplier.getText().length() > 0) {
                email = txtEmailSupplier.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập Email!!");
            }

            if(txtPhoneSupplier.getText().length() > 0) {
                phoneNumber = txtPhoneSupplier.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập so dien thoai");
            }

            if(txtAddressSupplier.getText().length() > 0) {
                address = txtAddressSupplier.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập địa chỉ");
            }
                
            
        if(isOK) {
                Date dateNow = new Date();
                SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            
                Supplier supplier = new Supplier(name, phoneNumber, email, address, formatDate.format(dateNow), formatDate.format(dateNow));

                SupplierController.insert(supplier);
                JOptionPane.showMessageDialog(rootPane, "Bạn đã cập nhật thành công!");
                
                txtSupplier.setText("");
                txtEmailSupplier.setText("");
                txtPhoneSupplier.setText("");
                txtAddressSupplier.setText("");

                showSupplier();
                showComboBox_Supplier();
            }
    }//GEN-LAST:event_btnAddSupplierActionPerformed

    private void btnUpdateSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSupplierActionPerformed
        // TODO add your handling code here:
        String name = null, email = null, phoneNumber = null, 
                address = null;
        boolean isOK = true;
        int selectedIndex = tableSupplier.getSelectedRow();
        if(selectedIndex >= 0) {
            Supplier supplierFind = supplierList.get(selectedIndex);

            if(txtSupplier.getText().length() > 0) {
                name = txtSupplier.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập tên");
            }
        
            if(txtEmailSupplier.getText().length() > 0) {
                email = txtEmailSupplier.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập Email!!");
            }

            if(txtPhoneSupplier.getText().length() > 0) {
                phoneNumber = txtPhoneSupplier.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập SĐT");
            }

            if(txtAddressSupplier.getText().length() > 0) {
                address = txtAddressSupplier.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập địa chỉ");
            }
            

            if(isOK) {
                Date dateNow = new Date();
                SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Supplier supplier = new Supplier(supplierFind.getId(), name, phoneNumber, email, address, formatDate.format(dateNow));

                SupplierController.update(supplier);
                JOptionPane.showMessageDialog(rootPane, "Bạn đã cập nhật thành công!");
                
                txtSupplier.setText("");
                txtEmailSupplier.setText("");
                txtPhoneSupplier.setText("");
                txtAddressSupplier.setText("");
                
                btnUpdateSupplier.setEnabled(false);
                showSupplier();
                showComboBox_Supplier();
            }
        }
    }//GEN-LAST:event_btnUpdateSupplierActionPerformed

    private void btnResetSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetSupplierActionPerformed
        // TODO add your handling code here:
        txtSupplier.setText("");
        txtEmailSupplier.setText("");
        txtPhoneSupplier.setText("");
        txtAddressSupplier.setText("");

        btnUpdateSupplier.setEnabled(false);
        showSupplier();
    }//GEN-LAST:event_btnResetSupplierActionPerformed

    private void btnFindSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindSupplierActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(this,"Nhap ten nguoi dung can tim kiem!");
        if(input != null && input.length() > 0 ){
            supplierList = SupplierController.findByNameSupplier(input);

            tableModelSupplier.setRowCount(0);
        
            supplierList.forEach((supplier) -> {
                tableModelSupplier.addRow(new Object[] {tableModelSupplier.getRowCount() + 1,
                    supplier.getName(),
                    supplier.getPhoneNumber(),
                    supplier.getEmail(),
                    supplier.getAddress(),
                    supplier.getCreatedTime(),
                    supplier.getUpdatedTime()});
            });
        } else {
            showSupplier();
        }
    }//GEN-LAST:event_btnFindSupplierActionPerformed

    private void btnAddBillImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBillImportActionPerformed
        // TODO add your handling code here:
        int idSupplier = 0, idProduct = 0, idCarrier = 0, count = 0, price = 0, status = 0;
        
        boolean isOK = true;
        
        List<Supplier> supplierBill = new ArrayList<>();
        List<Product> productBill = new ArrayList<>();
        List<User> CarrierBill = new ArrayList<>();
        
        supplierBill = SupplierController.findAll();
        productBill = ProductController.findAll();
        CarrierBill = UserController.findAllCarrierOnWork();
        
        idSupplier = supplierBill.get(cbSupplier.getSelectedIndex()).getId();
        idProduct = productBill.get(cbProduct.getSelectedIndex()).getId();
        idCarrier = CarrierBill.get(cbCarrierBillImport.getSelectedIndex()).getId();
        if(txtCountProduct.getText().length() > 0) {
            count = Integer.valueOf(txtCountProduct.getText());
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập số lượng");
            isOK = false;
        }
        
        if(txtPriceProduct.getText().length() > 0) {
            price = Integer.valueOf(txtPriceProduct.getText());
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập giá");
            isOK = false;
        }
        
        
        if(isOK) {
            Date dateNow = new Date();
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            
            BillImport billImport = new BillImport(idProduct, count, id_user, idCarrier, 
                    idSupplier, price, status, formatDate.format(dateNow), formatDate.format(dateNow));
            
            BillImportController.insert(billImport);
            JOptionPane.showMessageDialog(rootPane, "Bạn đã thêm hóa đơn thành công");
            
            cbSupplier.setSelectedIndex(0);
            cbProduct.setSelectedIndex(0);
            txtPriceProduct.setText("");
            txtCountProduct.setText("");
            cbCarrierBillImport.setSelectedIndex(0);
         
            showBillImport();
        }
    }//GEN-LAST:event_btnAddBillImportActionPerformed

    private void btnEditBillImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditBillImportActionPerformed
        // TODO add your handling code here:
        int idSupplier = 0, idProduct = 0, idCarrier = 0, count = 0, price = 0;
        
        boolean isOK = true;
        
        List<Supplier> supplierBill = new ArrayList<>();
        List<Product> productBill = new ArrayList<>();
        List<User> CarrierBill = new ArrayList<>();
        
        supplierBill = SupplierController.findAll();
        productBill = ProductController.findAll();
        CarrierBill = UserController.findAllCarrierOnWork();
        int selectedIndex = tableBillImport.getSelectedRow();
        if(selectedIndex >= 0) {
            BillImport bill = billImportList.get(selectedIndex);
            
            idSupplier = supplierBill.get(cbSupplier.getSelectedIndex()).getId();
            idProduct = productBill.get(cbProduct.getSelectedIndex()).getId();
            idCarrier = CarrierBill.get(cbCarrierBillImport.getSelectedIndex()).getId();
            if(txtCountProduct.getText().length() > 0) {
                count = Integer.valueOf(txtCountProduct.getText());
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập số lượng");
                isOK = false;
            }

            if(txtPriceProduct.getText().length() > 0) {
                price = Integer.valueOf(txtPriceProduct.getText());
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập giá");
                isOK = false;
            }


            if(isOK) {
                Date dateNow = new Date();
                SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

                BillImport billImport = new BillImport(bill.getId(), idProduct, count, idCarrier, 
                        idSupplier, price, formatDate.format(dateNow));

                BillImportController.update(billImport);
                JOptionPane.showMessageDialog(rootPane, "Bạn đã sửa hóa đơn thành công");
                
                cbSupplier.setSelectedIndex(0);
                cbProduct.setSelectedIndex(0);
                txtPriceProduct.setText("");
                txtCountProduct.setText("");
                cbCarrierBillImport.setSelectedIndex(0);
                btnEditBillImport.setEnabled(false);
                btnDeleteBillImport.setEnabled(false);
                btnSuccessBillImport.setEnabled(false);
                
                
                showBillImport();
            }
        }
    }//GEN-LAST:event_btnEditBillImportActionPerformed

    private void btnDeleteBillImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBillImportActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tableBillImport.getSelectedRow();
        if (selectedIndex >= 0 ){
            BillImport billImport = billImportList.get(selectedIndex);

            int option = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn muốn xóa không?");

            if(option == 0){
                BillImportController.delete(billImport.getId());

                cbSupplier.setSelectedIndex(0);
                cbProduct.setSelectedIndex(0);
                txtPriceProduct.setText("");
                txtCountProduct.setText("");
                cbCarrierBillImport.setSelectedIndex(0);

                btnEditBillImport.setEnabled(false);
                btnDeleteBillImport.setEnabled(false);
                btnSuccessBillImport.setEnabled(false);
                JOptionPane.showMessageDialog(rootPane, "Bạn đã xóa thành công");
                showBillImport();
            }
        }
    }//GEN-LAST:event_btnDeleteBillImportActionPerformed

    private void btnFindBillImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindBillImportActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(this,"Nhập tên nhà cung cấp cần tìm kiếm!");
        if(input != null && input.length() > 0 ){
            billImportList = BillImportController.findByNameSupplier(input);

            tableModelBillImport.setRowCount(0);
        
            billImportList.forEach((billImport) -> {
                tableModelBillImport.addRow(new Object[] {tableModelBillImport.getRowCount() + 1,
                    billImport.getNameSupplier(),
                    billImport.getNameProduct(),
                    billImport.getCount(),
                    billImport.getPrice(),
                    billImport.getNameCarrier(),
                    billImport.getCreateTime(),
                    billImport.getNameCreateStaff(),
                    billImport.getStatus()
                });
            });
        } else {
            showBillImport();
        }
    }//GEN-LAST:event_btnFindBillImportActionPerformed

    private void btnResetBillImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetBillImportActionPerformed
        // TODO add your handling code here:
        cbSupplier.setSelectedIndex(0);
        cbProduct.setSelectedIndex(0);
        txtPriceProduct.setText("");
        txtCountProduct.setText("");
        cbCarrierBillImport.setSelectedIndex(0);
        btnEditBillImport.setEnabled(false);
        btnDeleteBillImport.setEnabled(false);


        showBillImport();
    }//GEN-LAST:event_btnResetBillImportActionPerformed

    private void btnSuccessBillImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuccessBillImportActionPerformed
        // TODO add your handling code here:
        int idSupplier = 0, idProduct = 0, idCarrier = 0, count = 0, price = 0, status = 0;
        
        boolean isOK = true;
        
        List<Supplier> supplierBill = new ArrayList<>();
        List<Product> productBill = new ArrayList<>();
        List<User> CarrierBill = new ArrayList<>();
        
        supplierBill = SupplierController.findAll();
        productBill = ProductController.findAll();
        CarrierBill = UserController.findAllCarrierOnWork();
        int selectedIndex = tableBillImport.getSelectedRow();
        if(selectedIndex >= 0) {
            BillImport bill = billImportList.get(selectedIndex);
            if(bill.getStatus() == 1) {
                JOptionPane.showMessageDialog(rootPane, "Đơn hàng đã được xuất");
            } else {
                idSupplier = supplierBill.get(cbSupplier.getSelectedIndex()).getId();
                idProduct = productBill.get(cbProduct.getSelectedIndex()).getId();
                idCarrier = CarrierBill.get(cbCarrierBillImport.getSelectedIndex()).getId();
                if(txtCountProduct.getText().length() > 0) {
                    count = Integer.valueOf(txtCountProduct.getText());
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập số lượng");
                    isOK = false;
                }

                if(txtPriceProduct.getText().length() > 0) {
                    price = Integer.valueOf(txtPriceProduct.getText());
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập giá");
                    isOK = false;
                }

                status = 1;


                if(isOK) {
                    Date dateNow = new Date();
                    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

                    BillImport billImport = new BillImport(bill.getId(), idProduct, count, idCarrier, 
                            idSupplier, price, status, formatDate.format(dateNow));

                    BillImportController.updateStatus(billImport);
                    JOptionPane.showMessageDialog(rootPane, "Bạn đã xuất hóa đơn thành công");

                    cbSupplier.setSelectedIndex(0);
                    cbProduct.setSelectedIndex(0);
                    txtPriceProduct.setText("");
                    txtCountProduct.setText("");
                    cbCarrierBillImport.setSelectedIndex(0);
                    btnEditBillImport.setEnabled(false);
                    btnDeleteBillImport.setEnabled(false);
                    btnSuccessBillImport.setEnabled(false);

                    showBillImport();
                    showProduct();
                }
            }
        }
        
    }//GEN-LAST:event_btnSuccessBillImportActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AppManager().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Category;
    private javax.swing.JLabel Desc;
    private javax.swing.JLabel Desc1;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Price;
    private javax.swing.JComboBox<String> boxCategory;
    private javax.swing.JComboBox<String> boxGender;
    private javax.swing.JComboBox<String> boxRole;
    private javax.swing.JButton btnAddBillImport;
    private javax.swing.JButton btnAddSupplier;
    private javax.swing.JButton btnCreateBillExport;
    private javax.swing.JButton btnDeleteBillImport;
    private javax.swing.JButton btnDeleteOrder;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnEditBillImport;
    private javax.swing.JButton btnFindBillImport;
    private javax.swing.JButton btnFindCustom;
    private javax.swing.JButton btnFindOrder;
    private javax.swing.JButton btnFindProduct;
    private javax.swing.JButton btnFindResponse;
    private javax.swing.JButton btnFindStaff;
    private javax.swing.JButton btnFindSupplier;
    private javax.swing.JButton btnInsertProduct;
    private javax.swing.JButton btnInsertStaff;
    private javax.swing.JButton btnResetBillImport;
    private javax.swing.JButton btnResetOrder;
    private javax.swing.JButton btnResetProduct;
    private javax.swing.JButton btnResetStaff;
    private javax.swing.JButton btnResetSupplier;
    private javax.swing.JButton btnSelectImg;
    private javax.swing.JButton btnShowProductOrder;
    private javax.swing.JButton btnSuccessBillImport;
    private javax.swing.JButton btnUpdateProduct;
    private javax.swing.JButton btnUpdateStaff;
    private javax.swing.JButton btnUpdateSupplier;
    private javax.swing.JComboBox<String> cbCarrierBillImport;
    private javax.swing.JComboBox<String> cbProduct;
    private javax.swing.JComboBox<String> cbStatusStaff;
    private javax.swing.JComboBox<String> cbSupplier;
    private javax.swing.JPanel infoProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlbEmail;
    private javax.swing.JLabel jlbGender;
    private javax.swing.JLabel jlbName;
    private javax.swing.JLabel jlbPhoneNumber;
    private javax.swing.JLabel jlbThumbProduct;
    private javax.swing.JPanel jplBill;
    private javax.swing.JPanel jplBillExport;
    private javax.swing.JPanel jplBillImport;
    private javax.swing.JTabbedPane jplBillManage;
    private javax.swing.JPanel jplGuest;
    private javax.swing.JPanel jplProduct;
    private javax.swing.JPanel jplResponse;
    private javax.swing.JPanel jplStaff;
    private javax.swing.JPanel jplStatistic;
    private javax.swing.JPanel jplSupplier;
    private javax.swing.JTable tableBillExport;
    private javax.swing.JTable tableBillImport;
    private javax.swing.JTable tableCustom;
    private javax.swing.JTable tableFeedback;
    private javax.swing.JTable tableOrder;
    private javax.swing.JTable tableProduct;
    private javax.swing.JTable tableStaff;
    private javax.swing.JTable tableSupplier;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAddressOrder;
    private javax.swing.JTextField txtAddressSupplier;
    private javax.swing.JTextField txtCountProduct;
    private javax.swing.JTextArea txtDescProduct;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmailOrder;
    private javax.swing.JTextField txtEmailSupplier;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtFullnameOrder;
    private javax.swing.JTextArea txtNoteOrder;
    private javax.swing.JScrollPane txtNoteOrder2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhoneNumberOrder;
    private javax.swing.JTextField txtPhoneSupplier;
    private javax.swing.JTextField txtPhonenumber;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtPriceProduct;
    private javax.swing.JTextField txtSupplier;
    private javax.swing.JTextField txtThumbProduct;
    private javax.swing.JTextField txtTitleProduct;
    // End of variables declaration//GEN-END:variables

}
