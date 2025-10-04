/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hinlogesystem;

public class Subjects extends HinlogESystem {
    
    public void saveRecord(int units, String code, String description, String schedule){
        
        try {
            String getIdQuery = "select coalesce(max(subId), 2000) nextId from subjects";
            rs = st.executeQuery(getIdQuery); 
            int nextId = 0;
            if (rs.next()) {
                nextId += (rs.getInt("nextId") + 1);
            }   
            
            String query = "insert into subjects (subId, subUnits, subCode, subDescription, subSchedule)  values(" + nextId + "," + units + ",'" + code + "','" + description + "','" + schedule +"');";
            st.executeUpdate(query);
            System.out.println("Insert Subject Success");
            
        } catch (Exception ex){
            System.out.println("Failed to Insert Subject: " + ex);
        }
    }
    
    public void deleteRecord(int id){
        
        try {
            String query = "delete from subjects where subId = " + id;
            st.executeUpdate(query);
            System.out.println("Delete Subject Success");
        } catch (Exception ex){
            System.out.println("Failed to Delete Subject: " + ex);
        }
        
        try {
            String query2 = "DELETE FROM Enroll WHERE subjid = " + id;
            st.executeUpdate(query2);
            System.out.println("Drop Success");
        } catch (Exception ex){
            System.out.println("Failed to Drop Subject Enrollment: " + ex);
        }
        
        String query3 = "DELETE FROM Assign WHERE subid = " + id;
        try {
            st.executeUpdate(query3);
            System.out.println("Delete Subject Assignment Success");
        } catch (Exception ex){
            System.out.println("Failed to Delete Subject Assignment: " + ex);
        }
    }
    public void updateRecord(int id, int units, String code, String description, String schedule){
        String query = "UPDATE subjects SET " +
               "subId = '" + id + "', " +
               "subUnits = '" + units + "', " +
               "subCode = '" + code + "', " +
               "subDescription = '" + description + "', " +
               "subSchedule = '" + schedule + "' " +
               "WHERE subId = " + id;
        
        try {
            st.executeUpdate(query);
            System.out.println("Update Subject Success");
        } catch (Exception ex){
            System.out.println("Failed to Update Subject: " + ex);
        }
    }
}
