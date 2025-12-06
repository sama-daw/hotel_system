package transylvaniahotel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ReservationsFrame extends JFrame {
    DefaultTableModel model;

    public ReservationsFrame() {
        setTitle("Transylvania Hotel - Reservations");
        setSize(1100, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(320, 0));
        inputPanel.setBackground(Theme.COLOR_NAVY);
        inputPanel.setLayout(null);

        JLabel lblTitle = new JLabel("NEW BOOKING");
        lblTitle.setForeground(Theme.COLOR_MAROON);
        lblTitle.setFont(Theme.FONT_BOLD);
        lblTitle.setBounds(20, 20, 200, 30);
        inputPanel.add(lblTitle);

        JTextField txtCust = createLabeledField(inputPanel, "Customer Name:", 60);
        JTextField txtRoom = createLabeledField(inputPanel, "Room Number:", 130);
        JTextField txtCheckIn = createLabeledField(inputPanel, "Check-In (dd/mm/yyyy):", 200);
        JTextField txtCheckOut = createLabeledField(inputPanel, "Check-Out (dd/mm/yyyy):", 270);

        JButton btnCalc = new JButton("Calculate Total");
        Theme.styleButton(btnCalc);
        btnCalc.setBackground(Theme.COLOR_CHARCOAL);
        btnCalc.setBounds(20, 350, 280, 30);
        inputPanel.add(btnCalc);

        JButton btnBook = new JButton("Confirm Booking");
        Theme.styleButton(btnBook);
        btnBook.setBounds(20, 400, 280, 45);
        inputPanel.add(btnBook);

        JButton btnBack = new JButton("Back Home");
        Theme.styleButton(btnBack);
        btnBack.setBackground(Theme.COLOR_GREY);
        btnBack.setBounds(20, 550, 280, 30);
        inputPanel.add(btnBack);

        String[] columns = {"Res ID", "Customer", "Room", "In", "Out", "Total"};
        model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        Theme.styleTable(table);

        add(inputPanel, BorderLayout.WEST);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Actions
        btnCalc.addActionListener(e -> JOptionPane.showMessageDialog(this, "Total: 500$ (Example)"));
        
        btnBook.addActionListener(e -> {
            model.addRow(new Object[]{
                "R" + (model.getRowCount()+1),
                txtCust.getText(), txtRoom.getText(), 
                txtCheckIn.getText(), txtCheckOut.getText(), "500$"
            });
            JOptionPane.showMessageDialog(this, "Booking Confirmed!");
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
        t.setBounds(20, y + 25, 280, 30);
        p.add(t);
        return t;
    }
}