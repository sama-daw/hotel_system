package transylvaniahotel;

import java.awt.*;
import javax.swing.*;

public class Theme {
    // الألوان المستخرجة من الصور
    public static final Color COLOR_NAVY = new Color(28, 38, 50);     // خلفية القوائم
    public static final Color COLOR_GREY = new Color(73, 79, 83);     // خلفية الجداول والمحتوى
    public static final Color COLOR_MAROON = new Color(98, 35, 56);   // الأزرار والعناوين
    public static final Color COLOR_CHARCOAL = new Color(58, 59, 61); // حقول الكتابة
    public static final Color TEXT_COLOR = Color.WHITE;               // لون النص

    // الخطوط
    public static final Font FONT_TITLE = new Font("Serif", Font.BOLD, 28);
    public static final Font FONT_REGULAR = new Font("SansSerif", Font.PLAIN, 14);
    public static final Font FONT_BOLD = new Font("SansSerif", Font.BOLD, 14);

    // دالة لتنسيق الأزرار بشكل موحد
    public static void styleButton(JButton btn) {
        btn.setBackground(COLOR_MAROON);
        btn.setForeground(TEXT_COLOR);
        btn.setFocusPainted(false);
        btn.setFont(FONT_BOLD);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // دالة لتنسيق حقول الكتابة
    public static void styleTextField(JTextField txt) {
        txt.setBackground(COLOR_CHARCOAL);
        txt.setForeground(TEXT_COLOR);
        txt.setCaretColor(TEXT_COLOR);
        txt.setBorder(BorderFactory.createLineBorder(COLOR_GREY));
        txt.setFont(FONT_REGULAR);
    }
    
    // دالة لتنسيق الجداول
    public static void styleTable(JTable table) {
        table.setBackground(COLOR_GREY);
        table.setForeground(TEXT_COLOR);
        table.setSelectionBackground(COLOR_MAROON);
        table.setSelectionForeground(TEXT_COLOR);
        table.setRowHeight(30);
        table.getTableHeader().setBackground(COLOR_NAVY);
        table.getTableHeader().setForeground(TEXT_COLOR);
        table.getTableHeader().setFont(FONT_BOLD);
    }
}
