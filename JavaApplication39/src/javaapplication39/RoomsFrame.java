package transylvaniahotel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RoomsFrame extends JFrame {
    DefaultTableModel model;
    JTable table;

    public RoomsFrame() {
        setTitle("Transylvania Hotel - Manage Rooms");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // --- Panel الإدخال (يسار) ---
        JPanel inputPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(300, 600));
        inputPanel.setBackground(Theme.COLOR_NAVY);
        inputPanel.setLayout(null);

        JLabel lblTitle = new JLabel("ROOM DETAILS");
        lblTitle.setForeground(Theme.COLOR_MAROON);
        lblTitle.setFont(Theme.FONT_BOLD);
        lblTitle.setBounds(20, 20, 200, 30);
        inputPanel.add(lblTitle);

        // الحقول
        JTextField txtNo = createLabeledField(inputPanel, "Room Number:", 60);
        JTextField txtType = createLabeledField(inputPanel, "Type (Single/Double):", 130);
        JTextField txtPrice = createLabeledField(inputPanel, "Price:", 200);

        JButton btnAdd = new JButton("Add Room");
        Theme.styleButton(btnAdd);
        btnAdd.setBounds(20, 280, 250, 40);
        inputPanel.add(btnAdd);

        JButton btnBack = new JButton("Back");
        Theme.styleButton(btnBack);
        btnBack.setBackground(Theme.COLOR_CHARCOAL);
        btnBack.setBounds(20, 500, 250, 30);
        inputPanel.add(btnBack);

        // --- الجدول (يمين) ---
        String[] columns = {"Room No", "Type", "Price", "Status"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        Theme.styleTable(table);
        
        // بيانات تجريبية
        model.addRow(new Object[]{"101", "Single", "150$", "Available"});
        model.addRow(new Object[]{"102", "Double", "250$", "Occupied"});

        add(inputPanel, BorderLayout.WEST);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // الأكشن
        btnAdd.addActionListener(e -> {
            model.addRow(new Object[]{txtNo.getText(), txtType.getText(), txtPrice.getText(), "Available"});
            txtNo.setText(""); txtType.setText(""); txtPrice.setText("");
        });

        btnBack.addActionListener(e -> { new DashboardFrame().setVisible(true); dispose(); });
    }

    // دالة مساعدة لإنشاء الحقول
    private JTextField createLabeledField(JPanel p, String text, int y) {
        JLabel l = new JLabel(text);
        l.setForeground(Color.WHITE);
        l.setBounds(20, y, 200, 20);
        p.add(l);
        JTextField t = new JTextField();
        Theme.styleTextField(t);
        t.setBounds(20, y + 25, 250, 30);
        p.add(t);
        return t;
    }
}