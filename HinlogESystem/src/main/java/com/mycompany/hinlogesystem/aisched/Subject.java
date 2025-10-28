package com.mycompany.hinlogesystem.aisched;

public class Subject {

    private int id;
    private String code;
    private String description;
    private String schedule; // e.g. "MWF 09:00-10:30" or "TTH 13:00-14:30"

    public Subject() {}

    public Subject(int id, String code, String description, String schedule) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.schedule = schedule;
    }

    // --- Getters & Setters ---
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSchedule() { return schedule; }
    public void setSchedule(String schedule) { this.schedule = schedule; }

    // --- Conflict checker ---
    public boolean conflictsWith(Subject other) {
        if (other == null || this.schedule == null) return false;

        String[] thisParts = this.schedule.split(" ");
        String[] otherParts = other.schedule.split(" ");
        if (thisParts.length < 2 || otherParts.length < 2) return false;

        String thisDays = thisParts[0];
        String otherDays = otherParts[0];
        String thisTime = thisParts[1];
        String otherTime = otherParts[1];

        // Day overlap
        boolean dayOverlap = false;
        for (char c : thisDays.toCharArray()) {
            if (otherDays.indexOf(c) >= 0) {
                dayOverlap = true;
                break;
            }
        }
        if (!dayOverlap) return false;

        // Time overlap
        String[] thisRange = thisTime.split("-");
        String[] otherRange = otherTime.split("-");
        int thisStart = Integer.parseInt(thisRange[0].replace(":", ""));
        int thisEnd = Integer.parseInt(thisRange[1].replace(":", ""));
        int otherStart = Integer.parseInt(otherRange[0].replace(":", ""));
        int otherEnd = Integer.parseInt(otherRange[1].replace(":", ""));

        return thisStart < otherEnd && otherStart < thisEnd;
    }
}
