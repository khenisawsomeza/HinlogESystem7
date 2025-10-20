/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hinlogesystem;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import weka.classifiers.Classifier;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;

/**
 *
 * @author Khenyshi
 */
public class Training {
    
    HinlogESystem system = new HinlogESystem();
    
    static Connection con;
    static Statement st;
    static ResultSet rs;
    
    static String db;
    public Training(){
        
    }
    
    public Training(String db){
        this.db = db;
        
        try{
            connectDB();
            toARFF();
            train();
        } catch (Exception e){
            System.out.println("failed to train: " + e);
        }
    }
    
    public void connectDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://"+system.server+"/"+db+"?zeroDateTimeBehavior=CONVERT_TO_NULL", system.uname, system.pswd);
            st = con.createStatement();
            System.out.println("(Training) Connected: " + db);
        } catch (Exception ex){
            System.out.println("(Training) Failed to Connect: " + ex);
        }
    }
    
    public void toARFF(){
        String output = "train.arff";
        
        try {
            String query2 = "SELECT subId FROM subjects";
            rs = st.executeQuery(query2); 
            
            String subs = "";
            
            while(rs.next()){
                if (subs == "")
                    subs += rs.getString("subId");
                else {
                    subs += "," + rs.getString("subId");
                }
            }
            
            FileWriter writer = new FileWriter(output);
            writer.write("@RELATION enrollment_prediction\n\n");
            writer.write("@ATTRIBUTE studGender {Male,Female}\n");
            writer.write("@ATTRIBUTE studCourse {BSCS,BSIT,BSIS,BSDS}\n");
            writer.write("@ATTRIBUTE studYrlvl {1st,2nd,3rd,4th}\n");
            writer.write("@ATTRIBUTE subject {" + subs + "}\n\n");
            writer.write("@DATA\n"); 
            
            String query = "SELECT s.studGender, s.studCourse, s.studYrlvl, e.subjId " 
                + "FROM students s "
                + "INNER JOIN Enroll e ON s.studId = e.studId;";
            rs = st.executeQuery(query); 
            
            while (rs.next()) {
                String gender = rs.getString("studGender");
                String course = rs.getString("studCourse");
                String lvl = rs.getString("studYrlvl");
                String subject = rs.getString("subjId");

                writer.write(String.format("%s,%s,%s,%s\n",
                        gender, course, lvl, subject));
            }
            
            writer.close();
            System.out.println("ARFF file created: " + output);
 
        } catch (Exception e){
            System.out.println("Failed to create ARFF: " + e);
        }
    }
    
    public void train() throws Exception{
        DataSource source = new DataSource("train.arff");
        Instances data = source.getDataSet();

        data.setClassIndex(data.numAttributes() - 1);

        J48 tree = new J48();
        tree.buildClassifier(data);

        Evaluation eval = new Evaluation(data);
        eval.crossValidateModel(tree, data, 10, new Random(1));

        System.out.println(tree);
        System.out.println(eval.toSummaryString("\nEvaluation Results\n", false));

        SerializationHelper.write("train.model", tree);
        System.out.println("Model saved: " + "train.model");
    }
    
//    public void predict(String id, String course, String gender, String yr) throws Exception{
//        // Load trained model
//        Classifier model = (Classifier) weka.core.SerializationHelper.read(db + ".model");
//
//        // Load structure from ARFF
//        DataSource source = new DataSource(db + ".arff");
//        Instances structure = source.getStructure();
//        structure.setClassIndex(structure.numAttributes() - 1);
//
//        // Create a new student (example)
//        Instance newStudent = new DenseInstance(structure.numAttributes());
//        newStudent.setDataset(structure);
//        newStudent.setValue(0, gender);   // gender
//        newStudent.setValue(1, course);   // course
//        newStudent.setValue(2, yr);        // level
//
//        // Get probability distribution for all subjects
//        double[] probs = model.distributionForInstance(newStudent);
//
//        // Sort subjects by probability (descending)
//        Integer[] indices = new Integer[probs.length];
//        for (int i = 0; i < probs.length; i++) indices[i] = i;
//        Arrays.sort(indices, Comparator.comparingDouble((Integer i) -> probs[i]).reversed());
//
//        ArrayList<String> subjects = new ArrayList<String>();
//            
//        System.out.println("Top 3 predicted subjects:");
//        for (int i = 0; i < Math.min(5, indices.length); i++) {
//            int subid = (int) structure.classAttribute().value(indices[i]).hashCode(); // optional mapping
//            double prob = probs[indices[i]];
//            String label = structure.classAttribute().value(indices[i]);
//            System.out.printf("%d. %s (%.2f%%)%n", i + 1, label, prob * 100);
//            subjects.add(label);
//        }
//        
//        HinlogESystem system = new HinlogESystem();
//        for(String sub : subjects){
//            try {
//                String query = "INSERT INTO Enroll (studid, subjid) values(" + id + "," +  sub +");";
//                system.st.executeUpdate(query);
//                System.out.println("Insert Enroll Success: " + sub);
//            } catch (Exception e){
//                System.out.println("failed to enroll " + sub + ": " + e);
//            }
//        }
//    }
}
