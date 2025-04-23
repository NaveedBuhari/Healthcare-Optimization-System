import javax.swing.JOptionPane;
import java.sql.*;

public class Register2 extends javax.swing.JFrame {
    PreparedStatement preparedStatement = null;
    Connection connection = null;
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String username = "SCOTT";
    String password = "tiger";

    public Register2() {
        initComponents();
    }

    public void insertDoctor(String Iname, String IDOB, String Istreet, String Iarea, String IphNo, String Igender, String Iblood, String Iservice) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT count(*) FROM Doctor";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            int count = (rs.next()) ? rs.getInt(1) : 0;
            String id = "D00" + (count + 1);

            sql = "INSERT INTO Doctor VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, Iname);
            preparedStatement.setString(3, IDOB);
            preparedStatement.setString(4, Istreet);
            preparedStatement.setString(5, Iarea);
            preparedStatement.setString(6, IphNo);
            preparedStatement.setString(7, Igender);
            preparedStatement.setString(8, Iblood);
            preparedStatement.setString(9, Iservice);

            if (preparedStatement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "Doctor registered successfully!");
                new Login1().setVisible(true);
                dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Doctor registration failed: " + e.getMessage());
        }
    }
}
