package transylvaniahotel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CustomersFrame extends JFrame {
    DefaultTableModel model;

    public CustomersFrame() {
        setTitle("Transylvania Hotel - Manage Customers");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(300, 600));
        inputPanel.setBackground(Theme.COLOR_NAVY);
        inputPanel.setLayout(null);

        JLabel lblTitle = new JLabel("CUSTOMER INFO");
        lblTitle.setForeground(Theme.COLOR_MAROON);
        lblTitle.setFont(Theme.FONT_BOLD);
        lblTitle.setBounds(20, 20, 200, 30);
        inputPanel.add(lblTitle);

        JTextField txtName = createLabeledField(inputPanel, "Full Name:", 60);
        JTextField txtPhone = createLabeledField(inputPanel, "Phone Number:", 130);
        JTextField txtEmail = createLabeledField(inputPanel, "Email:", 200);

        JButton btnAdd = new JButton("Add Customer");
        Theme.styleButton(btnAdd);
        btnAdd.setBounds(20, 280, 250, 40);
        inputPanel.add(btnAdd);

        JButton btnBack = new JButton("Back");
        Theme.styleButton(btnBack);
        btnBack.setBackground(Theme.COLOR_CHARCOAL);
        btnBack.setBounds(20, 500, 250, 30);
        inputPanel.add(btnBack);

        String[] columns = {"ID", "Name", "Phone", "Email"};
        model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        Theme.styleTable(table);
        
        model.addRow(new Object[]{"1", "Mavis Dracula", "010-999-888", "mavis@hotel.com"});

        add(inputPanel, BorderLayout.WEST);
        add(new JScrollPane(table), BorderLayout.CENTER);

        btnAdd.addActionListener(e -> {
            model.addRow(new Object[]{model.getRowCount() + 1, txtName.getText(), txtPhone.getText(), txtEmail.getText()});
            txtName.setText(""); txtPhone.setText(""); txtEmail.setText("");
        });

        btnBack.addActionListener(e -> { new DashboardFrame().setVisible(true); dispose(); });
    }

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