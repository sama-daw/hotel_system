package transylvaniahotel;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    
    public LoginFrame() {
        setTitle("Transylvania Hotel - Login");
        setSize(450, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // ✅ التعديل الأول: تفعيل إمكانية تغيير الحجم
        setResizable(true); 
        
        // نستخدم BorderLayout في الـ Frame لوضع Panel واحد في المنتصف
        setLayout(new BorderLayout()); 

        // 1. اللوحة الرئيسية (سنستخدم GridBagLayout لتوسيط المحتوى)
        JPanel mainPanel = new JPanel(new GridBagLayout()); 
        mainPanel.setBackground(Theme.COLOR_NAVY);

        // GridBagConstraints: لضبط شكل وترتيب المكونات
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 20, 8, 20); // مسافة بين المكونات (8 بكسل علوي وسفلي، 20 يمين ويسار)
        gbc.fill = GridBagConstraints.HORIZONTAL; // املأ المساحة أفقياً
        
        // --- 1. اللوجو والصورة ---
        
        // الكود لتحميل اللوجو (يفترض أن logo.png موجود بنفس الـ Package)
        try {
            java.net.URL imageUrl = getClass().getResource("logo.png");
            JLabel lblLogo;

            if (imageUrl != null) {
                ImageIcon logoIcon = new ImageIcon(imageUrl);
                // ضبط حجم الصورة
                Image scaledImage = logoIcon.getImage().getScaledInstance(350, 140, Image.SCALE_SMOOTH);
                logoIcon = new ImageIcon(scaledImage);
                lblLogo = new JLabel(logoIcon, SwingConstants.CENTER);
            } else {
                // نص بديل في حالة عدم العثور على الصورة
                lblLogo = new JLabel("TRANSYLVANIA HOTEL", SwingConstants.CENTER);
                lblLogo.setFont(Theme.FONT_TITLE);
                lblLogo.setForeground(Theme.COLOR_MAROON);
                System.err.println("Error: logo.png not found!");
            }
            
            gbc.gridy = 0; // Row 0
            gbc.gridwidth = 2; // Span 2 columns
            mainPanel.add(lblLogo, gbc);

        } catch (Exception ex) {
            System.err.println("Error loading logo: " + ex.getMessage());
        }

        // --- 2. العنوان الفرعي ---
        JLabel lblSub = new JLabel("HOTEL MANAGEMENT SYSTEM", SwingConstants.CENTER);
        lblSub.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblSub.setForeground(Color.GRAY);
        
        gbc.gridy = 1; // Row 1
        mainPanel.add(lblSub, gbc);

        // إعادة تعيين لخانة واحدة (للفصل بين اللوجو والحقول)
        gbc.gridwidth = 1; 
        
        // --- 3. حقل اسم المستخدم ---
        JLabel lblUser = new JLabel("Username:");
        lblUser.setForeground(Theme.TEXT_COLOR);
        
        JTextField txtUser = new JTextField(20); // 20: العرض التقديري
        Theme.styleTextField(txtUser);

        gbc.gridy = 2; // Row 2
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(lblUser, gbc);
        
        gbc.gridy = 3; // Row 3
        mainPanel.add(txtUser, gbc);

        // --- 4. حقل كلمة المرور ---
        JLabel lblPass = new JLabel("Password:");
        lblPass.setForeground(Theme.TEXT_COLOR);

        JPasswordField txtPass = new JPasswordField(20);
        Theme.styleTextField(txtPass);

        gbc.gridy = 4; // Row 4
        mainPanel.add(lblPass, gbc);

        gbc.gridy = 5; // Row 5
        mainPanel.add(txtPass, gbc);

        // --- 5. زر الدخول ---
        JButton btnLogin = new JButton("LOGIN");
        Theme.styleButton(btnLogin);
        
        gbc.gridy = 6; // Row 6
        gbc.ipadx = 50; // عرض داخلي للزر
        gbc.fill = GridBagConstraints.NONE; // لا تمتد أفقيًا، فقط تتمركز
        mainPanel.add(btnLogin, gbc);

        // --- 6. الأكشن (كما هو) ---
        btnLogin.addActionListener(e -> {
            String user = txtUser.getText();
            String pass = new String(txtPass.getPassword());

            if (user.equals("admin") && pass.equals("admin")) {
                new DashboardFrame().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password (Try: admin/admin)");
            }
        });

        // إضافة اللوحة الرئيسية إلى منتصف الـ Frame
        add(mainPanel, BorderLayout.CENTER); 
    }
}