/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.*;

/**
 *
 * @author Wizard
 */
public class RoutineForm extends javax.swing.JDialog 
{

    /**
     * Creates new form RoutineForm
     */
    public RoutineForm() 
    {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setModal(true);
        SettingForm = new SettingForm();
    }

    public void SetDate(int year, int month, int day)
           throws java.sql.SQLException, ClassNotFoundException
    {
        if(Year == year && Month == month && Day == day)
            return;
        Year = year;
        Month = month;
        Day = day;
        this.setTitle("日程安排 " + String.valueOf(year) + "年" +
                      String.valueOf(month) + "月" + String.valueOf(day) + "日");
        Routine.Load(year, month, day);
        Routine.Show(RoutineTable);
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
        RoutineTable = new javax.swing.JTable();
        DelButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();

        setResizable(false);

        RoutineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "事件名称", "起始时间", "截止时间", "提醒方式", "提醒时间", "备注"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        RoutineTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RoutineTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(RoutineTable);

        DelButton.setText("删除");
        DelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelButtonActionPerformed(evt);
            }
        });

        AddButton.setText("添加");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DelButton)
                    .addComponent(AddButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RoutineTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RoutineTableMouseClicked
        try
        {
            if(evt.getClickCount() == 1) return;
            int row = RoutineTable.getSelectedRow();
            NoteRow note = Routine.Get(row);
            SettingForm.SetNote(note);
            SettingForm.setVisible(true);
            if(SettingForm.IsSaved())
            {
                Routine.Save(note);
                Routine.Show(RoutineTable);
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "修改失败！" + ex.getMessage());
        }
    }//GEN-LAST:event_RoutineTableMouseClicked

    private void DelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelButtonActionPerformed
        try
        {
            int row = RoutineTable.getSelectedRow();
            if(row == -1) return;
            if(JOptionPane.showConfirmDialog(null, "真的要删除吗？",
                UIManager.getString("OptionPane.titleText") , 
                JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
                return;
            NoteRow note = Routine.Get(row);
            Routine.Remove(note);
            Routine.Show(RoutineTable);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "删除失败！" + ex.getMessage());
        }
    }//GEN-LAST:event_DelButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        try
        {
            NoteRow note = new NoteRow();
            note.SetDate(Year * 10000 + Month * 100 + Day);
            SettingForm.SetNote(note);
            SettingForm.setVisible(true);
            if(SettingForm.IsSaved())
            {
                Routine.Add(note);
                Routine.Show(RoutineTable);
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "添加失败！" + ex.getMessage());
        }
    }//GEN-LAST:event_AddButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton DelButton;
    private javax.swing.JTable RoutineTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private int Year;
    private int Month;
    private int Day;
    private RoutineManager Routine
            = new RoutineManager();
    private SettingForm SettingForm;
}