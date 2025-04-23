# Healthcare-Optimization-System

A Java Swing and Oracle SQL-based Healthcare-Optimization-System designed to streamline patient, doctor, and admin workflows. This system enables login, registration, appointment booking, and appointment status viewing functionalities through a GUI developed in NetBeans.

## 📌 Project Overview

This project was created as part of a DBMS lab mini-project. It covers the development of a functional desktop-based hospital management solution using Java (Swing) and Oracle DB. Key operations include:

- Login and registration for patients, doctors, and admins
- Booking appointments by patients
- Viewing appointments and updating status by doctors
- Admin interface for system overview

## 🖥️ Technologies Used

- **Frontend**: Java Swing (NetBeans IDE)
- **Backend**: Oracle SQL
- **Database Connector**: JDBC
- **IDE**: NetBeans

## 📁 Project Structure

Healthcare-Optimization-System/ │ ├── Login1.java # Login frame ├── BookAppointment.java # Appointment booking UI for patients ├── ViewAppointments.java # View and pay appointments ├── ViewAppointmentsDoctor.java # Doctor's appointment view ├── Register1.java # Patient registration ├── Register2.java # Doctor registration ├── AdminHome.java # Admin dashboard ├── FindMyID.java # Forgot ID module └── OracleTables.sql # SQL schema (not included but recommended)


## 🧑‍⚕️ User Roles

- **Patient**: Register, login, book appointments, view appointment status, pay bills
- **Doctor**: View assigned appointments and their details
- **Admin**: View system status and manage appointments

## ⚙️ Setup Instructions

1. **Database Setup**:
   - Ensure Oracle DB is installed.
   - Create necessary tables: `Patient`, `Doctor`, `Admin`, `Appointment`, `Service`.
   - Set credentials in code:
     ```
     url = "jdbc:oracle:thin:@localhost:1521:orcl"
     username = "SCOTT"
     password = "tiger"
     ```

2. **Code Execution**:
   - Open project in NetBeans.
   - Run `Login1.java` or `Register1.java` to begin.

> ⚠️ Ensure Oracle JDBC driver is added to your project libraries in NetBeans.

## 🧪 Modules & Screens

### ✅ Login Screen (`Login1.java`)
- Validates user ID and role
- Redirects to appropriate homepage (Patient, Doctor, Admin)

### 📝 Register Screens
- `Register1.java`: Patient registration
- `Register2.java`: Doctor registration with service specialization

### 📅 Book Appointment (`BookAppointment.java`)
- Patient selects a service and date
- Entry saved to the `Appointment` table

### 👁️ View Appointment Status
- `ViewAppointments.java`: Shows patient appointments, payment status
- `ViewAppointmentsDoctor.java`: Doctor's view of assigned appointments

### 🛠️ Admin View (`AdminHome.java`)
- Displays admin name
- Access to view appointments and manage statuses

### 🔍 Forgot My ID (`FindMyID.java`)
- Retrieve user ID using registered phone number

## 🧯 Future Enhancements

- Role-based session management
- Notification system (email/SMS)
- Improved validation and password encryption
- UI/UX improvements with modern design

## 📄 License

This project is for academic use only. Modify and extend as needed for your own learning or academic submissions.
