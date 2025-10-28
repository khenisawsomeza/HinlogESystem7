package com.mycompany.hinlogesystem.aisched;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Enrollment {

    private int studentId;

    @PlanningVariable(valueRangeProviderRefs = {"subjectRange"})
    private Subject subject;

    public Enrollment() {}

    public Enrollment(int studentId, Subject subject) {
        this.studentId = studentId;
        this.subject = subject;
    }

    // --- Getters & Setters ---
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public Subject getSubject() { return subject; }
    public void setSubject(Subject subject) { this.subject = subject; }
}
