/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import javax.swing.*;

/**
 *
 * @author Wizard
 */
public class SettingForm extends javax.swing.JDialog 
{

    /**
     * Creates new form SettingForm
     */
    public SettingForm() {
        initComponents();
        this.setModal(true);
        this.setLocationRelativeTo(null);
        
        StartHrSpinner.setModel(new SpinnerNumberModel(0, 0, 23, 1));
        EndHrSpinner.setModel(new SpinnerNumberModel(0, 0, 23, 1));
        TipHrSpinner.setModel(new SpinnerNumberModel(0, 0, 23, 1));
        StartMinSpinner.setModel(new SpinnerNumberModel(0, 0, 59, 1));
        EndMinSpinner.setModel(new SpinnerNumberModel(0, 0, 59, 1));
        TipMinSpinner.setModel(new SpinnerNumberModel(0, 0, 59, 1));
    }

    public boolean IsSaved()
    {
        return Saved;
    }
    
    public void SetNote(NoteRow note)
    {
        Note = note;
        NameText.setText(note.GetTitle());
        int time = note.GetStartTime();
        int min = time % 100;
        int hr = time / 100;
        StartHrSpinner.setValue(hr);
        StartMinSpinner.setValue(min);
        time = note.GetEndTime();
        min = time % 100;
        hr = time / 100;
        EndHrSpinner.setValue(hr);
        EndMinSpinner.setValue(min);
        int method = note.GetAlertType();
        TipMethodComboBox.setSelectedIndex(method);
        if(method != 0)
        {
            time = note.GetAlertTime();
            min = time % 100;
            hr = time / 100;
        }
        else
            min = hr = 0;
        TipHrSpinner.setValue(hr);
        TipMinSpinner.setValue(min);
        ExtraText.setText(note.GetComment());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        NameText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        StartHrSpinner = new javax.swing.JSpinner();
        StartMinSpinner = new javax.swing.JSpinner();
        EndHrSpinner = new javax.swing.JSpinner();
        EndMinSpinner = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TipMethodComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        TipHrSpinner = new javax.swing.JSpinner();
        TipMinSpinner = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ExtraText = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("设置");
        setResizable(false);

        jLabel1.setText("事件名称");

        jLabel2.setText("起始时间");

        jLabel3.setText(":");

        jLabel4.setText(":");

        jLabel5.setText("截止时间");

        TipMethodComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "无", "提前一天", "当天" }));
        TipMethodComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipMethodComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setText("提醒方式");

        TipHrSpinner.setEnabled(false);

        TipMinSpinner.setEnabled(false);

        jLabel7.setText(":");

        jLabel8.setText("提醒时间");

        jLabel9.setText("备注");

        SaveButton.setText("保存");
        SaveButton.setPreferredSize(new java.awt.Dimension(80, 23));
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("取消");
        CancelButton.setPreferredSize(new java.awt.Dimension(80, 23));
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(StartHrSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(StartMinSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EndHrSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(NameText)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(EndMinSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TipMethodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TipHrSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TipMinSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(28, 28, 28)
                                        .addComponent(ExtraText)))
                                .addGap(2, 2, 2)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StartHrSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(StartMinSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EndHrSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EndMinSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TipMethodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(TipHrSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TipMinSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExtraText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        Saved = false;
        this.setVisible(false);
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        if(NameText.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "事件名称不得为空！");
            return;
        }
        Note.SetTitle(NameText.getText());
        int hr = (Integer)StartHrSpinner.getValue();
        int min = (Integer)StartMinSpinner.getValue();
        int starttime = hr * 100 + min;
        Note.SetStartTime(starttime);
        hr = (Integer)EndHrSpinner.getValue();
        min = (Integer)EndMinSpinner.getValue();
        int endtime = hr * 100 + min;
        if(endtime < starttime)
        {
            JOptionPane.showMessageDialog(null, "结束时间不得小于起始时间！");
            return;
        }
        Note.SetEndTime(endtime);
        int method = TipMethodComboBox.getSelectedIndex();
        Note.SetAlertType(method);
        int alerttime = 0;
        if(method != 0)
        {
            hr = (Integer)TipHrSpinner.getValue();
            min = (Integer)TipMinSpinner.getValue();
            alerttime = hr * 100 + min;
        }
        if(method == 2 && starttime < alerttime)
        {
            JOptionPane.showMessageDialog(null, "起始时间不得小于提醒时间！");
            return;
        }
        Note.SetAlertTime(alerttime);
        Note.SetComment(ExtraText.getText());
        Saved = true;
        this.setVisible(false);
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void TipMethodComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipMethodComboBoxActionPerformed
        int index = TipMethodComboBox.getSelectedIndex();
        boolean enabled = (index != 0);
        TipHrSpinner.setEnabled(enabled);
        TipMinSpinner.setEnabled(enabled);
    }//GEN-LAST:event_TipMethodComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JSpinner EndHrSpinner;
    private javax.swing.JSpinner EndMinSpinner;
    private javax.swing.JTextField ExtraText;
    private javax.swing.JTextField NameText;
    private javax.swing.JButton SaveButton;
    private javax.swing.JSpinner StartHrSpinner;
    private javax.swing.JSpinner StartMinSpinner;
    private javax.swing.JSpinner TipHrSpinner;
    private javax.swing.JComboBox TipMethodComboBox;
    private javax.swing.JSpinner TipMinSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables

    private NoteRow Note;
    private boolean Saved;
}
