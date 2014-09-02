/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wizard.routinemobile.utility;

import java.util.*;

/**
 *
 * @author Wizard
 */
public class CalendarManager 
{
    public static final int WIDTH = 7;
    public static final int HEIGHT = 6;
    
    private int[][] table;
    
    public CalendarManager()
    {
        clear();
    }
    
    private void clear()
    {
        table = new int[][]
        {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
    }
    
    @SuppressWarnings("ResourceType")
    public void setDate(int year, int month)
    {
        clear();
        Calendar dt = Calendar.getInstance();
        dt.set(year, month - 1, 1);
        int dayofweek = dt.get(Calendar.DAY_OF_WEEK);
        int offset = (dayofweek == 1)? 6: dayofweek - 2;
        int total = dt.getActualMaximum(Calendar.DAY_OF_MONTH);
        for(int i = 1; i <= total; i++)
        {
            int row = offset / WIDTH,
                col = offset % WIDTH;
            table[row][col] = i;
            offset++;
        }
    }
    
    public int at(int row, int col)
    {
        return table[row][col];
    }
}
