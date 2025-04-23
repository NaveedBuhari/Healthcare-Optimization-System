import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewAppointmentsDoctor extends javax.swing.JFrame {
    PreparedStatement preparedStatement = null;
    Connection connection = null;
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String username = "SCOTT";
    String password = "tiger";
    String pid = null;

    public ViewAppointmentsDoctor(String pid) {
        this.pid = pid;
        initComponents();
        loadAppointments();
    }

    private void loadAppointments() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT UNIQUE a.AppointmentID, a.PatientID, a.ServiceName, a.AppointmentDate, a.StartTime " +
                         "FROM Appointment a WHERE DoctorID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pid);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String[] row = {
                    rs.getString("AppointmentID"),
                    rs.getString("StartTime"),
                    rs.getString("PatientID"),
                    rs.getString("AppointmentDate"),
                    rs.getString("ServiceName")
                };
                DefaultTableModel model = (DefaultTableModel) appointments.getModel();
                model.addRow(row);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading appointments: " + e.getMessage());
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Failed to close DB connection");
            }
        }
    }

    private void initComponents() {
    jSlider1 = new javax.swing.JSlider();
    back = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    appointments = new javax.swing.JTable();
    jLabel2 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setResizable(false);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    back.setBackground(new java.awt.Color(0, 0, 0));
    back.setFont(new java.awt.Font("Segoe UI", 2, 14));
    back.setForeground(new java.awt.Color(255, 255, 255));
    back.setText("Back");
    back.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            backActionPerformed(evt);
        }
    });
    getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));

    appointments.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {},
        new String [] {"ID", "Time", "Patient ", "Date", "Service"}
    ) {
        Class[] types = new Class [] {
            java.lang.String.class, java.lang.String.class,
            java.lang.String.class, java.lang.String.class, java.lang.String.class
        };
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false
        };
        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    });
    jScrollPane1.setViewportView(appointments);
    getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 590, 320));

    jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 24));
    jLabel2.setText("Your Appointments");
    getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/bg4.jpg")));
    getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 691, 440));

    pack();
}

}
