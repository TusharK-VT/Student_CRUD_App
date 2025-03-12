package com.model.students.repo

import com.model.students.entity.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student,Long>