package milkbar.UI;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import milkbar.dao.CategoryDAO;
import milkbar.dao.OrderDAO;
import milkbar.dao.SubCategoryDAO;
import milkbar.dao.TableDAO;
import milkbar.model.Category;
import milkbar.model.Order;
import milkbar.model.OrderType;
import milkbar.model.SubCategory;
import milkbar.model.Table;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class MainPortal extends javax.swing.JFrame {

    public MainPortal() {
        initComponents();
        loadCmbTable();
        loadCategoryTable(tblCategories);
        loadCmbOrderType();
    }

    private void loadCmbTable() {
        List<Table> tables = TableDAO.getAll();
        tables.forEach(table -> cmbTable.addItem(table));
    }

    public static void loadCategoryTable(JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        List<Category> categorys = CategoryDAO.findAll();
        categorys.forEach(c -> {
            Object[] data = new Object[1];

            //ImageIcon imageIcon = new ImageIcon(c.getIcon());
            //imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            //JLabel jLabel = new JLabel(imageIcon);
            //data[0] = jLabel;
            data[0] = c.getName();
            dtm.addRow(data);
        });

        table.setModel(dtm);
//        table.getColumn("Icon").setCellRenderer(new cellRender());
        //tblCategories.getColumnModel().getColumn(0).setCellRenderer(tblCategories.getDefaultRenderer(ImageIcon.class));
    }

    public static void loadSubCategoryTable(JTable table, String category) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        List<SubCategory> subCategorys = SubCategoryDAO.findByCatName(category);
        for (SubCategory c : subCategorys) {
            Object[] data = new Object[3];

            data[0] = c.getCategory().getName();
            data[1] = c.getName();
            data[2] = c.getPrice();
            dtm.addRow(data);
        }
        table.setModel(dtm);
        //tblCategories.getColumnModel().getColumn(0).setCellRenderer(tblCategories.getDefaultRenderer(ImageIcon.class));
    }

