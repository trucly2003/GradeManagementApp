/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nttl.repository;

import com.nttl.pojo.Course;
import com.nttl.pojo.Semester;
import java.util.List;

/**
 *
 * @author Ly Nguyen
 */
public interface SemesterRepository {
  List<Semester> getSemester();
  Semester getSemesterById(int id);
}
