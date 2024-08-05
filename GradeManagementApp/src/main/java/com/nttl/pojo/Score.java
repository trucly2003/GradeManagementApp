/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ly Nguyen
 */
@Entity
@Table(name = "score")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Score.findAll", query = "SELECT s FROM Score s"),
    @NamedQuery(name = "Score.findByScoreId", query = "SELECT s FROM Score s WHERE s.scoreId = :scoreId"),
    @NamedQuery(name = "Score.findByFinal1", query = "SELECT s FROM Score s WHERE s.final1 = :final1"),
    @NamedQuery(name = "Score.findByMidterm", query = "SELECT s FROM Score s WHERE s.midterm = :midterm")})
public class Score implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "score_id")
    private Integer scoreId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "final")
    private BigDecimal final1;
    @Column(name = "midterm")
    private BigDecimal midterm;
    @Lob
    @Size(max = 1073741824)
    @Column(name = "other_grade")
    private String otherGrade;
    @JoinColumn(name = "enrollment_id", referencedColumnName = "enrollment_id")
    @ManyToOne
    private Enrollment enrollmentId;

    public Score() {
    }

    public Score(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public BigDecimal getFinal1() {
        return final1;
    }

    public void setFinal1(BigDecimal final1) {
        this.final1 = final1;
    }

    public BigDecimal getMidterm() {
        return midterm;
    }

    public void setMidterm(BigDecimal midterm) {
        this.midterm = midterm;
    }

    public String getOtherGrade() {
        return otherGrade;
    }

    public void setOtherGrade(String otherGrade) {
        this.otherGrade = otherGrade;
    }

    public Enrollment getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Enrollment enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scoreId != null ? scoreId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Score)) {
            return false;
        }
        Score other = (Score) object;
        if ((this.scoreId == null && other.scoreId != null) || (this.scoreId != null && !this.scoreId.equals(other.scoreId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nttl.pojo.Score[ scoreId=" + scoreId + " ]";
    }
    
}
