package edu.mum.cs.cs425.studentmgmt.Model;

import jakarta.persistence.*;

@Entity
public class Transcript {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transcriptId;

    @Column(nullable = false)
    private String degreeTitle;

    @OneToOne(mappedBy = "transcript", cascade = CascadeType.ALL)
    private Student student;

    // Constructors, Getters, and Setters
    public Transcript() {}

    public Transcript(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public Long getTranscriptId() { return transcriptId; }
    public void setTranscriptId(Long transcriptId) { this.transcriptId = transcriptId; }

    public String getDegreeTitle() { return degreeTitle; }
    public void setDegreeTitle(String degreeTitle) { this.degreeTitle = degreeTitle; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}
