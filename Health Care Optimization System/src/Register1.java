import javax.swing.JOptionPane;
import java.sql.*;

public class Register1 extends javax.swing.JFrame {
    PreparedStatement preparedStatement = null;
    Connection connection = null;
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String username = "SCOTT";
    String password = "tiger";

    public Register1() {
        initComponents();
    }

    public void insertPatient(String Iname, String IDOB, String Istreet, String Iarea, String IphNo, String Igender, String Iblood) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT count(*) FROM Patient";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            int count = (rs.next()) ? rs.getInt(1) : 0;
            String id = "P00" + (count + 1);

            sql = "INSERT INTO Patient VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, Iname);
            preparedStatement.setString(3, IDOB);
            preparedStatement.setString(4, Istreet);
            preparedStatement.setString(5, Iarea);
            preparedStatement.setString(6, IphNo);
            preparedStatement.setString(7, Igender);
            preparedStatement.setString(8, Iblood);

            if (preparedStatement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "Patient registered successfully!");
                new Login1().setVisible(true);
                dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registration failed: " + e.getMessage());
        }
    }
}
