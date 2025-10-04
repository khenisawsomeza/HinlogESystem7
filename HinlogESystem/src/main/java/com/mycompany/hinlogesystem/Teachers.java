/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hinlogesystem;

import static com.mycompany.hinlogesystem.HinlogESystem.rs;
import static com.mycompany.hinlogesystem.HinlogESystem.st;
import java.util.ArrayList;

public class Teachers extends HinlogESystem{

    public void saveRecord(String name, String address, String contact, String email, String department){
        
        try {
            String getIdQuery = "select coalesce(max(teachId), 3000) nextId from teachers";
            rs = st.executeQuery(getIdQuery); 
            int nextId = 0;
            if (rs.next()) {
                nextId += (rs.getInt("nextId") + 1);
            }
            
            String query = "insert into teachers (teachId, teachName, teachAddress, teachContact, teachEmail, teachDepartment) values(" + nextId + ",'" + name + "','" + address + "','" + contact + "','" + email +"','" + department + "');";
            st.executeUpdate(query);
            System.out.println("Insert Teacher Success");      
            
            String password = "AdDU" + name;
            String username = nextId + name;
            
            //create user
            try {
                String createUserQuery = "CREATE USER '"+ username+ "'@'%' IDENTIFIED BY '" + password + "';";
                st.executeUpdate(createUserQuery);
                
                System.out.println("teacher user created: " + username);

            } catch (Exception ex){
                System.out.println("Failed to create teacher user / user already exists: " + ex);
            }
            
            //grant
            try {
                String updatePrivilageQuery = "GRANT SELECT, INSERT, UPDATE ON " + db + ".* TO '" + username + "'@'%';";
                st.executeUpdate(updatePrivilageQuery);

                String flushQuery = "FLUSH PRIVILEGES;";
                st.executeUpdate(flushQuery);

            } catch (Exception ex){
                System.out.println("Failed to grant teacher privileges ");
            }
            
        } catch (Exception ex){
            System.out.println("Failed to Insert Teacher: " + ex);
        }
         
    }
    
    public void deleteRecord(int id, String name){
  
        try {
            String query = "delete from teachers where teachId = " + id;
            st.executeUpdate(query);
            System.out.println("Delete teacher Success");
            
            String query2 = "DELETE FROM Assign WHERE tid = " + id;
            st.executeUpdate(query2);
            System.out.println("Delete teacher assignment Success");
            
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
            System.out.println("Failed to Delete teacher: " + ex);
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
                String q1 = "SELECT * FROM " + database + ".teachers WHERE teachId = " + id + " AND teachName = '" + name + "'";
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
    
    public void updateRecord(int id, String name, String address, String contact, String email, String department){
        String query = "UPDATE teachers SET " +
               "teachId = '" + id + "', " +
               "teachName = '" + name + "', " +
               "teachAddress = '" + address + "', " +
               "teachContact = '" + contact + "', " +
               "teachEmail = '" + email + "', " +
               "teachDepartment = '" + department + "' " +
               "WHERE teachId = " + id;
        
        try {
            st.executeUpdate(query);
            System.out.println("Update Teacher Success");
        } catch (Exception ex){
            System.out.println("Failed to Update Teacher: " + ex);
        }
    }
}
