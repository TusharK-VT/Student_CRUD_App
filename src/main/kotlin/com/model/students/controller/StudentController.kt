package com.model.students.controller

import com.model.students.entity.Student
import com.model.students.service.StudentService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/students")
class StudentController(private val studentService: StudentService) {

    @GetMapping
    fun viewStudents(model: Model): String {
        model.addAttribute("students", studentService.getAllStudents())
        model.addAttribute("student", Student())
        return "students"
    }

    @PostMapping
    fun createOrUpdateStudent(@ModelAttribute student: Student): String {
        if (student.id == null) {
            studentService.createStudent(student)
        } else {
            studentService.updateStudentById(student.id!!, student)
        }
        return "redirect:/students"
    }

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: Long): ResponseEntity<Student> {
        val student = studentService.getStudentById(id)
        return if (student != null) {
            ResponseEntity.ok(student)
        } else {
            ResponseEntity.notFound().build()
        }
    }



}
