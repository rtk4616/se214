/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import java.util.Calendar;
import javax.swing.*;

/**
 *
 * @author Wizard
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        RoutineForm = new RoutineForm();
        
        Calendar dt = Calendar.getInstance();
        int year = dt.get(Calendar.YEAR);
        int month = (Integer)dt.get(Calendar.MONTH) + 1;
        YearSpinner.setModel(new SpinnerNumberModel(year, 1970, 2999, 1));
        MonthSpinner.setModel(new SpinnerNumberModel(month, 1, 12, 1));
        ShowCalendar();
    }

    private void ShowCalendar()
    {
        int year = (Integer)this.YearSpinner.getValue();
        int month = (Integer)this.MonthSpinner.getValue();
        CalendarManager cm = new CalendarManager();
        cm.SetDate(year, month);
        cm.Show(CalendarTable);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CalendarScrollPane = new javax.swing.JScrollPane();
        CalendarTable = new javax.swing.JTable();
        YearSpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        MonthSpinner = new javax.swing.JSpinner();
        SettingButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("日程管理");
        setResizable(false);

        CalendarTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CalendarTable.setRowSelectionAllowed(false);
        CalendarTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CalendarTableMouseClicked(evt);
            }
        });
        CalendarScrollPane.setViewportView(CalendarTable);

        YearSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                YearSpinnerStateChanged(evt);
            }
        });

        jLabel1.setText("年份");

        jLabel2.setText("月份");

        MonthSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                MonthSpinnerStateChanged(evt);
            }
        });

        SettingButton.setText("设置");
        SettingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CalendarScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(YearSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SettingButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(MonthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(SettingButton)
                    .addComponent(YearSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CalendarScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void YearSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_YearSpinnerStateChanged
        ShowCalendar();
    }//GEN-LAST:event_YearSpinnerStateChanged

    private void MonthSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_MonthSpinnerStateChanged
        ShowCalendar();
    }//GEN-LAST:event_MonthSpinnerStateChanged

    private void CalendarTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalendarTableMouseClicked
        int year = (Integer)this.YearSpinner.getValue();
        int month = (Integer)this.MonthSpinner.getValue();
        int irow = CalendarTable.getSelectedRow();
        int icol = CalendarTable.getSelectedColumn();
        Integer day = (Integer)CalendarTable.getValueAt(irow, icol);
        if(day != null)
        {
          RoutineForm.SetYearAndMonth(year, month, day);
          RoutineForm.setVisible(true);
        }
    }//GEN-LAST:event_CalendarTableMouseClicked

    private void SettingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SettingButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane CalendarScrollPane;
    private javax.swing.JTable CalendarTable;
    private javax.swing.JSpinner MonthSpinner;
    private javax.swing.JButton SettingButton;
    private javax.swing.JSpinner YearSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    private RoutineForm RoutineForm;
}
