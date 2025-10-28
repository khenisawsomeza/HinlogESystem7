    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.hinlogesystem;

import static com.mycompany.hinlogesystem.HinlogESystem.st;
import com.mycompany.hinlogesystem.aisched.Subject;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StudentsForm extends javax.swing.JFrame {
      
    TeachersForm Tform = new TeachersForm();
    SubjectsForm Subform = new SubjectsForm();
    SelectSchoolYear AIForm = new SelectSchoolYear();

    public StudentsForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        studAddress = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        studId = new javax.swing.JTextField();
        studName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        studContact = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        studCourse = new javax.swing.JComboBox<>();
        studGender = new javax.swing.JComboBox<>();
        studYrLvl = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentsTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentsSubjectsTable = new javax.swing.JTable();
        enrollSubjectButton = new javax.swing.JButton();
        dropSubjectButton = new javax.swing.JButton();
        databaseLabel = new javax.swing.JLabel();
        torButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        teacherMenu = new javax.swing.JMenu();
        teachMenu = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        subMenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        dataMenu = new javax.swing.JMenu();
        firstSem25 = new javax.swing.JMenuItem();
        secondSem25 = new javax.swing.JMenuItem();
        summer25 = new javax.swing.JMenuItem();
        firstSem26 = new javax.swing.JMenuItem();
        javax.swing.JMenuItem secondSem26 = new javax.swing.JMenuItem();
        summer26 = new javax.swing.JMenuItem();
        firstSem27 = new javax.swing.JMenuItem();
        secondSem27 = new javax.swing.JMenuItem();
        summer27 = new javax.swing.JMenuItem();
        aiMenu = new javax.swing.JMenu();
        trainMenu = new javax.swing.JMenuItem();
        schedButton = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Student ID");

        studAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Address");

        studId.setEditable(false);
        studId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        studName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Course");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Year Level");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Gender");

        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateButton.setText("Update");
        updateButton.setToolTipText("");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        studContact.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Contact");

        studCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSCS", "BSIT", "BSIS", " " }));

        studGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        studYrLvl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "3rd", "4th" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studGender, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studId, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studName, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studYrLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studContact, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(studId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(studCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(studGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(studYrLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(deleteButton)
                    .addComponent(updateButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setText("STUDENT REGISTRATION");

        studentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Name", "Address", "Contact", "Course", "Gender", "Year Level"
            }
        ));
        studentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(studentsTable);

        studentsSubjectsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Subject ID", "Units", "Code", "Decription", "Schedule"
            }
        ));
        jScrollPane2.setViewportView(studentsSubjectsTable);

        enrollSubjectButton.setLabel("Enroll Subject");
        enrollSubjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enrollSubjectButtonActionPerformed(evt);
            }
        });

        dropSubjectButton.setLabel("Drop Subject");
        dropSubjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropSubjectButtonActionPerformed(evt);
            }
        });

        databaseLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        databaseLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        databaseLabel.setText("DATABASE");

        torButton.setText("Print TOR");
        torButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                torButtonActionPerformed(evt);
            }
        });

        jButton1.setText("AI  Enroll");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(102, 204, 255));

        teacherMenu.setForeground(new java.awt.Color(255, 255, 255));
        teacherMenu.setText("MENU");

        teachMenu.setText("Teachers");
        teachMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teachMenuActionPerformed(evt);
            }
        });
        teacherMenu.add(teachMenu);
        teacherMenu.add(jSeparator2);

        subMenu.setText("Subjects");
        subMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuActionPerformed(evt);
            }
        });
        teacherMenu.add(subMenu);
        teacherMenu.add(jSeparator1);

        jMenuBar1.add(teacherMenu);

        dataMenu.setForeground(new java.awt.Color(255, 255, 255));
        dataMenu.setText("DATABASE");

        firstSem25.setText("1stSem_Sy2025_2026");
        firstSem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstSem25ActionPerformed(evt);
            }
        });
        dataMenu.add(firstSem25);

        secondSem25.setText("2ndSem_Sy2025_2026");
        secondSem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondSem25ActionPerformed(evt);
            }
        });
        dataMenu.add(secondSem25);

        summer25.setText("Summer_Sy2025_2026");
        summer25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                summer25ActionPerformed(evt);
            }
        });
        dataMenu.add(summer25);

        firstSem26.setText("1stSem_Sy2026_2027");
        firstSem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstSem26ActionPerformed(evt);
            }
        });
        dataMenu.add(firstSem26);

        secondSem26.setText("2ndSem_Sy2026_2027");
        secondSem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondSem26ActionPerformed(evt);
            }
        });
        dataMenu.add(secondSem26);

        summer26.setText("Summer_Sy2026_2027");
        summer26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                summer26ActionPerformed(evt);
            }
        });
        dataMenu.add(summer26);

        firstSem27.setText("1stSem_Sy2027_2028");
        firstSem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstSem27ActionPerformed(evt);
            }
        });
        dataMenu.add(firstSem27);

        secondSem27.setText("2ndSem_Sy2027_2028");
        secondSem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondSem27ActionPerformed(evt);
            }
        });
        dataMenu.add(secondSem27);

        summer27.setText("Summer_Sy2027_2028");
        summer27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                summer27ActionPerformed(evt);
            }
        });
        dataMenu.add(summer27);

        jMenuBar1.add(dataMenu);

        aiMenu.setText("AI");
        aiMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aiMenuActionPerformed(evt);
            }
        });

        trainMenu.setText("Train Enroll Subject");
        trainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainMenuActionPerformed(evt);
            }
        });
        aiMenu.add(trainMenu);

        schedButton.setSelected(true);
        schedButton.setText("Conflict Schedule");
        schedButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                schedButtonStateChanged(evt);
            }
        });
        schedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schedButtonActionPerformed(evt);
            }
        });
        aiMenu.add(schedButton);

        jMenuBar1.add(aiMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(databaseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(enrollSubjectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dropSubjectButton, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(torButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(databaseLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(enrollSubjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dropSubjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(torButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        Students student = new Students();
        
        int row = studentsTable.getSelectedRow();          
        int id = Integer.parseInt(studentsTable.getValueAt(row, 0).toString());
        String name = studentsTable.getValueAt(row, 1).toString();
        
        student.deleteRecord(id, name);
        showRecords();
        ShowEnrollRec();
        resetFields();      
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        Students student = new Students();
        student.saveRecord(studName.getText(), studAddress.getText(), studContact.getText(), (String)studCourse.getSelectedItem(), (String)studGender.getSelectedItem(), (String)studYrLvl.getSelectedItem());
        showRecords();
        resetFields();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        Students student = new Students();
        student.updateRecord(Integer.valueOf(studId.getText()), studName.getText(), studAddress.getText(), studContact.getText(), (String)studCourse.getSelectedItem(), (String)studGender.getSelectedItem(), (String)studYrLvl.getSelectedItem());
        showRecords();
        resetFields();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HinlogESystem system = new HinlogESystem();
        if(!system.db.equals("")){
            showRecords();    
        }
        databaseLabel.setText(system.db);
    }//GEN-LAST:event_formWindowOpened
    
    private void studentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsTableMouseClicked
        int row = studentsTable.getSelectedRow();
        
        studId.setText(studentsTable.getValueAt(row, 0).toString());
        studName.setText(studentsTable.getValueAt(row, 1).toString());
        studAddress.setText(studentsTable.getValueAt(row, 2).toString());
        studContact.setText(studentsTable.getValueAt(row, 3).toString());
        studCourse.setSelectedItem(studentsTable.getValueAt(row, 4).toString());
        studGender.setSelectedItem(studentsTable.getValueAt(row, 5).toString());
        studYrLvl.setSelectedItem(studentsTable.getValueAt(row, 6).toString());
        
        ShowEnrollRec();
    }//GEN-LAST:event_studentsTableMouseClicked

    private void teachMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teachMenuActionPerformed
        Tform.setVisible(true);
        Tform.setLocationRelativeTo(null);
    }//GEN-LAST:event_teachMenuActionPerformed

    private void subMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuActionPerformed
        Subform.setVisible(true);
        Subform.setLocationRelativeTo(null);
    }//GEN-LAST:event_subMenuActionPerformed

    private void enrollSubjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enrollSubjectButtonActionPerformed
        HinlogESystem system = new HinlogESystem();
        Enrolled enrolled = new Enrolled();
        
        int row = studentsTable.getSelectedRow();
        int subId = enrolled.getsubjid();           
        int studId = Integer.parseInt(studentsTable.getValueAt(row, 0).toString());
        String studName = studentsTable.getValueAt(row, 1).toString();
        
        int response = JOptionPane.showConfirmDialog(null,"Enroll Student ID:" + studId + " to subject ID:" + subId,"Alert", JOptionPane.OK_CANCEL_OPTION);
        
        if (response == JOptionPane.YES_OPTION) {  
            

            if (schedButton.isSelected()){
                try {
                    List<Subject> enrolledSubjects = new ArrayList<>();
                    String getEnrolled = "SELECT s.* FROM subjects s " +
                                         "JOIN Enroll e ON s.subId = e.subjid " +
                                         "WHERE e.studid = " + studId;
                    ResultSet rs = system.st.executeQuery(getEnrolled);
                    while (rs.next()) {
                        enrolledSubjects.add(new Subject(
                            rs.getInt("subId"),
                            rs.getString("subCode"),
                            rs.getString("subDescription"),
                            rs.getString("subSchedule")
                        ));
                    }
                    
                    String getSubject = "SELECT * FROM subjects WHERE subId = " + subId;
                    ResultSet rs2 = system.st.executeQuery(getSubject);
                    Subject newSubject = null;
                    if (rs2.next()) {
                        newSubject = new Subject(
                            rs2.getInt("subId"),
                            rs2.getString("subCode"),
                            rs2.getString("subDescription"),
                            rs2.getString("subSchedule")
                        );
                    }
                    
                    boolean hasConflict = false;
                    for (Subject existing : enrolledSubjects) {
                        if (existing.conflictsWith(newSubject)) {
                            JOptionPane.showMessageDialog(
                                null,
                                "Conflict",
                                "Conflict Detected",
                                JOptionPane.WARNING_MESSAGE
                            );
                            hasConflict = true;
                            break;
                        }
                    }
                    
                    if(hasConflict){
                        return;
                    }
                        
                } catch (Exception e){
                    System.out.println("Failed to load subjects to ai (1)");
                }
                     
            } else {
//                try {
//                    CallableStatement cs = system.con.prepareCall("{CALL CheckScheduleConflict(?, ?, ?, ?)}");
//                    cs.setInt(1, studId);
//                    cs.setInt(2, subId);
//                    cs.registerOutParameter(3, Types.BOOLEAN);
//                    cs.registerOutParameter(4, Types.VARCHAR);
//                    cs.execute();
//
//                    boolean conflict = cs.getBoolean(3);
//                    String conflictSched = cs.getString(4);
//
//                    if (conflict) {
//                        JOptionPane.showMessageDialog(null,
//                            "Conflicting schedule: " + conflictSched,
//                            "Conflict",
//                            JOptionPane.WARNING_MESSAGE);
//                            return;
//                    }
//                    
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(null,  "Error checking or enrolling: " + e.getMessage());
//                }
                
                try {
                   if(hasScheduleConflict(studId, subId)){
                       System.out.println("Sched have conflict"); 
                       return;
                    }
                } catch (Exception e){
                    System.out.println("Failed to check conflict");
                }
            }
            
            try {
                String checkQuery = "SELECT * FROM Enroll WHERE studid = " + studId + " And subjid = " + subId;
                ResultSet rs = system.st.executeQuery(checkQuery);
                
                if (rs.next()){
                    JOptionPane.showMessageDialog(null, "Student " + studId + " is already enrolled in subject " + subId, "enroll", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    
                    try {
                        String query = enrolled.enrollStud(studId);
                        st.executeUpdate(query);
                        System.out.println("Insert Enroll Success");
                        
                        String username = studId + studName;
                        String password = "AdDU" + studName;
                        
                        try {
                            
                            String createUserQuery = "CREATE USER '"+ username+ "'@'%' IDENTIFIED BY '" + password + "';";
                            st.executeUpdate(createUserQuery);

                            System.out.println("student user created: " + username);

                        } catch (Exception ex){
                            System.out.println("Failed to create student user / user already exists: " + ex);
                        }
                        
                        try {
                            String updatePrivilageQuery = "GRANT SELECT ON " + system.db + ".* TO '" + username + "'@'%';";
                            st.executeUpdate(updatePrivilageQuery);

                            String flushQuery = "FLUSH PRIVILEGES;";
                            st.executeUpdate(flushQuery);

                            System.out.println("select granted on " + system.db + " for " + username);

                        } catch (Exception ex){
                            System.out.println("Failed to grant privileges ");
                        }
                        
                    } catch (Exception ex){
                        System.out.println("Failed to Enroll: " + ex);
                    }
                    
                    JOptionPane.showMessageDialog(null, "Student " + studId + " enrolled to " + subId, "enroll", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex){
                System.out.println("Failed to Enroll: " + ex);
            }      
            
        } else if (response == JOptionPane.NO_OPTION) {
            System.out.println("User clicked NO");
        }
        
        ShowEnrollRec();
        Subform.showRecords();
    }//GEN-LAST:event_enrollSubjectButtonActionPerformed

    private void dropSubjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropSubjectButtonActionPerformed
        HinlogESystem system = new HinlogESystem();
        Enrolled enroll = new Enrolled();
        
        int studentsRow = studentsTable.getSelectedRow();
        int subjectsRow = studentsSubjectsTable.getSelectedRow();
        int studId = Integer.parseInt(studentsTable.getValueAt(studentsRow, 0).toString());
        int subId = Integer.parseInt(studentsSubjectsTable.getValueAt(subjectsRow, 0).toString());
        
        int response = JOptionPane.showConfirmDialog(null,"Drop the subject:" + subId + " enrolled by student ID: " + studId, "Alert", JOptionPane.OK_CANCEL_OPTION);
        
        if(response == JOptionPane.OK_OPTION){
            String query = enroll.DropSubj(studId) + subId;
        
            try {
                st.executeUpdate(query);
                System.out.println("Drop Success");
                ShowEnrollRec();
                JOptionPane.showMessageDialog(null, "Student: " + studId + " dropped subject: " + subId, "enroll", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex){
                System.out.println("Failed to Drop: " + ex);
            }
        }
         
        ShowEnrollRec();
        Subform.updateTables();
    }//GEN-LAST:event_dropSubjectButtonActionPerformed

    private void firstSem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstSem25ActionPerformed
        HinlogESystem system = new HinlogESystem();
        system.db = "1stSem_Sy2025_2026";
        system.switchDB();
        databaseLabel.setText(system.db);
        
        showRecords();
        ShowEnrollRec();
        Subform.showRecords();
        Tform.showRecords();
    }//GEN-LAST:event_firstSem25ActionPerformed

    private void secondSem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondSem25ActionPerformed
        HinlogESystem system = new HinlogESystem();
        system.db = "2ndSem_Sy2025_2026";
        system.switchDB();
        databaseLabel.setText(system.db);
        
        showRecords();
        ShowEnrollRec();
        Subform.showRecords();
        Tform.showRecords();
    }//GEN-LAST:event_secondSem25ActionPerformed

    private void summer25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_summer25ActionPerformed
        HinlogESystem system = new HinlogESystem();
        system.db = "Summer_Sy2025_2026";
        system.switchDB();
        databaseLabel.setText(system.db);
        
        showRecords();
        ShowEnrollRec();
        Subform.showRecords();
        Tform.showRecords();
    }//GEN-LAST:event_summer25ActionPerformed

    private void torButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_torButtonActionPerformed
        int row = studentsTable.getSelectedRow();      
        int studId = Integer.parseInt(studentsTable.getValueAt(row, 0).toString());
        String studName = studentsTable.getValueAt(row, 1).toString();
        
        try {
            Reports report = new Reports();
            report.createTORPDF(studId);
        } catch (Exception e){
            System.out.println("Failed to Print TOP");
        }
        HinlogESystem system = new HinlogESystem();
        system.DBConnect();
    }//GEN-LAST:event_torButtonActionPerformed

    private void secondSem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondSem26ActionPerformed
        HinlogESystem system = new HinlogESystem();
        system.db = "2ndSem_Sy2026_2027";
        system.switchDB();
        databaseLabel.setText(system.db);
        
        showRecords();
        ShowEnrollRec();
        Subform.showRecords();
        Tform.showRecords();
    }//GEN-LAST:event_secondSem26ActionPerformed

    private void firstSem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstSem26ActionPerformed
        HinlogESystem system = new HinlogESystem();
        system.db = "1stSem_Sy2026_2027";
        system.switchDB();
        databaseLabel.setText(system.db);
        
        showRecords();
        ShowEnrollRec();
        Subform.showRecords();
        Tform.showRecords();
    }//GEN-LAST:event_firstSem26ActionPerformed

    private void summer26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_summer26ActionPerformed
        HinlogESystem system = new HinlogESystem();
        system.db = "Summer_Sy2026_2027";
        system.switchDB();
        databaseLabel.setText(system.db);
        
        showRecords();
        ShowEnrollRec();
        Subform.showRecords();
        Tform.showRecords();
    }//GEN-LAST:event_summer26ActionPerformed

    private void firstSem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstSem27ActionPerformed
        HinlogESystem system = new HinlogESystem();
        system.db = "1stSem_Sy2027_2028";
        system.switchDB();
        databaseLabel.setText(system.db);
        
        showRecords();
        ShowEnrollRec();
        Subform.showRecords();
        Tform.showRecords();
    }//GEN-LAST:event_firstSem27ActionPerformed

    private void secondSem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondSem27ActionPerformed
        HinlogESystem system = new HinlogESystem();
        system.db = "2ndSem_Sy2027_2028";
        system.switchDB();
        databaseLabel.setText(system.db);
        
        showRecords();
        ShowEnrollRec();
        Subform.showRecords();
        Tform.showRecords();
    }//GEN-LAST:event_secondSem27ActionPerformed

    private void summer27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_summer27ActionPerformed
        HinlogESystem system = new HinlogESystem();
        system.db = "Summer_Sy2027_2028";
        system.switchDB();
        databaseLabel.setText(system.db);
        
        showRecords();
        ShowEnrollRec();
        Subform.showRecords();
        Tform.showRecords();
    }//GEN-LAST:event_summer27ActionPerformed

    private void aiMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aiMenuActionPerformed
        
    }//GEN-LAST:event_aiMenuActionPerformed

    private void trainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainMenuActionPerformed
        AIForm.setVisible(true);
        AIForm.setLocationRelativeTo(null);
    }//GEN-LAST:event_trainMenuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int row = studentsTable.getSelectedRow();       
        String id = studentsTable.getValueAt(row, 0).toString();
        String name = studentsTable.getValueAt(row, 1).toString();
        String course = studentsTable.getValueAt(row, 4).toString();
        String gender = studentsTable.getValueAt(row, 5).toString();
        String yr = studentsTable.getValueAt(row, 6).toString();
        
        String username = id + name;
        String password = "AdDU" + name;
        
        HinlogESystem system = new HinlogESystem();
        Predict pred = new Predict();
        
        
        
        try {
            
            
            pred.predict(id, course, gender, yr);
            ShowEnrollRec();
            
            try {
                            
                String createUserQuery = "CREATE USER '"+ username+ "'@'%' IDENTIFIED BY '" + password + "';";
                st.executeUpdate(createUserQuery);

                System.out.println("student user created: " + username);

            } catch (Exception ex){
                System.out.println("Failed to create student user / user already exists: " + ex);
            }
                        
            try {
                String updatePrivilageQuery = "GRANT SELECT ON " + system.db + ".* TO '" + username + "'@'%';";
                st.executeUpdate(updatePrivilageQuery);

                String flushQuery = "FLUSH PRIVILEGES;";
                st.executeUpdate(flushQuery);

                System.out.println("select granted on " + system.db + " for " + username);

            } catch (Exception ex){
                System.out.println("Failed to grant privileges ");
            }
            
        } catch (Exception e){
            System.out.println("failed to AI enroll " + e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void schedButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_schedButtonStateChanged


    }//GEN-LAST:event_schedButtonStateChanged

    private void schedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schedButtonActionPerformed
        if (schedButton.isSelected()) {
            System.out.println("Conflict AI Checked!");
        } else {
            System.out.println("Conflict AI Unchecked!");
}
    }//GEN-LAST:event_schedButtonActionPerformed

    public void resetFields(){
        studId.setText(null);
        studName.setText(null);
        studAddress.setText(null);
        studContact.setText(null);
        studCourse.setSelectedItem(null);
        studGender.setSelectedItem(null);
        studYrLvl.setSelectedItem(null);
    }
    
    public void showRecords(){
        HinlogESystem system = new HinlogESystem();
        DefaultTableModel tblmodel = (DefaultTableModel) studentsTable.getModel();
        tblmodel.setRowCount(0);
        
        try{
            String query = "select * from students;";
            system.rs = system.st.executeQuery(query);
            while (system.rs.next())
            {
                String id = system.rs.getString("studid");
                String name = system.rs.getString("studName");
                String add = system.rs.getString("studAddress");
                String cont = system.rs.getString("studContact");
                String course = system.rs.getString("studCourse");
                String gend = system.rs.getString("studGender");
                String yr = system.rs.getString("studYrLvl");
                
                String[] item = {id, name, add, cont, course, gend, yr};
                tblmodel.addRow(item);
                System.out.println("show record success");
            }
        }catch(Exception ex){
            System.out.println("failed to show rec" + ex);
        }
    }
    
    private void ShowEnrollRec(){
        HinlogESystem system = new HinlogESystem();
        DefaultTableModel tblmodel = (DefaultTableModel) studentsSubjectsTable.getModel();
        tblmodel.setRowCount(0);
        
        try{
            int row = studentsTable.getSelectedRow();
            int studId = Integer.parseInt(studentsTable.getValueAt(row, 0).toString());           
            
            String query = "SELECT * FROM subjects WHERE subId IN (SELECT subjid FROM Enroll WHERE studid =" + studId + ");";
            system.rs = system.st.executeQuery(query);
            while (system.rs.next())
            {
                String id = system.rs.getString("subId");
                String units = system.rs.getString("subUnits");
                String code = system.rs.getString("subCode");
                String desc = system.rs.getString("subDescription");
                String sched = system.rs.getString("subSchedule");

                String[] item = {id, units, code, desc, sched};
                tblmodel.addRow(item);
                System.out.println("show enroll rec success");
            }
        }catch(Exception ex){
            System.out.println("failed show enroll rec / no selected student: " + ex);
            tblmodel.setRowCount(0);
        }       
    }
    
    private boolean hasScheduleConflict(int studId, int newSubId) throws SQLException {
        HinlogESystem system = new HinlogESystem();
        
        String newSchedQuery = "SELECT subSchedule FROM subjects WHERE subId = ?";
        try (PreparedStatement psNew = system.con.prepareStatement(newSchedQuery)) {
            psNew.setInt(1, newSubId);
            ResultSet rsNew = psNew.executeQuery();

            if (!rsNew.next()) {
                System.out.println("Subject not found!");
                return false;
            }

            String newSchedule = rsNew.getString("subSchedule");

            // Get all enrolled subject schedules
            String enrolledSchedQuery = """
                SELECT s.subSchedule FROM subjects s
                JOIN Enroll e ON e.subjid = s.subId
                WHERE e.studid = ?
            """;
            try (PreparedStatement ps = system.con.prepareStatement(enrolledSchedQuery)) {
                ps.setInt(1, studId);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    String existing = rs.getString("subSchedule");
                    if (isConflict(existing, newSchedule)) {
                        System.out.println("Conflict with: " + existing);
                        javax.swing.JOptionPane.showMessageDialog(
                                null,
                                "Conflict with " + existing,
                                "Schedule Conflict",
                                javax.swing.JOptionPane.WARNING_MESSAGE
                            );
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean isConflict(String sched1, String sched2) {
        if (sched1 == null || sched2 == null) return false;

        try {
            // Example formats:
            // "MWF 09:00-10:30"
            // "TTH 13:00-15:00"

            String[] parts1 = sched1.split(" ");
            String[] parts2 = sched2.split(" ");
            if (parts1.length < 2 || parts2.length < 2) return false;

            // Extract days and time ranges
            String days1 = parts1[0];
            String days2 = parts2[0];
            String[] time1 = parts1[1].split("-");
            String[] time2 = parts2[1].split("-");

            LocalTime start1 = LocalTime.parse(time1[0]);
            LocalTime end1 = LocalTime.parse(time1[1]);
            LocalTime start2 = LocalTime.parse(time2[0]);
            LocalTime end2 = LocalTime.parse(time2[1]);

            // Expand day abbreviations into individual days
            Set<String> daySet1 = expandDays(days1);
            Set<String> daySet2 = expandDays(days2);

            // Check for any overlapping day
            for (String d1 : daySet1) {
                if (daySet2.contains(d1)) {
                    // same day — check if time overlaps
                    if (start1.isBefore(end2) && start2.isBefore(end1)) {
                        return true;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("⚠️ Invalid schedule format: " + sched1 + " / " + sched2);
        }
        return false;
    }
    
    private Set<String> expandDays(String dayCode) {
        Set<String> days = new HashSet<>();
        dayCode = dayCode.toUpperCase();

        if (dayCode.contains("M")) days.add("MON");
        if (dayCode.contains("W")) days.add("WED");
        if (dayCode.contains("F")) days.add("FRI");

        // Handle TTH (Thursday needs two letters)
        if (dayCode.contains("TTH")) {
            days.add("TUE");
            days.add("THU");
        } else {
            if (dayCode.contains("T")) days.add("TUE");
            if (dayCode.contains("H")) days.add("THU");
        }

        if (dayCode.contains("SAT")) days.add("SAT");
        if (dayCode.contains("SUN")) days.add("SUN");

        return days;
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentsForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aiMenu;
    private javax.swing.JMenu dataMenu;
    private javax.swing.JLabel databaseLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton dropSubjectButton;
    private javax.swing.JButton enrollSubjectButton;
    private javax.swing.JMenuItem firstSem25;
    private javax.swing.JMenuItem firstSem26;
    private javax.swing.JMenuItem firstSem27;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JButton saveButton;
    private javax.swing.JCheckBoxMenuItem schedButton;
    private javax.swing.JMenuItem secondSem25;
    private javax.swing.JMenuItem secondSem27;
    private javax.swing.JTextField studAddress;
    private javax.swing.JTextField studContact;
    private javax.swing.JComboBox<String> studCourse;
    private javax.swing.JComboBox<String> studGender;
    private javax.swing.JTextField studId;
    private javax.swing.JTextField studName;
    private javax.swing.JComboBox<String> studYrLvl;
    private javax.swing.JTable studentsSubjectsTable;
    private javax.swing.JTable studentsTable;
    private javax.swing.JMenuItem subMenu;
    private javax.swing.JMenuItem summer25;
    private javax.swing.JMenuItem summer26;
    private javax.swing.JMenuItem summer27;
    private javax.swing.JMenuItem teachMenu;
    private javax.swing.JMenu teacherMenu;
    private javax.swing.JButton torButton;
    private javax.swing.JMenuItem trainMenu;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
