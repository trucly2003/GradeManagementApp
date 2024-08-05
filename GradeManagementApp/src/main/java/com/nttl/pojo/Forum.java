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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ly Nguyen
 */
@Entity
@Table(name = "forum")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Forum.findAll", query = "SELECT f FROM Forum f"),
    @NamedQuery(name = "Forum.findByForumId", query = "SELECT f FROM Forum f WHERE f.forumId = :forumId"),
    @NamedQuery(name = "Forum.findByName", query = "SELECT f FROM Forum f WHERE f.name = :name")})
public class Forum implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "forum_id")
    private Integer forumId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    @ManyToOne
    private Course courseId;
    @OneToMany(mappedBy = "forumId")
    private Set<Post> postSet;

    public Forum() {
    }

    public Forum(Integer forumId) {
        this.forumId = forumId;
    }

    public Forum(Integer forumId, String name) {
        this.forumId = forumId;
        this.name = name;
    }

    public Integer getForumId() {
        return forumId;
    }

    public void setForumId(Integer forumId) {
        this.forumId = forumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    @XmlTransient
    public Set<Post> getPostSet() {
        return postSet;
    }

    public void setPostSet(Set<Post> postSet) {
        this.postSet = postSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (forumId != null ? forumId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Forum)) {
            return false;
        }
        Forum other = (Forum) object;
        if ((this.forumId == null && other.forumId != null) || (this.forumId != null && !this.forumId.equals(other.forumId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nttl.pojo.Forum[ forumId=" + forumId + " ]";
    }
    
}
