package ch.bfh.bti7081.s2018.green.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;

@Entity
public class JournalEntry {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    @OrderBy("created asc")
    private Date created;

    @OneToOne
    @JoinColumn(name = "authorId", nullable = false)
    private Staff staff;

    @OneToOne
    @JoinColumn(name = "patientId", nullable = false)
    private Patient patient;

    @PrePersist
    protected void onCreate() {
    	created = new Date();
    }
    public JournalEntry() {
        // required by JPA
    }

	public JournalEntry(String content, Patient patient, Staff staff) {
		this.content = content;
		this.staff = staff;
		this.patient = patient;
	}

	public Integer getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Staff getStaff() {
		return staff;
	}

	public Patient getPatient() {
		return patient;
	}

}