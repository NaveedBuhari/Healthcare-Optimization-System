import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewAppointments extends javax.swing.JFrame {
    PreparedStatement preparedStatement = null;
    Connection connection = null;
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String username = "SCOTT";
    String password = "tiger";
    String pid = null;

    public ViewAppointments(String pid) {
        this.pid = pid;
        initComponents();
        loadAppointments();
    }

    private void loadAppointments() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT a.APPOINTMENTID,a.DOCTORID,a.SERVICENAME,a.AMOUNTPAID,a.APPOINTMENTDATE,a.STARTTIME,a.DUEDATE,a.STATUS,s.COST FROM Appointment a, Service s WHERE a.ServiceName = s.ServiceName AND PATIENTID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pid);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String[] data = {
                    rs.getString("APPOINTMENTID"),
                    rs.getString("APPOINTMENTDATE"),
                    rs.getString("STATUS"),
                    rs.getString("DOCTORID"),
                    rs.getString("SERVICENAME"),
                    rs.getString("COST"),
                    rs.getString("AMOUNTPAID"),
                    rs.getString("DUEDATE")
                };
                ((DefaultTableModel)b_table.getModel()).addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading appointments: " + e.getMessage());
        }
    }
}
