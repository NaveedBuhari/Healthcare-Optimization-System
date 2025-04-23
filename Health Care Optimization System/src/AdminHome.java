import javax.swing.JOptionPane;
import java.sql.*;

public class AdminHome extends javax.swing.JFrame {
    PreparedStatement preparedStatement = null;
    Connection connection = null;
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String username = "SCOTT";
    String password = "tiger";
    String pid = null;

    public AdminHome(String pid) {
        this.pid = pid;
        initComponents();
        loadAdminName();
    }

    private void loadAdminName() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT AdminName FROM Admin WHERE AdminID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pid);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                name_label.setText(rs.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading admin info: " + e.getMessage());
        }
    }
}
