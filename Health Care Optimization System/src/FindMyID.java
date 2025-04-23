import javax.swing.JOptionPane;
import java.sql.*;

public class FindMyID extends javax.swing.JFrame {
    public FindMyID() {
        initComponents();
    }

    private void findActionPerformed(java.awt.event.ActionEvent evt) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "SCOTT";
        String password = "tiger";

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(url, username, password);

            String userID_str = null;

            String sql = "SELECT PatientID FROM Patient WHERE PhoneNumber = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, phone_tf.getText());
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                userID_str = rs.getString(1);
            }

            if (userID_str == null) {
                sql = "SELECT DoctorID FROM Doctor WHERE PhoneNumber = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, phone_tf.getText());
                rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    userID_str = rs.getString(1);
                }
            }

            userID_tf.setText(userID_str != null ? userID_str : "Not Found");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Failed to close DB connection");
            }
        }
    }

    private void initComponents() {
    phone_tf = new javax.swing.JTextField();
    phone = new javax.swing.JLabel();
    userID = new javax.swing.JLabel();
    find = new javax.swing.JButton();
    userID_tf = new javax.swing.JTextField();
    Back = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    phone_tf.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            phone_tfActionPerformed(evt);
        }
    });
    getContentPane().add(phone_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 230, -1));

    phone.setFont(new java.awt.Font("Segoe UI", 2, 14));
    phone.setText("Phone Number");
    getContentPane().add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 140, 20));

    userID.setFont(new java.awt.Font("Segoe UI", 2, 14));
    userID.setText("Your User ID");
    getContentPane().add(userID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 80, -1));

    find.setBackground(new java.awt.Color(0, 0, 0));
    find.setFont(new java.awt.Font("Segoe UI", 3, 18));
    find.setForeground(new java.awt.Color(255, 255, 255));
    find.setText("Find My ID");
    find.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            findActionPerformed(evt);
        }
    });
    getContentPane().add(find, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 170, 40));
    getContentPane().add(userID_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 230, -1));

    Back.setBackground(new java.awt.Color(0, 0, 0));
    Back.setFont(new java.awt.Font("Segoe UI", 3, 18));
    Back.setForeground(new java.awt.Color(255, 255, 255));
    Back.setText("Back");
    Back.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BackActionPerformed(evt);
        }
    });
    getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 90, -1));

    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/bg4.jpg")));
    getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 691, -1));

    pack();
}

}
