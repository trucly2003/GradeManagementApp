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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ly Nguyen
 */
@Entity
@Table(name = "semester")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Semester.findAll", query = "SELECT s FROM Semester s"),
    @NamedQuery(name = "Semester.findBySemesterId", query = "SELECT s FROM Semester s WHERE s.semesterId = :semesterId"),
    @NamedQuery(name = "Semester.findByName", query = "SELECT s FROM Semester s WHERE s.name = :name")})
public class Semester implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "semester_id")
    private Integer semesterId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "semesterId")
    private Set<Course> courseSet;

    public Semester() {
    }

    public Semester(Integer semesterId) {
        this.semesterId = semesterId;
    }

    public Semester(Integer semesterId, String name) {
        this.semesterId = semesterId;
        this.name = name;
    }

    public Integer getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Integer semesterId) {
        this.semesterId = semesterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (semesterId != null ? semesterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Semester)) {
            return false;
        }
        Semester other = (Semester) object;
        if ((this.semesterId == null && other.semesterId != null) || (this.semesterId != null && !this.semesterId.equals(other.semesterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nttl.pojo.Semester[ semesterId=" + semesterId + " ]";
    }
    
}
