/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milkbar.UI;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import milkbar.dao.OrderDAO;
import milkbar.dao.SubCategoryDAO;
import milkbar.model.Order;
import milkbar.model.SubCategory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author ali.ashique
 */
public class Reports extends javax.swing.JInternalFrame {

    public Reports() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dtChFrom = new com.toedter.calendar.JDateChooser();
        dtChTo = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reports", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("American Typewriter", 0, 18))); // NOI18N

        dtChFrom.setDate(new Date());
        dtChFrom.setDateFormatString("dd-MMM-yy");

        dtChTo.setDate(new Date());
        dtChTo.setDateFormatString("dd-MMM-yy");

        jLabel1.setText("From*");

        jLabel2.setText("To*");

        jButton1.setText("Show");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Save Excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Category", "Sub Category", "Qunatity", "Price", "Order Date time", "Order Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblResult);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtChFrom, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(dtChTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(244, 244, 244))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dtChFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dtChTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Date from = dtChFrom.getDate();
        Date to = dtChTo.getDate();
        Timestamp fromTimestamp = new Timestamp(from.getTime());
        Timestamp toTimestamp = new Timestamp(to.getTime());
        List<Order> orders = OrderDAO.getOrders(fromTimestamp, toTimestamp);
        loadTable(orders);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Select Location");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        //    
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//            System.out.println("getCurrentDirectory(): "
//                    + chooser.getCurrentDirectory());
            Date from = dtChFrom.getDate();
            Date to = dtChTo.getDate();
            Timestamp fromTimestamp = new Timestamp(from.getTime());
            Timestamp toTimestamp = new Timestamp(to.getTime());
            
            int totalOrdersPriceSum=0,gstSum=0,otherTaxSum=0,discountSum=0,subTotalSum=0;
            int totalOrder=0;
            
            List<Order> orders = OrderDAO.getGroupedOrders(fromTimestamp, toTimestamp);

            Workbook workbook = new HSSFWorkbook();
            Sheet sheet = workbook.createSheet("Orders");
            Row row0 = sheet.createRow(0);
            row0.createCell(0).setCellValue("From");
            row0.createCell(1).setCellValue(from.toString());
            Row row1 = sheet.createRow(1);
            row1.createCell(0).setCellValue("To");
            row1.createCell(1).setCellValue(to.toString());
            
            Row rowHeading = sheet.createRow(3);
            rowHeading.createCell(1).setCellValue("Order Number");
            rowHeading.createCell(2).setCellValue("Table");
            rowHeading.createCell(3).setCellValue("Order Date");
            List<SubCategory> findAll = SubCategoryDAO.findAll();
            int [] subCategoryQntySum=new int[findAll.size()];
            Map<String,Integer> subCategoriesMap=new HashMap<>();
            
            for (int i = 0; i < findAll.size(); i++) {
                rowHeading.createCell(i+4).setCellValue(findAll.get(i).getName());
                subCategoriesMap.put(findAll.get(i).getName(), i+4);
            }
            rowHeading.createCell(findAll.size()+4).setCellValue("Sub Total");
            rowHeading.createCell(findAll.size()+5).setCellValue("GST");
            rowHeading.createCell(findAll.size()+6).setCellValue("Other Tax");
            rowHeading.createCell(findAll.size()+7).setCellValue("Discount");
            rowHeading.createCell(findAll.size()+8).setCellValue("Price");
            
            for (int i = 0; i < orders.size(); i++) {
                
                Row row = sheet.createRow(i+4);
                Order order = orders.get(i);
                row.createCell(1).setCellValue(i+1);
                row.createCell(2).setCellValue(order.getTable().getTableName() + "");
                row.createCell(3).setCellValue(order.getOrderDate() + "");
                List<Order> orders1 = OrderDAO.getOrders(order.getOrderCount());
                
                for (Order order1 : orders1) {
                    row.createCell(subCategoriesMap.get(order1.getSubCatName())).setCellValue(order1.getQuantity());
                    subCategoryQntySum[subCategoriesMap.get(order1.getSubCatName())-4]+=order1.getQuantity();
                }
                int subTotal=order.getPrice();
                double percentage=subTotal/100.0;
                int gst=(int)Math.floor(percentage*order.getGst());
                int otherTax=(int)Math.floor(percentage*order.getOtherTax());
                int discount=(int)Math.floor(percentage*order.getDiscount());
                int totalPrice=subTotal+gst+otherTax-discount;
                
                row.createCell(findAll.size()+4).setCellValue(subTotal);
                row.createCell(findAll.size()+5).setCellValue(gst);
                row.createCell(findAll.size()+6).setCellValue(otherTax);
                row.createCell(findAll.size()+7).setCellValue(discount);
                row.createCell(findAll.size()+8).setCellValue(totalPrice);
                
                subTotalSum+=subTotal;
                gstSum+=gst;
                otherTaxSum+=otherTax;
                discountSum+=discount;
                totalOrdersPriceSum+=totalPrice;
            }
            Row row = sheet.createRow(orders.size()+5);
            row.createCell(0).setCellValue("Total");
            for (int i = 0; i < findAll.size(); i++) {
                row.createCell(i+4).setCellValue(subCategoryQntySum[i]);
            }
//            row.createCell(findAll.size()+3).setCellValue("Total Price");
            
            
            row.createCell(findAll.size()+4).setCellValue(subTotalSum);
            row.createCell(findAll.size()+5).setCellValue(gstSum);
            row.createCell(findAll.size()+6).setCellValue(otherTaxSum);
            row.createCell(findAll.size()+7).setCellValue(discountSum);
            row.createCell(findAll.size()+8).setCellValue(totalOrdersPriceSum);
            Calendar fromCal = Calendar.getInstance();
            fromCal.setTime(from);
            LocalDate fromLocalDate=LocalDate.of(fromCal.get(Calendar.YEAR), fromCal.get(Calendar.MONDAY), fromCal.get(Calendar.DAY_OF_MONTH));
            Calendar toCal = Calendar.getInstance();
            toCal.setTime(to);
            LocalDate toLocalDate=LocalDate.of(toCal.get(Calendar.YEAR), toCal.get(Calendar.MONDAY), toCal.get(Calendar.DAY_OF_MONTH));
            try {
                workbook.write(new FileOutputStream(chooser.getSelectedFile() + "/"+fromLocalDate+" To "+toLocalDate+".xls"));
                //workbook.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("No Selection ");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void loadTable(List<Order> orders) {
        DefaultTableModel model = (DefaultTableModel) tblResult.getModel();
        model.setRowCount(0);
        orders.forEach(order -> {
            Object[] objects = new Object[7];
            objects[0] = order.getId();
            objects[1] = order.getCatName();
            objects[2] = order.getSubCatName();
            objects[3] = order.getQuantity();
            objects[4] = order.getPrice();
            objects[5] = order.getOrderDate();
            objects[6] = order.getOrderCount();
            model.addRow(objects);
        });
        tblResult.setModel(model);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dtChFrom;
    private com.toedter.calendar.JDateChooser dtChTo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResult;
    // End of variables declaration//GEN-END:variables
}
