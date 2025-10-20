/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hinlogesystem;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import weka.classifiers.Classifier;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
/**
 *
 * @author Khenyshi
 */
public class Predict extends Training{
    
    public void predict(String id, String course, String gender, String yr) throws Exception{
        // Load trained model
        Classifier model = (Classifier) weka.core.SerializationHelper.read("train.model");

        // Load structure from ARFF
        DataSource source = new DataSource("train.arff");
        Instances structure = source.getStructure();
        structure.setClassIndex(structure.numAttributes() - 1);

        // Create a new student (example)
        Instance newStudent = new DenseInstance(structure.numAttributes());
        newStudent.setDataset(structure);
        newStudent.setValue(0, gender);   // gender
        newStudent.setValue(1, course);   // course
        newStudent.setValue(2, yr);        // level

        // Get probability distribution for all subjects
        double[] probs = model.distributionForInstance(newStudent);

        // Sort subjects by probability (descending)
        Integer[] indices = new Integer[probs.length];
        for (int i = 0; i < probs.length; i++) indices[i] = i;
        Arrays.sort(indices, Comparator.comparingDouble((Integer i) -> probs[i]).reversed());

        ArrayList<String> subjects = new ArrayList<String>();
            
        System.out.println("Top 3 predicted subjects:");
        for (int i = 0; i < Math.min(5, indices.length); i++) {
            int subid = (int) structure.classAttribute().value(indices[i]).hashCode(); // optional mapping
            double prob = probs[indices[i]];
            String label = structure.classAttribute().value(indices[i]);
            System.out.printf("%d. %s (%.2f%%)%n", i + 1, label, prob * 100);
            subjects.add(label);
        }
        
        HinlogESystem system = new HinlogESystem();
        for(String sub : subjects){
            try {
                String query = "INSERT INTO Enroll (studid, subjid) values(" + id + "," +  sub +");";
                system.st.executeUpdate(query);
                System.out.println("Insert Enroll Success: " + sub);
            } catch (Exception e){
                System.out.println("failed to enroll " + sub + ": " + e);
            }
        }
    }
    
}