//    static class cellRender implements TableCellRenderer {
//
//        @Override
//        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//            TableColumn icon = table.getColumn("Icon");
//            //icon.setMinWidth(20);
//            icon.setPreferredWidth(5);
//            table.setRowHeight(20);
//
//            return (Component) value;
//        }
//
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnLoadOrders = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lblOrderTotalPrice = new javax.swing.JLabel();
        lblOrdersTotalQuantity = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dateTimeChFrom = new com.github.lgooddatepicker.components.DateTimePicker();
        dateTimeChTo = new com.github.lgooddatepicker.components.DateTimePicker();
        txtOrderNo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblSubCategories = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        spnQuantity = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        spnPrice = new javax.swing.JSpinner();
        btnSave = new javax.swing.JButton();
        btnKitchenInvoice = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmbTable = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnCustomerInvoice = new javax.swing.JButton();
        btnCart = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblTotalQuantity = new javax.swing.JLabel();
        lblTotalPrice = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        spnGst = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        spnDiscount = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        spnOtherTax = new javax.swing.JSpinner();
        lblSubTotal = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        spnPaid = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        lblRemainingPrice = new javax.swing.JLabel();
        lblRemainingPrice1 = new javax.swing.JLabel();
        chkEnablePaidRem = new javax.swing.JCheckBox();
        btnRefresh1 = new javax.swing.JButton();
        cmbOrderType = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategories = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        btnTgBtnCounter = new javax.swing.JToggleButton();
        lblShiftNo = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Next POS");
        setIconImage(new ImageIcon("logo.png").getImage());
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(null);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Orders", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("American Typewriter", 0, 14))); // NOI18N
        jPanel2.setOpaque(false);

        tblOrders.setAutoCreateRowSorter(true);
        tblOrders.setBackground(new java.awt.Color(255, 153, 51));
        tblOrders.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        tblOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order No.", "Order Type", "Table", "Date Time", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrdersMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblOrders);

        jLabel6.setText("From*");
        jLabel6.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N

        jLabel7.setText("To*");
        jLabel7.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N

        btnLoadOrders.setText("Show Orders");
        btnLoadOrders.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        btnLoadOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadOrdersActionPerformed(evt);
            }
        });

        jLabel10.setText("Total Price=");

        lblOrderTotalPrice.setText("0");

        lblOrdersTotalQuantity.setText("0");

        jLabel11.setText("Total Orders=");

        dateTimeChFrom.setDateTimePermissive(java.time.LocalDateTime.now());
        dateTimeChFrom.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N

        dateTimeChTo.setDateTimePermissive(java.time.LocalDateTime.now());
        dateTimeChTo.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N

        txtOrderNo.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        txtOrderNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrderNoActionPerformed(evt);
            }
        });

        jButton1.setText("Scan");
        jButton1.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOrdersTotalQuantity)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOrderTotalPrice))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLoadOrders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateTimeChTo, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                    .addComponent(dateTimeChFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtOrderNo, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateTimeChFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateTimeChTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoadOrders)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOrderNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(lblOrdersTotalQuantity)
                    .addComponent(lblOrderTotalPrice)))
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sub Categories", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("American Typewriter", 0, 14))); // NOI18N
        jPanel6.setOpaque(false);

        tblSubCategories.setAutoCreateRowSorter(true);
        tblSubCategories.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSubCategories.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        tblSubCategories.setOpaque(false);
        tblSubCategories.setShowGrid(false);
        tblSubCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSubCategoriesMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblSubCategories);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7)
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milkbar/images/facebook_circle-512.png"))); // NOI18N
        jLabel15.setText("http://facebook.com/maitsolutions.company");
        jLabel15.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milkbar/images/Icon-Phone.png"))); // NOI18N
        jLabel17.setText("+923363066953  ,  +923073670189");
        jLabel17.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cart", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("American Typewriter", 0, 14))); // NOI18N

        jScrollPane3.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N

        tblCart.setAutoCreateRowSorter(true);
        tblCart.setBorder(null);
        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Table", "Category", "Sub Category", "Quantity", "Price", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCart.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        jScrollPane3.setViewportView(tblCart);

        spnQuantity.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel3.setText("Quantity*");
        jLabel3.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N

        jLabel4.setText("Price*");
        jLabel4.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N

        spnPrice.setEnabled(false);

        btnSave.setText("Save Order");
        btnSave.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnKitchenInvoice.setText("Kitchen Invoice");
        btnKitchenInvoice.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        btnKitchenInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKitchenInvoiceActionPerformed(evt);
            }
        });

        jLabel5.setText("Table*");
        jLabel5.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N

        cmbTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTableActionPerformed(evt);
            }
        });

        jButton3.setText("Delete From Cart");
        jButton3.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnRefresh.setText("Both Invoice");
        btnRefresh.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnCustomerInvoice.setText("Customer Invoice");
        btnCustomerInvoice.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        btnCustomerInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerInvoiceActionPerformed(evt);
            }
        });

        btnCart.setText("Add To Cart");
        btnCart.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        btnCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartActionPerformed(evt);
            }
        });

        jLabel8.setText("Qunatity:");

        jLabel9.setText("Total Price=");

        jLabel1.setText("Clear Selection");
        jLabel1.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel12.setText("GST(%)");
        jLabel12.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N

        spnGst.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel13.setText("Discount(%)");
        jLabel13.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N

        spnDiscount.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel14.setText("Other Tax(%)");
        jLabel14.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N

        spnOtherTax.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel16.setText("Sub Total:");

        spnPaid.setModel(new javax.swing.SpinnerNumberModel());
        spnPaid.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnPaidStateChanged(evt);
            }
        });
        spnPaid.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                spnPaidPropertyChange(evt);
            }
        });

        jLabel18.setText("Paid*");
        jLabel18.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N

        lblRemainingPrice.setBackground(new java.awt.Color(0, 0, 0));
        lblRemainingPrice.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        lblRemainingPrice.setForeground(new java.awt.Color(255, 255, 255));
        lblRemainingPrice.setOpaque(true);

        lblRemainingPrice1.setText("Remaning*");
        lblRemainingPrice1.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N

        chkEnablePaidRem.setSelected(true);
        chkEnablePaidRem.setText("Enable Paid/Rem");
        chkEnablePaidRem.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        chkEnablePaidRem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEnablePaidRemActionPerformed(evt);
            }
        });

        btnRefresh1.setText("Refresh");
        btnRefresh1.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N
        btnRefresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresh1ActionPerformed(evt);
            }
        });

        cmbOrderType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dine in", "Take away" }));
        cmbOrderType.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N

        jLabel2.setText("Order Type*");
        jLabel2.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalQuantity)
                .addGap(17, 17, 17)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalPrice))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spnGst, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(spnDiscount))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spnOtherTax, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTable, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnPrice))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRemainingPrice1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRemainingPrice)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(chkEnablePaidRem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbOrderType, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnKitchenInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCustomerInvoice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap()))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnRefresh1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKitchenInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCustomerInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnGst, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnOtherTax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkEnablePaidRem)
                            .addComponent(cmbOrderType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(spnPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18)
                                .addComponent(lblRemainingPrice1))
                            .addComponent(lblRemainingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCart, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblTotalPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTotalQuantity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categories", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("American Typewriter", 0, 14))); // NOI18N

        jScrollPane1.setFont(new java.awt.Font("American Typewriter", 0, 12)); // NOI18N

        tblCategories.setAutoCreateRowSorter(true);
        tblCategories.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCategories.setBackground(new java.awt.Color(204, 204, 204));
        tblCategories.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblCategories.setFont(new java.awt.Font("American Typewriter", 0, 14)); // NOI18N
        tblCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoriesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCategories);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnTgBtnCounter.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnTgBtnCounter.setText("Start Counter");
        btnTgBtnCounter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTgBtnCounterActionPerformed(evt);
            }
        });

        lblShiftNo.setText("000001");

        jLabel20.setText("SHIFT-");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(btnTgBtnCounter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblShiftNo))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnTgBtnCounter)
                .addComponent(lblShiftNo)
                .addComponent(jLabel20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoriesMouseClicked
        int row = tblCategories.getSelectedRow();
        if (row >= 0) {
            String catName = tblCategories.getValueAt(row, 0).toString();
            List<SubCategory> subCategorys = SubCategoryDAO.findByCatName(catName);
            loadSubCategories();
        }
    }//GEN-LAST:event_tblCategoriesMouseClicked

    private void loadSubCategories() {
        DefaultTableModel dtm = (DefaultTableModel) tblSubCategories.getModel();
        dtm.setRowCount(0);
        List<SubCategory> subCategorys = SubCategoryDAO.findByCatName(tblCategories.getValueAt(tblCategories.getSelectedRow(), 0).toString());
        for (SubCategory c : subCategorys) {
            Object[] data = new Object[1];
            data[0] = c;
            dtm.addRow(data);
        }
        tblSubCategories.setModel(dtm);
    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void loadCmbOrderType() {
        OrderType[] values = OrderType.values();
        cmbOrderType.removeAllItems();
        for (OrderType value : values) {
            cmbOrderType.addItem(value.toString());
        }
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new Login().setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        List<Order> orders = getOrders();
        int selectedRow = tblOrders.getSelectedRow();
        int paid = Integer.parseInt(spnPaid.getValue().toString());
        long totalPrice = Math.round(Double.valueOf(lblTotalPrice.getText()));
        if (paid == totalPrice || paid > totalPrice) {
            if (tblOrders.isRowSelected(selectedRow)) {
                long orderCount = Long.valueOf(tblOrders.getValueAt(selectedRow, 0).toString());
                int showInternalConfirmDialog = JOptionPane.showConfirmDialog(rootPane, "Do You Want To Update Order No:" + orderCount, "Message", JOptionPane.YES_NO_OPTION);
                if (JOptionPane.YES_OPTION == showInternalConfirmDialog) {
                    List<Order> beforeUpdatedOrders = OrderDAO.getOrders(orderCount);
                    getDelOrders(beforeUpdatedOrders, orders).forEach(System.out::println);
                    OrderDAO.deleteByOrderCount(orderCount);
                    if (orders.size() > 0) {
                        orders.forEach((order) -> {
                            OrderDAO.save(order);
                        });
                        refresh();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Empty Cart");
                    }

                }
            } else {
                if (orders.size() > 0) {
                    orders.forEach((order) -> {
                        OrderDAO.save(order);
                    });
                    refresh();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Empty Cart");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Paid Amount is Less than total Price");
        }


    }//GEN-LAST:event_btnSaveActionPerformed

    private List<Order> getDelOrders(List<Order> originalOrders, List<Order> newOrders) {
        List<Order> orders = new LinkedList<>();

        originalOrders.forEach((originalOrder) -> {
            Boolean isDel = Boolean.FALSE;
            for (Order newOrder : newOrders) {
                if (originalOrder.getSubCatName().equals(newOrder.getSubCatName()) && originalOrder.getQuantity() > newOrder.getQuantity()) {
                    int delQunatity = originalOrder.getQuantity() - newOrder.getQuantity();
                    originalOrder.setQuantity(delQunatity);
                    orders.add(originalOrder);
                    System.out.println(originalOrder.getQuantity() + "-----" + newOrder.getQuantity());
                    isDel = Boolean.FALSE;
                    break;
                } else if (originalOrder.getSubCatName().equals(newOrder.getSubCatName()) && originalOrder.getQuantity() <= newOrder.getQuantity()) {
                    isDel = Boolean.FALSE;
                    break;
                }
                isDel = Boolean.TRUE;
            }

            if (isDel) {
                orders.add(originalOrder);
            }

        });
        return orders;
    }

    private void loadTotalCartQntyPrice() {
        List<Order> orders = getOrders();
        int quantity = 0;
        int subTotal = 0;
        int gst = Integer.parseInt(spnGst.getValue().toString());
        int discount = Integer.parseInt(spnDiscount.getValue().toString());
        int otherTax = Integer.parseInt(spnOtherTax.getValue().toString());
        for (Order order : orders) {
            quantity += order.getQuantity();
            subTotal += order.getQuantity() * order.getPrice();
        }
        double percentage = subTotal / 100.0;
        String totalPrice = Math.floor(subTotal + percentage * gst + otherTax * percentage - percentage * discount) + "";
        lblSubTotal.setText(subTotal + "");
        lblTotalQuantity.setText(quantity + "");
        lblTotalPrice.setText(totalPrice);
        spnPaid.setValue(Math.round(Double.valueOf(totalPrice)));
    }

    private void cmbTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTableActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int[] selectedRows = tblCart.getSelectedRows();

        if (selectedRows.length > 0) {

            DefaultTableModel dtm = (DefaultTableModel) tblCart.getModel();
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                dtm.removeRow(selectedRows[i]);
            }
            tblCart.setModel(dtm);
            loadTotalCartQntyPrice();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnKitchenInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKitchenInvoiceActionPerformed
        int[] selectedRows = Optional.ofNullable(tblCart.getSelectedRows()).orElse(new int[0]);
        if (selectedRows.length > 0) {
            List<Order> orders = getCartOrders(selectedRows);

            if (orders.size() > 0) {
                orders.add(0, new Order());
                kitchenInvoice(orders);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Empty Cart");
            }
        } else {
            List<Order> orders = getOrders();
            orders.add(0, new Order());
            kitchenInvoice(orders);
        }

    }//GEN-LAST:event_btnKitchenInvoiceActionPerformed

    private void btnLoadOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadOrdersActionPerformed
        loadOrdersTbl();
    }//GEN-LAST:event_btnLoadOrdersActionPerformed

    private void tblOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrdersMouseClicked

        int selectedRow = tblOrders.getSelectedRow();

        if (selectedRow >= 0) {
            long orderCount = Integer.valueOf(tblOrders.getValueAt(selectedRow, 0).toString());
            Timestamp now = (Timestamp) tblOrders.getValueAt(selectedRow, 3);

            List<Order> orders = OrderDAO.getOrders(orderCount);
            setCmbOrderType(orders.get(0).getOrderType().toString());
            loadCarTable(orders);
            loadTotalCartQntyPrice();
        } else {
            JOptionPane.showInternalMessageDialog(rootPane, "Select Order");
        }

    }//GEN-LAST:event_tblOrdersMouseClicked
    private void setCmbOrderType(String orderType) {
        for (int i = 0; i < cmbOrderType.getItemCount(); i++) {
            if (cmbOrderType.getItemAt(i).equalsIgnoreCase(orderType)) {
                cmbOrderType.setSelectedIndex(i);
                break;
            }
        }
    }
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        btnCustomerInvoiceActionPerformed(evt);
        btnKitchenInvoiceActionPerformed(evt);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void refresh() {
        tblCategories.clearSelection();
        cmbTable.setSelectedIndex(0);
        ((DefaultTableModel) tblSubCategories.getModel()).setRowCount(0);
        spnPrice.setValue(0);
        spnQuantity.setValue(1);
        spnDiscount.setValue(0);
        spnGst.setValue(0);
        spnOtherTax.setValue(0);
        spnPaid.setValue(0);
        lblRemainingPrice.setText("0");

        ((DefaultTableModel) tblCart.getModel()).setRowCount(0);
        tblOrders.clearSelection();

        loadOrdersTbl();
        loadTotalCartQntyPrice();
    }

    private void btnCustomerInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerInvoiceActionPerformed
        int paid = Integer.parseInt(spnPaid.getValue().toString());
        long totalPrice = Math.round(Double.valueOf(lblTotalPrice.getText()));
        if (paid == totalPrice || paid > totalPrice) {
            List<Order> orders = getOrders();
            int subTotal, netBill;

            if (orders.size() > 0) {
                int gst = Integer.parseInt(spnGst.getValue().toString());
                int discount = Integer.parseInt(spnDiscount.getValue().toString());
                int otherTax = Integer.parseInt(spnOtherTax.getValue().toString());

                long orderNo = orders.get(0).getOrderCount();
                subTotal = (int) Math.floor(Double.valueOf(lblSubTotal.getText()));
                double percentage = subTotal / 100.0;
                netBill = (int) Math.floor(subTotal + percentage * gst + otherTax * percentage - percentage * discount);
                orders.add(0, new Order());
                try {
                    printCustomerReceipt(orders, subTotal, netBill, orderNo);
                } catch (IOException ex) {
                    Logger.getLogger(MainPortal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Empty Cart");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Paid Amount is Less than total Price");
        }
    }//GEN-LAST:event_btnCustomerInvoiceActionPerformed

    private void btnCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCartActionPerformed
        int row = tblSubCategories.getSelectedRow();
        if (row >= 0) {

            SubCategory subCategory = (SubCategory) tblSubCategories.getValueAt(row, 0);
            Table table = (Table) cmbTable.getSelectedItem();

            int qunatity = Integer.valueOf(spnQuantity.getValue().toString());
            loadCarTable(subCategory, qunatity, table);
            spnQuantity.setValue(1);
            spnPrice.setValue(0);
            tblSubCategories.clearSelection();
            loadTotalCartQntyPrice();
        }

    }//GEN-LAST:event_btnCartActionPerformed

    private void tblSubCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSubCategoriesMouseClicked
        int row = tblSubCategories.getSelectedRow();
        if (row >= 0) {
            SubCategory selectedItem = (SubCategory) tblSubCategories.getValueAt(row, 0);
            spnPrice.setValue(selectedItem.getPrice());
        }
    }//GEN-LAST:event_tblSubCategoriesMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        tblCart.clearSelection();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void spnPaidStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnPaidStateChanged

        long totalPrice = Math.round(Double.valueOf(lblTotalPrice.getText().equals("") ? "0" : lblTotalPrice.getText()));
        int paid = Integer.parseInt(spnPaid.getValue().toString());
        lblRemainingPrice.setText((paid - totalPrice) + "");
    }//GEN-LAST:event_spnPaidStateChanged

    private void spnPaidPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_spnPaidPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_spnPaidPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        long orderNo = Long.valueOf(txtOrderNo.getText());
        List<Order> orders = OrderDAO.getOrders(orderNo);
        dateTimeChFrom.setDateTimePermissive(orders.get(0).getOrderDate().toLocalDateTime());
        btnLoadOrdersActionPerformed(evt);
        for (int i = 0; i < tblOrders.getRowCount(); i++) {
            Integer orderNoTbl = Integer.valueOf(tblOrders.getValueAt(i, 0).toString());
            if (orderNoTbl == orderNo) {
                tblOrders.setRowSelectionInterval(i, i);
                tblOrdersMouseClicked(null);
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void chkEnablePaidRemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEnablePaidRemActionPerformed
        if (chkEnablePaidRem.isSelected()) {
            spnPaid.setEnabled(true);
        } else {
            spnPaid.setEnabled(false);
        }
    }//GEN-LAST:event_chkEnablePaidRemActionPerformed

    private void btnRefresh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresh1ActionPerformed
        refresh();
    }//GEN-LAST:event_btnRefresh1ActionPerformed

    private void txtOrderNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderNoActionPerformed
        String text = txtOrderNo.getText();
        String newTextString = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != '0') {
                newTextString = text.substring(i);
                break;
            }
        }
        txtOrderNo.setText(newTextString);
    }//GEN-LAST:event_txtOrderNoActionPerformed

    private void btnTgBtnCounterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTgBtnCounterActionPerformed
        if (btnTgBtnCounter.isSelected()) {
            btnTgBtnCounter.setText("Counter Started");
            File f;
        try {
            f = new File(COUNTER_INFO_FILE_NAME);
            f.createNewFile();
        } catch ( IOException ex) {
            Logger.getLogger(MainPortal.class.getName()).log(Level.SEVERE, null, ex);
        }
        } else {
            btnTgBtnCounter.setText("Start Counter");
            try {
                isCounterClosed();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainPortal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnTgBtnCounterActionPerformed
    private void loadOrdersTbl() {
        Timestamp fromTimestamp = Timestamp.valueOf(dateTimeChFrom.getDateTimePermissive());
        Timestamp toTimestamp = Timestamp.valueOf(dateTimeChTo.getDateTimePermissive());

        List<Order> groupedOrders = OrderDAO.getGroupedOrders(fromTimestamp, toTimestamp);

        DefaultTableModel dtm = (DefaultTableModel) tblOrders.getModel();
        dtm.setRowCount(0);
        long totalPrice = 0;
        for (Order groupedOrder : groupedOrders) {
            Object[] data = new Object[5];
            data[0] = groupedOrder.getOrderCount();
            data[1] = groupedOrder.getOrderType().toString();
            data[2] = groupedOrder.getTable().getTableName();
            data[3] = groupedOrder.getOrderDate();
            data[4] = groupedOrder.getPrice();
            totalPrice += groupedOrder.getPrice();
            dtm.addRow(data);
        }
        lblOrderTotalPrice.setText(totalPrice + "");
        lblOrdersTotalQuantity.setText(groupedOrders.size() + "");
        tblOrders.setModel(dtm);
    }

    private void printCustomerReceipt(List<Order> orders, int subTotal, int netBill, long orderNumber) throws IOException {
        JasperReport compileReport;
        try {
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("subTotal", subTotal + "");
            dataMap.put("netBill", netBill + "");
            dataMap.put("orderNumber", orderNumber + "");
            dataMap.put("table", orders.get(1).getTable().getTableName());
            dataMap.put("gstLabel", "GST(" + orders.get(1).getGst() + "%):");
            dataMap.put("otherTaxLabel", "Other Tax(" + orders.get(1).getOtherTax() + "%):");
            dataMap.put("discountLabel", "Discount(" + orders.get(1).getDiscount() + "%):");

            dataMap.put("gst", Optional.ofNullable(orders.get(1).getGst() * Math.floor(subTotal / 100.0)).orElse(0.0) + "");
            dataMap.put("otherTax", Optional.ofNullable(orders.get(1).getOtherTax() * Math.floor(subTotal / 100.0)).orElse(0.0) + "");
            dataMap.put("discount", Optional.ofNullable(orders.get(1).getDiscount() * Math.floor(subTotal / 100.0)).orElse(0.0) + "");
            dataMap.put("invoiceNoBarcode", getInvoiceBarcodeNumber(orderNumber + ""));

            if (chkEnablePaidRem.isSelected()) {
                if (!spnPaid.getValue().toString().equals("0")) {
                    dataMap.put("paidByCash", "Paid By Cash:      " + spnPaid.getValue().toString());
                }
                if (Integer.parseInt(lblRemainingPrice.getText()) >= 0) {
                    dataMap.put("cashBack", "Cash back:         " + lblRemainingPrice.getText());
                }
            }
            JRBeanCollectionDataSource itemsBeanCollectionDataSource = new JRBeanCollectionDataSource(orders);
            dataMap.put("orderItems", itemsBeanCollectionDataSource);
            File f = new File("a.png");
            f.createNewFile();
            String path = new File("").getPath() + "invoice.jrxml";

            compileReport = JasperCompileManager.compileReport(path);
            JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, dataMap, itemsBeanCollectionDataSource);
            JasperViewer.viewReport(jasperPrint, false);
            //JasperPrintManager.printReport(jasperPrint, false);

        } catch (JRException ex) {
            Logger.getLogger(MainPortal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getInvoiceBarcodeNumber(String orderNo) {
        String newOrderNo = orderNo;
        for (int i = 0; i < 10 - orderNo.length(); i++) {
            newOrderNo = "0" + newOrderNo;
        }
        return newOrderNo;
    }

    private void kitchenInvoice(List<Order> orders) {
        if (orders.size() > 0) {
            JasperReport compileReport;
            try {
                Map<String, Object> dataMap = new HashMap<>();
                long orderNo = orders.get(1).getOrderCount();
                dataMap.put("orderNumber", orderNo + "");
                dataMap.put("table", orders.get(1).getTable().getTableName());
                JRBeanCollectionDataSource itemsBeanCollectionDataSource = new JRBeanCollectionDataSource(orders);
                dataMap.put("orderItems", itemsBeanCollectionDataSource);
                compileReport = JasperCompileManager.compileReport("kitcheninvoice.jrxml");
                JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, dataMap, itemsBeanCollectionDataSource);
                //preview of receipt
                JasperViewer.viewReport(jasperPrint, false);
                //direct print of receipt
                //JasperPrintManager.printReport(jasperPrint, false);
            } catch (JRException ex) {
                Logger.getLogger(MainPortal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Empty Cart");
        }
    }

    private void loadCarTable(SubCategory subCategory, int quantity, Table table) {
        boolean isFound = false;
        DefaultTableModel dtm = (DefaultTableModel) tblCart.getModel();

        for (int i = 0; i < tblCart.getRowCount(); i++) {
            String tableName = dtm.getValueAt(i, 0).toString();
            if (!table.getTableName().equals(tableName)) {
                dtm.setValueAt(table.getTableName(), i, 0);
            }
        }
        for (int i = 0; i < tblCart.getRowCount(); i++) {

            if (subCategory.getName().equals(tblCart.getValueAt(i, 2).toString())) {
                setTblCartValue(i, subCategory, quantity);
                isFound = true;
                break;
            }
        }
        if (!isFound) {

            Object[] row = new Object[6];
            row[0] = table.getTableName();
            row[1] = subCategory.getCategory().getName();
            row[2] = subCategory.getName();
            row[3] = quantity;
            row[4] = subCategory.getPrice();
            row[5] = subCategory.getPrice() * quantity;

            dtm.addRow(row);
            tblCart.setModel(dtm);
        }
    }

    private void loadCarTable(List<Order> orders) {
        boolean isFound = false;
        DefaultTableModel dtm = (DefaultTableModel) tblCart.getModel();
        dtm.setRowCount(0);
        Order orderForTax = orders.get(0);
        spnGst.setValue(orderForTax.getGst());
        spnOtherTax.setValue(orderForTax.getOtherTax());
        spnDiscount.setValue(orderForTax.getDiscount());
        for (Order order : orders) {
            Object[] row = new Object[6];

            row[0] = order.getTable().getTableName();
            row[1] = order.getCatName();
            row[2] = order.getSubCatName();
            row[3] = order.getQuantity();
            row[4] = order.getPrice();
            row[5] = order.getPrice() * order.getQuantity();

            dtm.addRow(row);
        }
        tblCart.setModel(dtm);
    }

    private List<Order> getOrders() {
        List<Order> orders = new LinkedList<>();
        int rows = tblCart.getRowCount();
        int tblOrderSelectedRow = tblOrders.getSelectedRow();
        long orderCount;
        Timestamp now;
        if (tblOrders.isRowSelected(tblOrderSelectedRow)) {
            orderCount = Integer.valueOf(tblOrders.getValueAt(tblOrderSelectedRow, 0).toString());
            now = (Timestamp) tblOrders.getValueAt(tblOrderSelectedRow, 3);
        } else {
            orderCount = OrderDAO.maxOrderCount() + 1;
            now = new Timestamp(new java.util.Date().getTime());
        }

        for (int i = 0; i < rows; i++) {

            String tableName = tblCart.getValueAt(i, 0).toString();
            String catName = tblCart.getValueAt(i, 1).toString();
            String subCatName = tblCart.getValueAt(i, 2).toString();
            int quantity = Integer.valueOf(tblCart.getValueAt(i, 3).toString());
            int price = Integer.valueOf(tblCart.getValueAt(i, 4).toString());
            int gst = Integer.parseInt(spnGst.getValue().toString());
            int discount = Integer.parseInt(spnDiscount.getValue().toString());
            int otherTax = Integer.parseInt(spnOtherTax.getValue().toString());
            String orderType = cmbOrderType.getSelectedItem().toString();
            Order order = new Order(0, catName, subCatName, quantity, price, now, orderCount, new Table(tableName), gst, otherTax, discount, null, 0);
            order.setOrderType(orderType);
            orders.add(order);
        }

        return orders;
    }

    private List<Order> getCartOrders(int[] selectedRows) {
        List<Order> orders = new LinkedList<>();
        int rows = tblCart.getRowCount();
        int tblOrderSelectedRow = tblOrders.getSelectedRow();
        long orderCount;
        Timestamp now;
        if (tblOrders.isRowSelected(tblOrderSelectedRow)) {
            orderCount = Integer.valueOf(tblOrders.getValueAt(tblOrderSelectedRow, 0).toString());
            now = (Timestamp) tblOrders.getValueAt(tblOrderSelectedRow, 3);
        } else {
            orderCount = OrderDAO.maxOrderCount() + 1;
            now = new Timestamp(new java.util.Date().getTime());
        }

        for (int i = 0; i < selectedRows.length; i++) {

            String tableName = tblCart.getValueAt(selectedRows[i], 0).toString();
            String catName = tblCart.getValueAt(selectedRows[i], 1).toString();
            String subCatName = tblCart.getValueAt(selectedRows[i], 2).toString();
            int quantity = Integer.valueOf(tblCart.getValueAt(selectedRows[i], 3).toString());
            int price = Integer.valueOf(tblCart.getValueAt(selectedRows[i], 4).toString());
            int gst = Integer.parseInt(spnGst.getValue().toString());
            int discount = Integer.parseInt(spnDiscount.getValue().toString());
            int otherTax = Integer.parseInt(spnOtherTax.getValue().toString());
            String orderType = cmbOrderType.getSelectedItem().toString();
            Order order = new Order(0, catName, subCatName, quantity, price, now, orderCount, new Table(tableName), gst, otherTax, discount, null, 0);
            order.setOrderType(orderType);
            orders.add(order);
        }
        return orders;
    }

    private void setTblCartValue(int rowInt, SubCategory subCategory, int quantity) {
        DefaultTableModel dtm = (DefaultTableModel) tblCart.getModel();
        dtm.setValueAt(quantity, rowInt, 3);
        dtm.setValueAt(subCategory.getPrice(), rowInt, 4);
        dtm.setValueAt(subCategory.getPrice() * quantity, rowInt, 5);
        tblCart.setModel(dtm);
    }
    private boolean isCounterClosed() throws FileNotFoundException{
        Scanner s=new Scanner(new File(COUNTER_INFO_FILE_NAME));
        return s.hasNextLine();
    }
    private long getShiftNo() throws FileNotFoundException{
        Scanner s=new Scanner(new File(COUNTER_INFO_FILE_NAME));
        return s.nextLong();
    }
    private void setShiftNoCounterStatus() throws FileNotFoundException{
        
        long shiftCount=0;
        if (isCounterClosed()) {
            shiftCount = OrderDAO.maxShiftCount()+1;
        }else{
            shiftCount=getShiftNo();
        }
         lblShiftNo.setText(String.format("%05d",shiftCount));
    }
    private final String COUNTER_INFO_FILE_NAME = "counter-info.txt";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCart;
    private javax.swing.JButton btnCustomerInvoice;
    private javax.swing.JButton btnKitchenInvoice;
    private javax.swing.JButton btnLoadOrders;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRefresh1;
    private javax.swing.JButton btnSave;
    private javax.swing.JToggleButton btnTgBtnCounter;
    private javax.swing.JCheckBox chkEnablePaidRem;
    private javax.swing.JComboBox<String> cmbOrderType;
    private javax.swing.JComboBox cmbTable;
    private com.github.lgooddatepicker.components.DateTimePicker dateTimeChFrom;
    private com.github.lgooddatepicker.components.DateTimePicker dateTimeChTo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblOrderTotalPrice;
    private javax.swing.JLabel lblOrdersTotalQuantity;
    private javax.swing.JLabel lblRemainingPrice;
    private javax.swing.JLabel lblRemainingPrice1;
    private javax.swing.JLabel lblShiftNo;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JLabel lblTotalQuantity;
    private javax.swing.JSpinner spnDiscount;
    private javax.swing.JSpinner spnGst;
    private javax.swing.JSpinner spnOtherTax;
    private javax.swing.JSpinner spnPaid;
    private javax.swing.JSpinner spnPrice;
    private javax.swing.JSpinner spnQuantity;
    private javax.swing.JTable tblCart;
    private javax.swing.JTable tblCategories;
    private javax.swing.JTable tblOrders;
    private javax.swing.JTable tblSubCategories;
    private javax.swing.JTextField txtOrderNo;
    // End of variables declaration//GEN-END:variables
}
