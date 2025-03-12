package com.model.students.service

import com.model.students.entity.Student
import com.model.students.repo.StudentRepository
import org.springframework.stereotype.Service


@Service
class StudentService (private val studentRepository: StudentRepository) {


    fun getAllStudents(): List<Student> {
        return studentRepository.findAll()
    }

    fun getStudentById(id: Long): Student? = studentRepository.findById(id).orElse(null)

    fun createStudent(student: Student): Student {

     return   studentRepository.save(student)

    }

    fun updateStudentById(id: Long, student: Student): Student? {
        return if (studentRepository.existsById(id)) {
            studentRepository.save(student.copy(id = id))
        } else {
            null
        }
    }

    fun deleteStudent(id: Long) {
        studentRepository.deleteById(id)
    }
}