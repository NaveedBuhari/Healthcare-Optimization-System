# 🏥 Health Care Optimization System

A full-fledged desktop-based health care optimization system developed using Java Swing (NetBeans) and Oracle SQL. The project facilitates efficient handling of patient and doctor data, appointment scheduling, and administrative controls within a healthcare environment.

## 📌 Project Overview

This application was created as part of a DBMS mini-project. It uses Java for the frontend GUI and Oracle DB for backend storage. It supports three user roles (Admin, Doctor, Patient) and includes full CRUD operations for appointments, registrations, and login management.

## 🧑‍⚕️ Core Functionalities

- Patient registration and login
- Doctor registration and login
- Admin dashboard view
- Appointment booking by patients
- Appointment review by doctors
- View appointment status and payment
- Retrieve forgotten user ID using phone number

## 🛠️ Technologies Used

- **Frontend**: Java Swing (NetBeans GUI Builder)
- **Backend**: Oracle Database
- **Database Connector**: Oracle JDBC (`ojdbc8.jar`)
- **IDE**: NetBeans

## 🗂️ Project Structure

HospitalManagementSystem/
│
├── src/
│   ├── Login1.java
│   ├── Register1.java
│   ├── Register2.java
│   ├── BookAppointment.java
│   ├── ViewAppointments.java
│   ├── ViewAppointmentsDoctor.java
│   ├── AdminHome.java
│   ├── FindMyID.java
│
├── resources/
│   └── bg4.jpg (background image if available)
│
├── lib/
│   └── ojdbc8.jar (Oracle JDBC driver)
│
├── hospital_schema.sql
├── README.md
└── .gitignore



## 🧾 Setup Instructions

### 📁 Database Setup

1. Install Oracle Database and run it.
2. Use `hospital_schema.sql` to create required tables:
   ```sql
   -- In SQL*Plus or SQL Developer:
   @path/to/hospital_schema.sql
3. Use the following credentials in your Java files (or modify as needed):
   ```bash
   String url = "jdbc:oracle:thin:@localhost:1521:orcl";
   String username = "SCOTT";
   String password = "tiger";

🧑‍💻 Running the App
1. Open the project in NetBeans.
2. Add ojdbc8.jar to your project libraries:
   - Right-click project → Properties → Libraries → Add JAR/Folder
3. Set Login1.java as the main class.
4. Run the project.

🌱 Future Enhancements
- Encrypt passwords and improve validation
- Implement role-based session management
- Notifications via email/SMS
- Improved UI design (flat theme)

📄 License
This project is for academic use only. You're free to modify and extend it for personal learning or submission.


🙌 Acknowledgements
This project was developed as part of a university DBMS course. Special thanks to faculty for guidance and peers for testing and feedback.
