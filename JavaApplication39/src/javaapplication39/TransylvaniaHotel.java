package transylvaniahotel; 

import javax.swing.SwingUtilities;

// يجب أن يتطابق اسم الكلاس مع اسم الملف، وهو هنا TransylvaniaHotel
public class TransylvaniaHotel { 
    public static void main(String[] args) {
        // تشغيل شاشة الدخول (LoginFrame)
        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}