/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hinlogesystem;

import java.util.ArrayList;

public class Students extends HinlogESystem{
       
    public void saveRecord(String name, String address, String contact, String course, String gender, String yrLvl){
        
        //insert student to tabel
        try {
            String getIdQuery = "select coalesce(max(studId), 1000) nextId from students";
            rs = st.executeQuery(getIdQuery); 
            int nextId = 0;
            if (rs.next()) {
                nextId += (rs.getInt("nextId") + 1);
            }   
            String insertQuery = "insert into students (studId, studName, studAddress, studContact, studCourse, studGender, studYrLvl) values(" + nextId + ",'" + name + "','" + address + "','" + contact + "','" + course + "','" + gender + "','" + yrLvl + "');";
            st.executeUpdate(insertQuery);  
            System.out.println("Insert Student Success");           
             
            String username = nextId + name;
            String password = "AdDU" + name;
            
            //create user
//            try {
//                String createUserQuery = "CREATE USER '"+ username+ "'@'%' IDENTIFIED BY '" + password + "';";
//                st.executeUpdate(createUserQuery);
//                
//                System.out.println("student user created: " + username);
//                
//            } catch (Exception ex){
//                System.out.println("Failed to create student user / user already exists: " + ex);
//            }
            
            //grant privelages
//            try {
//                String updatePrivilageQuery = "GRANT SELECT ON " + db + ".* TO '" + username + "'@'%';";
//                st.executeUpdate(updatePrivilageQuery);
//
//                String flushQuery = "FLUSH PRIVILEGES;";
//                st.executeUpdate(flushQuery);
//                    
//                System.out.println("select granted on " + db + " for " + username);
//            
//            } catch (Exception ex){
//                System.out.println("Failed to grant privileges ");
//            }
               
        } catch (Exception ex){
            System.out.println("Failed to Insert Student: " + ex);
        } 
         
    }
    
    public void deleteRecord(int id, String name){
 
        try {
            
            String query = "delete from students where studId = " + id;
            st.executeUpdate(query);
            System.out.println("Delete Student Success");
            
            String query2 = "DELETE FROM Enroll WHERE studid = " + id;
            st.executeUpdate(query2);
            System.out.println("Drop Student Enrollment Success");
            
            //delete or revoke user
            String username = id + name;
            boolean exists = checkStudentExists(id, name);
            if (exists){
                try {
                    String revokeQuery = "REVOKE ALL PRIVILEGES ON " + db + ".* FROM '" + username + "'@'%'"; 
                    st.executeUpdate(revokeQuery);
                    System.out.println("Revoke Success");
                } catch (Exception ex){
                    System.out.println("Failed to Revoke: " + ex);
                }
            } else {
                try {
                    String deleteQuery = "DROP USER '" + username + "'@'%';";
                    st.executeUpdate(deleteQuery);
                    System.out.println("delete user Success");
                } catch (Exception ex){
                    System.out.println("Failed to delete user: " + ex);
                }
            }         
            
        } catch (Exception ex){
            System.out.println("Failed to Delete Student: " + ex);
        }
        
        
    }
    
    public boolean checkStudentExists(int id, String name) {
        boolean exists = false;
        
        try {
            rs = st.executeQuery("SHOW DATABASES WHERE `Database` NOT IN ('mysql', 'information_schema', 'performance_schema', 'sys');");
            
            ArrayList<String> databases = new ArrayList<>();     
            while (rs.next()) {
                databases.add(rs.getString("Database"));
            }
            
            for (String database : databases){
                String q1 = "SELECT * FROM " + database + ".students WHERE studId = " + id + " AND studName = '" + name + "'";
                rs = st.executeQuery(q1);
                if (rs.next()) {
                    exists = true;
                    rs.close();
                    break;
                }   
            }

        } catch (Exception e) {
            System.out.println("failed to check if user exists");
        }
        
        return exists;
    }
    
    public void updateRecord(int id, String name, String address, String contact, String course, String gender, String yrLvl){
        String query = "UPDATE students SET " +
               "studName = '" + name + "', " +
               "studAddress = '" + address + "', " +
               "studContact = '" + contact + "', " +
               "studCourse = '" + course + "', " +
               "studGender = '" + gender + "', " +
               "studYrLvl = '" + yrLvl + "' " +
               "WHERE studId = " + id;
        
        try {
            st.executeUpdate(query);
            System.out.println("Update Student Success");
        } catch (Exception ex){
            System.out.println("Failed to Update Student: " + ex);
        }
    }
}
