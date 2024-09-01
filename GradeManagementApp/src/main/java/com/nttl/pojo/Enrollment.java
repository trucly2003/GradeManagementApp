/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author Ly Nguyen
 */
@Entity
@Table(name = "enrollment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enrollment.findAll", query = "SELECT e FROM Enrollment e"),
    @NamedQuery(name = "Enrollment.findByEnrollmentId", query = "SELECT e FROM Enrollment e WHERE e.enrollmentId = :enrollmentId"),
    @NamedQuery(name = "Enrollment.findByLocked", query = "SELECT e FROM Enrollment e WHERE e.locked = :locked")})
public class Enrollment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "enrollment_id")
    private Integer enrollmentId;
    @Column(name = "locked")
    private Boolean locked;
    @OneToMany(mappedBy = "enrollmentId")
    private Collection<Score> scoreCollection;
    @OneToMany(mappedBy = "enrollmentId")
    private Collection<Draft> draftCollection;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    @ManyToOne
    private Course courseId;
    @JoinColumn(name = "student_id", referencedColumnName = "user_id")
    @ManyToOne
    private User studentId;

    public Enrollment() {
    }

    public Enrollment(Integer enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Integer getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Integer enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    @XmlTransient
    public Collection<Score> getScoreCollection() {
        return scoreCollection;
    }

    public void setScoreCollection(Collection<Score> scoreCollection) {
        this.scoreCollection = scoreCollection;
    }

    @XmlTransient
    public Collection<Draft> getDraftCollection() {
        return draftCollection;
    }

    public void setDraftCollection(Collection<Draft> draftCollection) {
        this.draftCollection = draftCollection;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public User getStudentId() {
        return studentId;
    }

    public void setStudentId(User studentId) {
        this.studentId = studentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enrollmentId != null ? enrollmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enrollment)) {
            return false;
        }
        Enrollment other = (Enrollment) object;
        if ((this.enrollmentId == null && other.enrollmentId != null) || (this.enrollmentId != null && !this.enrollmentId.equals(other.enrollmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nttl.pojo.Enrollment[ enrollmentId=" + enrollmentId + " ]";
    }
    
}
