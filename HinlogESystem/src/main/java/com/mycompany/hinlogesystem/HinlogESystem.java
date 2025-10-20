package com.mycompany.hinlogesystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class HinlogESystem {
    
    static Connection con;
    static Statement st;
    static ResultSet rs;
    
    static String db = "";
    static String uname = "";
    static String pswd = "";   
    static String host = "localhost";
    static String port = ":3306";
    static String server = host + port;
    
    static boolean isConnected = false;

    public static void main(String[] args) {     
        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }  
    
    public static void DBConnect(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://"+server+"/"+db+"?zeroDateTimeBehavior=CONVERT_TO_NULL", uname, pswd);
            st = con.createStatement();
            System.out.println("Connected: " + db);
            isConnected = true;
        } catch (Exception ex){
            isConnected = false;
            System.out.println("Failed to Connect: " + ex);
        }
        
    }
    
    public static void switchDB(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://"+server+"/"+db+"?zeroDateTimeBehavior=CONVERT_TO_NULL", uname, pswd);
            st = con.createStatement();
            JOptionPane.showMessageDialog(null,"Database Switched: " + db, "New Database", JOptionPane.INFORMATION_MESSAGE);
        } catch(Exception ex){
            System.out.println("database not found: " + ex);
            createTables();
        }      
        
    }
    
    public static void createTables(){
        
        System.out.println("test");
        
        try {
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS `" + db + "`");
            st.executeUpdate("USE " + db);
            
            // create Students Table
            try {
                String createStudentsTable = "CREATE TABLE IF NOT EXISTS students (" +
                "studId INT PRIMARY KEY AUTO_INCREMENT," +
                "studName TEXT," +
                "studAddress TEXT, " +
                "studContact TEXT, " +
                "studCourse TEXT, " +
                "studGender TEXT, " +
                "studYrlvl TEXT" +
                ") AUTO_INCREMENT = 1001";
                st.executeUpdate(createStudentsTable);
            } catch (Exception e) {
                System.out.println("Failed to create students table" + e);
            }

            // Create Subjects table
            try {
                String createSubjectsTable = "CREATE TABLE IF NOT EXISTS subjects (" +
                    "subId INT PRIMARY KEY AUTO_INCREMENT, " +
                    "subUnits INT, " +
                    "subCode TEXT, " +
                    "subDescription TEXT, " +
                    "subSchedule TEXT" +
                    ") AUTO_INCREMENT = 2001";
                st.executeUpdate(createSubjectsTable);
            } catch (Exception e) {
                System.out.println("Failed to create subjects table" + e);
            }

            // Create Teachers table
            try {
                String createTeachersTable = "CREATE TABLE IF NOT EXISTS teachers (" +
                    "teachId INT PRIMARY KEY AUTO_INCREMENT, " +
                    "teachName TEXT, " +
                    "teachAddress TEXT, " +
                    "teachContact TEXT, " +
                    "teachEmail TEXT, " +
                    "teachDepartment TEXT" +
                    ") AUTO_INCREMENT = 3001";
                st.executeUpdate(createTeachersTable);
            } catch (Exception e) {
                System.out.println("Failed to create teachers table" + e);
            }

            // Create TransactionCharges table
            try {
                String createTransactionChargesTable = "CREATE TABLE IF NOT EXISTS TransactionCharges (" +
                    "TransID INT PRIMARY KEY AUTO_INCREMENT, " +
                    "Department TEXT, " +
                    "SubjUnits DECIMAL(10,2), " +
                    "Insurance DECIMAL(10,2), " +
                    "Computer DECIMAL(10,2), " +
                    "Laboratory DECIMAL(10,2), " +
                    "Cultural DECIMAL(10,2), " +
                    "`Library` DECIMAL(10,2), " +
                    "Facility DECIMAL(10,2)" +
                    ")";
                st.executeUpdate(createTransactionChargesTable);
            } catch (Exception e) {
                System.out.println("Failed to create transaction charges table" + e);
            }

            // Create Enroll table (depends on Students and Subjects)
            try {
                String createEnrollTable = "CREATE TABLE IF NOT EXISTS Enroll (" +
                    "eid INT PRIMARY KEY AUTO_INCREMENT, " +
                    "studid INT, " +
                    "subjid INT," +
                    "FOREIGN KEY (studid) REFERENCES students(studId) ON DELETE CASCADE, " +
                    "FOREIGN KEY (subjid) REFERENCES subjects(subId) ON DELETE CASCADE," +
                    "UNIQUE (studid, subjid)" +
                    ")";
                st.executeUpdate(createEnrollTable);
            } catch (Exception e) {
                System.out.println("Failed to create enroll table" + e);
            }

            // Create Assign table (depends on Teachers and Subjects)
            try {
                String createAssignTable = "CREATE TABLE IF NOT EXISTS Assign (" +
                    "subid INT UNIQUE," +
                    "tid INT," +
                    "FOREIGN KEY (subid) REFERENCES subjects(subId) ON DELETE CASCADE, " +
                    "FOREIGN KEY (tid) REFERENCES teachers(teachId) ON DELETE CASCADE" +
                    ")";
                st.executeUpdate(createAssignTable);
            } catch (Exception e) {
                System.out.println("Failed to create assign table" + e);
            }

            // Create Grades table (depends on Enroll)
            try {
                String createGradesTable = "CREATE TABLE IF NOT EXISTS Grades (" +
                    "GradeID INT PRIMARY KEY AUTO_INCREMENT, " +
                    "eid INT UNIQUE, " +
                    "Prelim TEXT, " +
                    "Midterm TEXT, " +
                    "Prefinal TEXT, " +
                    "Final TEXT, " +
                    "FOREIGN KEY (eid) REFERENCES Enroll(eid) ON DELETE CASCADE" +
                    ")";
                st.executeUpdate(createGradesTable);
            } catch (Exception e) {
                System.out.println("Failed to create grades table" + e);
            }

            // Create Invoice table (depends on Students and TransactionCharges)
            try {
                String createInvoiceTable = "CREATE TABLE IF NOT EXISTS Invoice (" +
                    "Invoicenum INT PRIMARY KEY AUTO_INCREMENT, " +
                    "studid INT, " +
                    "TransID INT" +
                    ")";
                st.executeUpdate(createInvoiceTable);
            } catch (Exception e) {
                System.out.println("Failed to create invoice table" + e);
            }
            
            System.out.println("Database created: " + db);
            
        } catch(Exception e){
            System.out.println("Failed to create Database: " + db + " (" + e +")");
        } 
        
        switch (db) {
            case "2ndSem_Sy2025_2026":
                try {
                    copyData("1stSem_Sy2025_2026", db);
                } catch (Exception e) {
                    System.out.println("Error while copying data: " + e.getMessage());
                }
                break;
                
            case "Summer_Sy2025_2026":
                try {
                    copyData("2ndSem_Sy2025_2026", db);
                } catch (Exception e) {
                    System.out.println("Error while copying data: " + e.getMessage());
                }
                break;
            
            case "1stSem_Sy2026_2027":
                try {
                    copyData("1stSem_Sy2025_2026", db);
                } catch (Exception e) {
                    System.out.println("Error while copying data: " + e.getMessage());
                }
                break;

            case "2ndSem_Sy2026_2027":
                try {
                    copyData("1stSem_Sy2026_2027", db);
                } catch (Exception e) {
                    System.out.println("Error while copying data: " + e.getMessage());
                }
                break;

            case "Summer_Sy2026_2027":
                try {
                    copyData("2ndSem_Sy2026_2027", db);
                } catch (Exception e) {
                    System.out.println("Error while copying data: " + e.getMessage());
                }
                break;

            case "1stSem_Sy2027_2028":
                try {
                    copyData("1stSem_Sy2026_2027", db);
                } catch (Exception e) {
                    System.out.println("Error while copying data: " + e.getMessage());
                }
                break;

            case "2ndSem_Sy2027_2028":
                try {
                    copyData("1stSem_Sy2027_2028", db);
                } catch (Exception e) {
                    System.out.println("Error while copying data: " + e.getMessage());
                }
                break;

            case "Summer_Sy2027_2028":
                try {
                    copyData("2ndSem_Sy2027_2028", db);
                } catch (Exception e) {
                    System.out.println("Error while copying data: " + e.getMessage());
                }
                break;
                
            default:
                System.out.println("no database source found");
            }
           
        DBConnect();

        }
    
    public static void copyData(String sourceDb, String targetDb) throws Exception {

        try {

            String copyQuery = "INSERT INTO " + targetDb + ".students" +
                         " SELECT * FROM " + sourceDb + ".students";
            st.executeUpdate(copyQuery);
            
            String copyQuery2 = "INSERT INTO " + targetDb + ".subjects" +
                         " SELECT * FROM " + sourceDb + ".subjects";
            st.executeUpdate(copyQuery2);
            
            String copyQuery3 = "INSERT INTO " + targetDb + ".teachers" +
                         " SELECT * FROM " + sourceDb + ".teachers";
            st.executeUpdate(copyQuery3);
            
            String copyQuery4 = "INSERT INTO " + targetDb + ".assign" +
                         " SELECT * FROM " + sourceDb + ".assign";
            st.executeUpdate(copyQuery4);

            System.out.println("Data copied from " + sourceDb + " to " + targetDb);
            
        } catch (Exception e){
            System.out.println("Failed to Copy data from " + sourceDb + ": " + e);
        }
        
    }

}
