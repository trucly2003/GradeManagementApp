/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.pojo;

import java.io.Serializable;
import java.util.Set;
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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ly Nguyen
 */
@Entity
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByCourseId", query = "SELECT c FROM Course c WHERE c.courseId = :courseId"),
    @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "course_id")
    private Integer courseId;

    @Basic(optional = false)
    @NotNull(message = "{course.name.errMsg}")
    @Size(min = 5, max = 100, message = "Tên khóa học phải có độ dài từ 5 đến 100 ký tự")
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "courseId")
    private Set<Forum> forumSet;

    @JoinColumn(name = "semester_id", referencedColumnName = "semester_id")
    @ManyToOne
    private Semester semesterId;

    @JoinColumn(name = "lecturer_id", referencedColumnName = "user_id")
    @ManyToOne
    private User lecturerId;

    @OneToMany(mappedBy = "courseId")
    private Set<Enrollment> enrollmentSet;

    @Size(max = 255, message = "{course.description.size}")
    @Column(name = "description")
    private String description;

    @Min(value = 1, message = "{course.credits.min}")
    @Column(name = "credits")
    private int credits;


    public Course() {
    }

    public Course(Integer courseId) {
        this.courseId = courseId;
    }

    public Course(Integer courseId, String name) {
        this.courseId = courseId;
        this.name = name;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Set<Forum> getForumSet() {
        return forumSet;
    }

    public void setForumSet(Set<Forum> forumSet) {
        this.forumSet = forumSet;
    }

    public Semester getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Semester semesterId) {
        this.semesterId = semesterId;
    }

    public User getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(User lecturerId) {
        this.lecturerId = lecturerId;
    }

    @XmlTransient
    public Set<Enrollment> getEnrollmentSet() {
        return enrollmentSet;
    }

    public void setEnrollmentSet(Set<Enrollment> enrollmentSet) {
        this.enrollmentSet = enrollmentSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseId != null ? courseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nttl.pojo.Course[ courseId=" + courseId + " ]";
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * @param credits the credits to set
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

}
