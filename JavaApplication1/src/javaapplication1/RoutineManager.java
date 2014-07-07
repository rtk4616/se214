/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import java.sql.*;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wizard
 */
public class RoutineManager 
{
    private int Year;
    private int Month;
    private int Day;
    private ArrayList<NoteRow> Data
            = new ArrayList<NoteRow>();
    
    public void Load(int year, int month, int day)
           throws SQLException, ClassNotFoundException
    {
        if(Year == year && Month == month && Day == day)
            return;
        Class.forName("org.sqlite.JDBC");
        Connection conn 
           = DriverManager.getConnection("jdbc:sqlite:" + Program.FILE_PATH);
        String sql = "SELECT * FROM note WHERE date=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        int date = year * 10000 + month * 100 + day;
        stmt.setInt(1, date);
        ResultSet rs = stmt.executeQuery();
        Data.clear();
        while(rs.next())
        {
            NoteRow row = new NoteRow();
            row.SetID(rs.getInt(1));
            row.SetDate(rs.getInt(2));
            row.SetStartTime(rs.getInt(3));
            row.SetEndTime(rs.getInt(4));
            row.SetTitle(rs.getString(5));
            row.SetComment(rs.getString(6));
            row.SetAlertType(rs.getInt(7));
            row.SetAlertTime(rs.getInt(8));
            Data.add(row);
        }
        conn.close();
    }
    
    public void Show(JTable jtb)
    {
        DefaultTableModel model = (DefaultTableModel)jtb.getModel();
        model.setRowCount(0);
        for(NoteRow row : Data)
        {
            Object[] arr = new Object[6];
            arr[0] = row.GetTitle();
            arr[1] = TimeConvert(row.GetStartTime());
            arr[2] = TimeConvert(row.GetEndTime());
            int itype = row.GetAlertType();
            String strtype;
            if(itype == 1)
                strtype = "提前一天";
            else if(itype == 2)
                strtype = "当天";
            else
                strtype = "无";
            arr[3] = strtype;
            arr[4] =TimeConvert(row.GetAlertTime());
            arr[5] = row.GetComment();
            model.addRow(arr);
        }
    }
    
    public NoteRow Get(int index)
    {
        return Data.get(index);
    }
    
    private static String TimeConvert(int time)
    {
        int min = time % 100;
        int hr = time / 100;
        return String.format("%02d:%02d", hr, min);
    }
    
    public void Save(NoteRow note)
           throws ClassNotFoundException, SQLException, Exception
    {
        if(Data.indexOf(note) == -1)
            throw new Exception("该计划不存在");
        Class.forName("org.sqlite.JDBC");
        Connection conn 
           = DriverManager.getConnection("jdbc:sqlite:" + Program.FILE_PATH);
        String sql = "UPDATE note SET starttime=?, " +
                     "endtime=?, title=?, comment=?, alerttype=?, " + 
                     "alerttime=? WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, note.GetStartTime());
        stmt.setInt(2, note.GetEndTime());
        stmt.setString(3, note.GetTitle());
        stmt.setString(4, note.GetComment());
        stmt.setInt(5, note.GetAlertType());
        stmt.setInt(6, note.GetAlertTime());
        stmt.setInt(7, note.GetID());
        stmt.executeUpdate();
    }
  
    public void Remove(NoteRow note)
           throws ClassNotFoundException, SQLException, Exception
    {
        if(Data.indexOf(note) == -1)
            throw new Exception("该计划不存在");
        Class.forName("org.sqlite.JDBC");
        Connection conn 
           = DriverManager.getConnection("jdbc:sqlite:" + Program.FILE_PATH);
        String sql = "DELETE FROM note WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, note.GetID());
        stmt.executeUpdate();
        Data.remove(note);
    }
    
    public void Add(NoteRow note)
           throws ClassNotFoundException, SQLException, Exception
    {
        if(Data.indexOf(note) != -1)
            throw new Exception("该计划已存在");
        Class.forName("org.sqlite.JDBC");
        Connection conn 
           = DriverManager.getConnection("jdbc:sqlite:" + Program.FILE_PATH);
        String sql = "INSERT INTO note (date, starttime, endtime, title, " +
                     "comment, alerttype, alerttime) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, note.GetDate());
        stmt.setInt(2, note.GetStartTime());
        stmt.setInt(3, note.GetEndTime());
        stmt.setString(4, note.GetTitle());
        stmt.setString(5, note.GetComment());
        stmt.setInt(6, note.GetAlertType());
        stmt.setInt(7, note.GetAlertTime());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        rs.next();
        note.SetID(rs.getInt(1));
        Data.add(note);
    }
}
