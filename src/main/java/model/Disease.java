package model;

public class Disease {
    private String diseaseId;
    private String name;
    private int severity;
    private String fastaSequence;

    public Disease(String diseaseId, String name, int severity, String fastaSequence) {
        this.diseaseId = diseaseId;
        this.name = name;
        this.severity = severity;
        this.fastaSequence = fastaSequence;
    }

    public String getFastaSequence() {
        return fastaSequence;
    }

    public void setFastaSequence(String fastaSequence) {
        this.fastaSequence = fastaSequence;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(String diseaseId) {
        this.diseaseId = diseaseId;
    }
}
