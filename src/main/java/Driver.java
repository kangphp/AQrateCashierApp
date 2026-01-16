import com.formdev.flatlaf.FlatDarkLaf;
import views.frmLogin;

public class Driver {
    public static void main(String[] args) {
        try {
            FlatDarkLaf.setup();
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        new frmLogin().setVisible(true);
    }
}
