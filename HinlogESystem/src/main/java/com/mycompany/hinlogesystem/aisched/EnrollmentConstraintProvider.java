package com.mycompany.hinlogesystem.aisched;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;

public class EnrollmentConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory factory) {
        return new Constraint[]{
            avoidScheduleConflict(factory)
        };
    }

    private Constraint avoidScheduleConflict(ConstraintFactory factory) {
        return factory.forEachUniquePair(Enrollment.class)
            .filter((e1, e2) ->
                e1.getStudentId() == e2.getStudentId() &&
                e1.getSubject() != null &&
                e2.getSubject() != null &&
                e1.getSubject().conflictsWith(e2.getSubject()))
            .penalize("Schedule conflict", HardSoftScore.ONE_HARD);
    }
}
