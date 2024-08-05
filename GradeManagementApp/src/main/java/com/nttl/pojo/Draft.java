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
@Table(name = "draft")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Draft.findAll", query = "SELECT d FROM Draft d"),
    @NamedQuery(name = "Draft.findByDraftId", query = "SELECT d FROM Draft d WHERE d.draftId = :draftId"),
    @NamedQuery(name = "Draft.findByMidterm", query = "SELECT d FROM Draft d WHERE d.midterm = :midterm"),
    @NamedQuery(name = "Draft.findByFinal1", query = "SELECT d FROM Draft d WHERE d.final1 = :final1")})
public class Draft implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "draft_id")
    private Integer draftId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "midterm")
    private BigDecimal midterm;
    @Column(name = "final")
    private BigDecimal final1;
    @Lob
    @Size(max = 1073741824)
    @Column(name = "other_grade")
    private String otherGrade;
    @JoinColumn(name = "enrollment_id", referencedColumnName = "enrollment_id")
    @ManyToOne
    private Enrollment enrollmentId;

    public Draft() {
    }

    public Draft(Integer draftId) {
        this.draftId = draftId;
    }

    public Integer getDraftId() {
        return draftId;
    }

    public void setDraftId(Integer draftId) {
        this.draftId = draftId;
    }

    public BigDecimal getMidterm() {
        return midterm;
    }

    public void setMidterm(BigDecimal midterm) {
        this.midterm = midterm;
    }

    public BigDecimal getFinal1() {
        return final1;
    }

    public void setFinal1(BigDecimal final1) {
        this.final1 = final1;
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
        hash += (draftId != null ? draftId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Draft)) {
            return false;
        }
        Draft other = (Draft) object;
        if ((this.draftId == null && other.draftId != null) || (this.draftId != null && !this.draftId.equals(other.draftId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nttl.pojo.Draft[ draftId=" + draftId + " ]";
    }
    
}
