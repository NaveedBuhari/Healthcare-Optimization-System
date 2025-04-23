import javax.swing.JOptionPane;
import java.sql.*;

public class BookAppointment extends javax.swing.JFrame {
    PreparedStatement preparedStatement = null;
    Connection connection = null;
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String username = "SCOTT";
    String password = "tiger";
    String pid = null;

    public BookAppointment(String pid) {
        this.pid = pid;
        initComponents();
    }

    private void bookActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(url, username, password);

            String sql = "Select count(*) from Appointment";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            int count = (rs.next()) ? rs.getInt(1) : 0;
            String id = "A00" + (count + 1);

            sql = "INSERT INTO Appointment(AppointmentID, PatientID, ServiceName, AppointmentDate, Status) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, pid);
            preparedStatement.setString(3, (String)service.getSelectedItem());
            preparedStatement.setString(4, date.getText());
            preparedStatement.setString(5, "P");

            if (preparedStatement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "Appointment requested successfully!");
                new PatientHome(pid).setVisible(true);
                dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to book appointment: " + e.getMessage());
        }
    }
}
