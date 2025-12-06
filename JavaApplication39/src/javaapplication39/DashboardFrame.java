package transylvaniahotel;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {
    
    public DashboardFrame() {
        setTitle("Transylvania Hotel - Dashboard");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // الهيدر العلوي
        JPanel header = new JPanel();
        header.setBackground(Theme.COLOR_MAROON);
        header.setPreferredSize(new Dimension(900, 80));
        header.setLayout(new GridBagLayout());
        
        JLabel title = new JLabel("MAIN DASHBOARD");
        title.setFont(Theme.FONT_TITLE);
        title.setForeground(Color.WHITE);
        header.add(title);

        // قائمة الأزرار
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Theme.COLOR_NAVY);
        menuPanel.setLayout(new GridLayout(2, 2, 30, 30)); // شبكة 2x2
        menuPanel.setBorder(BorderFactory.createEmptyBorder(60, 100, 60, 100));

        JButton btnRooms = new JButton("Manage Rooms");
        Theme.styleButton(btnRooms);

        JButton btnCustomers = new JButton("Manage Customers");
        Theme.styleButton(btnCustomers);

        JButton btnReservations = new JButton("Reservations");
        Theme.styleButton(btnReservations);

        JButton btnLogout = new JButton("Logout");
        Theme.styleButton(btnLogout);
        btnLogout.setBackground(Theme.COLOR_CHARCOAL); // لون مختلف للخروج

        menuPanel.add(btnRooms);
        menuPanel.add(btnCustomers);
        menuPanel.add(btnReservations);
        menuPanel.add(btnLogout);

        // تفعيل الأزرار
        btnRooms.addActionListener(e -> { new RoomsFrame().setVisible(true); dispose(); });
        btnCustomers.addActionListener(e -> { new CustomersFrame().setVisible(true); dispose(); });
        btnReservations.addActionListener(e -> { new ReservationsFrame().setVisible(true); dispose(); });
        btnLogout.addActionListener(e -> { new LoginFrame().setVisible(true); dispose(); });

        add(header, BorderLayout.NORTH);
        add(menuPanel, BorderLayout.CENTER);
    }
}