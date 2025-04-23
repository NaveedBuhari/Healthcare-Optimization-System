-- Table for patients
CREATE TABLE Patient (
    PatientID VARCHAR2(10) PRIMARY KEY,
    Name VARCHAR2(50),
    DOB DATE,
    Street VARCHAR2(100),
    Area VARCHAR2(100),
    PhoneNumber VARCHAR2(15),
    Gender VARCHAR2(10),
    BloodGroup VARCHAR2(5)
);

-- Table for doctors
CREATE TABLE Doctor (
    DoctorID VARCHAR2(10) PRIMARY KEY,
    Name VARCHAR2(50),
    DOB DATE,
    Street VARCHAR2(100),
    Area VARCHAR2(100),
    PhoneNumber VARCHAR2(15),
    Gender VARCHAR2(10),
    BloodGroup VARCHAR2(5),
    ServiceName VARCHAR2(50)
);

-- Table for admin
CREATE TABLE Admin (
    AdminID VARCHAR2(10) PRIMARY KEY,
    AdminName VARCHAR2(50)
);

-- Table for services
CREATE TABLE Service (
    ServiceName VARCHAR2(50) PRIMARY KEY,
    Cost NUMBER(10)
);

-- Table for appointments
CREATE TABLE Appointment (
    AppointmentID VARCHAR2(10) PRIMARY KEY,
    PatientID VARCHAR2(10),
    ServiceName VARCHAR2(50),
    AppointmentDate DATE,
    Status CHAR(1),
    DoctorID VARCHAR2(10),
    AmountPaid NUMBER(10),
    StartTime VARCHAR2(10),
    DueDate DATE,
    FOREIGN KEY (PatientID) REFERENCES Patient(PatientID),
    FOREIGN KEY (DoctorID) REFERENCES Doctor(DoctorID),
    FOREIGN KEY (ServiceName) REFERENCES Service(ServiceName)
);
