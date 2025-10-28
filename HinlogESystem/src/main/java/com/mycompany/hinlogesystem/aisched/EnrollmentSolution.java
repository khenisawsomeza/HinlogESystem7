package com.mycompany.hinlogesystem.aisched;

import java.util.List;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@PlanningSolution
public class EnrollmentSolution {

    @ProblemFactCollectionProperty
    private List<Subject> subjectList;

    @PlanningEntityCollectionProperty
    private List<Enrollment> enrollmentList;

    private HardSoftScore score;

    // --- Getters & Setters ---
    public List<Subject> getSubjectList() { return subjectList; }
    public void setSubjectList(List<Subject> subjectList) { this.subjectList = subjectList; }

    public List<Enrollment> getEnrollmentList() { return enrollmentList; }
    public void setEnrollmentList(List<Enrollment> enrollmentList) { this.enrollmentList = enrollmentList; }

    public HardSoftScore getScore() { return score; }
    public void setScore(HardSoftScore score) { this.score = score; }
}
