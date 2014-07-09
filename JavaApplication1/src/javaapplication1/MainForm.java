/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author Wizard
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm()
           throws AWTException
    {
        initComponents();
        this.setLocationRelativeTo(null);
        RoutineForm = new RoutineForm();
        
        Calendar dt = Calendar.getInstance();
        int year = dt.get(Calendar.YEAR);
        int month = dt.get(Calendar.MONTH) + 1;
        YearSpinner.setModel(new SpinnerNumberModel(year, 1970, 2999, 1));
        MonthSpinner.setModel(new SpinnerNumberModel(month, 1, 12, 1));
        ShowCalendar();
        
        InitTrayIcon();
    }

    private void InitTrayIcon()
            throws AWTException
    {
        if(!SystemTray.isSupported()) return;
        TrayIcon = new TrayIcon(
             new ImageIcon(MainForm.class.getResource("/rsrc/icon.jpg")).getImage());
        TrayIcon.setToolTip("日程管理");
        TrayIcon.setImageAutoSize(true);
        SystemTray.getSystemTray().add(TrayIcon);
        TrayIcon.addMouseListener(new MouseListener() 
        {       
            @Override
            public void mouseClicked(MouseEvent e) 
            { TrayIcon_MouseClicked(e); }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });

        Thread tr = new Thread(new Runnable()
        {
            @Override
            public void run() { DoThread(); }
        });
        tr.start();
    }
    
    private void ShowCalendar()
    {
        int year = (Integer)this.YearSpinner.getValue();
        int month = (Integer)this.MonthSpinner.getValue();
        CalendarManager cm = new CalendarManager();
        cm.SetDate(year, month);
        cm.Show(CalendarTable);
    }
    
    private void TrayIcon_MouseClicked(MouseEvent e)
    {
        if(e.getClickCount() != 2) return;
        setVisible(true);
    }
    
    private void DoThread()
    {
        try {
        int lastmin = -1;
        Class.forName("org.sqlite.JDBC");
        Connection conn 
          = DriverManager.getConnection("jdbc:sqlite:" + Program.FILE_PATH);
        String sql = "SELECT title FROM note " + 
                     "WHERE ((alerttype=2 AND date=?) OR " +
                     "(alerttype=1 AND date=?)) AND alerttime=?";
        while(true)
        {
            try {
            System.out.println("Thread is running.");
            Calendar cal =  Calendar.getInstance();
            int min = cal.get(Calendar.MINUTE);
            if(min == lastmin)
            {
                Thread.sleep(10 * 1000);
                continue;
            }
            lastmin = min;
            PreparedStatement stmt = conn.prepareStatement(sql);
            int date = cal.get(Calendar.YEAR) * 10000 +
                       (cal.get(Calendar.MONTH) + 1) * 100 +
                       cal.get(Calendar.DATE);
            int time = cal.get(Calendar.HOUR_OF_DAY) * 100 + min;
            stmt.setInt(1, date);
            stmt.setInt(2, date + 1);
            stmt.setInt(3, time);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Date: " + String.valueOf(date) + 
                               "\nTime: " + String.valueOf(time));
            int rowcount = 0;
            while(rs.next())
            {
                rowcount++;
                String title = rs.getString(1);
                TrayIcon.displayMessage("信息提示：", title + " 即将开始",
                                        java.awt.TrayIcon.MessageType.INFO);
            }
            System.out.println("Rowcount: " + String.valueOf(rowcount));
            Thread.sleep(10 * 1000);
            } catch(Exception ex) 
            {
                TrayIcon.displayMessage("信息提示：", ex.getMessage(),
                                        java.awt.TrayIcon.MessageType.ERROR);
            }
        }
        } catch(Exception ex)
        { JOptionPane.showMessageDialog(null, ex.getMessage()); }
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
        setIconImage(new ImageIcon(MainForm.class.getResource("/rsrc/icon.jpg")).getImage());
        setResizable(false);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

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

        SettingButton.setText("导入/导出");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(YearSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SettingButton))
                    .addComponent(CalendarScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(YearSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MonthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(SettingButton)))
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
        try
        {
            if(evt.getClickCount() == 1) return;
            int year = (Integer)this.YearSpinner.getValue();
            int month = (Integer)this.MonthSpinner.getValue();
            int irow = CalendarTable.getSelectedRow();
            int icol = CalendarTable.getSelectedColumn();
            Integer day = (Integer)CalendarTable.getValueAt(irow, icol);
            if(day != null)
            {
              RoutineForm.SetDate(year, month, day);
              RoutineForm.setVisible(true);
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_CalendarTableMouseClicked

    private void SettingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingButtonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_SettingButtonActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        if(evt.getNewState() == JFrame.ICONIFIED &&
           SystemTray.isSupported())
        {
            this.setExtendedState(JFrame.NORMAL);
            this.setVisible(false);
            TrayIcon.displayMessage("我在这里...", "双击我可以显示窗口。",
                                    java.awt.TrayIcon.MessageType.INFO);
        }
    }//GEN-LAST:event_formWindowStateChanged

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
    private TrayIcon TrayIcon;
}