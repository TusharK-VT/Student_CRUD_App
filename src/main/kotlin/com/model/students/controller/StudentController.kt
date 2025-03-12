package com.model.students.controller

import com.model.students.entity.Student
import com.model.students.service.StudentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/students")
class StudentController (private val studentService: StudentService) {

    @GetMapping
    fun getAllStudents(): List<Student> = studentService.getAllStudents()

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: Long): ResponseEntity<Student> {
        val student = studentService.getStudentById(id)
        return if (student != null) {
            ResponseEntity.ok(student)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createStudent(@RequestBody student: Student): Student = studentService.createStudent(student)

    @PutMapping("/{id}")
    fun updateStudent(@PathVariable id: Long, @RequestBody student: Student): ResponseEntity<Student> {
        val updatedStudent = studentService.updateStudentById(id, student)
        return if (updatedStudent != null) {
            ResponseEntity.ok(updatedStudent)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Long): ResponseEntity<Void> {
            return if (studentService.getStudentById(id) != null) {
                studentService.deleteStudent(id)
                ResponseEntity.noContent().build()
            } else {
                ResponseEntity.notFound().build()
            }
        }
    }
