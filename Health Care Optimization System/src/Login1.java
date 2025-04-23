import javax.swing.JOptionPane;
import java.sql.*;

public class Login1 extends javax.swing.JFrame {
    PreparedStatement preparedStatement = null;
    Connection connection = null;
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String username = "SCOTT";
    String password = "tiger";

    public Login1() {
        initComponents();
    }

    public void checkLogin(String Iusername, String Ipassword) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(url, username, password);
            int countP = 0, countD = 0, countA = 0;

            String sql = "Select count(*) from Patient where PatientId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Iusername);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) countP = rs.getInt(1);

            sql = "Select count(*) from Doctor where DoctorId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Iusername);
            rs = preparedStatement.executeQuery();
            if (rs.next()) countD = rs.getInt(1);

            sql = "Select count(*) from Admin where AdminID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Iusername);
            rs = preparedStatement.executeQuery();
            if (rs.next()) countA = rs.getInt(1);

            if (countP == 0 && countD == 0 && countA == 0){
                JOptionPane.showMessageDialog(null, "User Doesn't Exist!");
                username_tf.setText("");
                password_tf.setText("");
            } else if (!Ipassword.equals("ssn")) {
                JOptionPane.showMessageDialog(null, "Incorrect password");
                username_tf.setText("");
                password_tf.setText("");
            } else {
                if (countP == 1) new PatientHome(Iusername).setVisible(true);
                else if (countD == 1) new DoctorHome(Iusername).setVisible(true);
                else if (countA == 1) new AdminHome(Iusername).setVisible(true);
                dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Login failed due to: " + e.getMessage());
        }
    }
}
