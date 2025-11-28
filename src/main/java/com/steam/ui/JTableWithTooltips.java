/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steam.ui;

import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.event.MouseEvent;
import java.awt.Point;
import java.awt.Component;
/**
 *
 * @author Admin
 */


public class JTableWithTooltips extends JTable {

    // (Các constructor như ở câu trả lời trước)
    public JTableWithTooltips() { super(); }
    public JTableWithTooltips(TableModel tm) { super(tm); }

    @Override
    public String getToolTipText(MouseEvent e) {
        Point p = e.getPoint();
        int row = rowAtPoint(p);
        int col = columnAtPoint(p);

        if (row < 0 || col < 0) {
            return null; // Không ở trên ô nào
        }

        // Lấy renderer (component vẽ ô)
        TableCellRenderer renderer = getCellRenderer(row, col);
        Component component = prepareRenderer(renderer, row, col);

        // Lấy chiều rộng thực tế của cột
        int columnWidth = getColumnModel().getColumn(col).getWidth();
        
        // Lấy chiều rộng mà nội dung "muốn" hiển thị
        int preferredWidth = component.getPreferredSize().width;

        
        Object value = getValueAt(row, col);
        return value != null ? value.toString() : null;
        // Nếu nội dung "muốn" rộng hơn cột...
//        if (preferredWidth > columnWidth) {
//            // ...thì có nghĩa là nội dung đã bị che, hãy hiển thị tooltip
//            Object value = getValueAt(row, col);
//            return value != null ? value.toString() : null;
//        } else {
//            // Nếu không, nội dung đã hiển thị đủ, không cần tooltip
//            return null;
//        }
    }
}
