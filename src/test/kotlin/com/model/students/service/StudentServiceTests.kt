package com.model.students.service

import com.model.students.entity.Student
import com.model.students.repo.StudentRepository
import org.junit.jupiter.api.Disabled
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

@SpringBootTest
class StudentServiceTests @Autowired constructor (
    studentRepository: StudentRepository
) {
    private val studentService = StudentService(studentRepository)


    @Test
    fun `test create student`() {
        val student = Student(name = "tushar", email = "tushar@123")

        val createdStudent = studentService.createStudent(student)
        assertNotNull(createdStudent)
        assertEquals("tushar", createdStudent.name)

    }

    @Disabled
    @Test
    fun `test get student by id`()
    {
        val student = Student(name="tushar",email="tushar@123")
        val createdStudent = studentService.createStudent(student)
        val retrivedStudent = studentService.getStudentById(createdStudent.id!!)
        assertNotNull(createdStudent)
        assertEquals("tushar", createdStudent.name)

    }

    @Disabled
    @Test
    fun `test get all students`()
    {
        val student1 = Student(name="java",email="java@123")
        val student2 = Student(name="Kotlin",email="Kot@123")

        val createdStudent1 = studentService.createStudent(student1)
        val createdStudent2 = studentService.createStudent(student2)
        val allStudents = studentService.getAllStudents()

        assertEquals(2,allStudents.size)

    }

    @Disabled
    @Test
    fun `test update student`() {
        val student = Student(name="java",email="java@123")
        val createdStudent = studentService.createStudent(student)

        val updatedStudent = Student(name = "Kotlin", email="kot@123",id=createdStudent.id)
        val result = studentService.updateStudentById(createdStudent.id!!, updatedStudent)

        assertNotNull(result)
        assertEquals("Kotlin", result!!.name)
        assertEquals("kot@123", result.email)
    }

    @Disabled
    @Test
    fun `test delete student`()
    {
        val student = Student(name="Kotlin", email ="kotlin@123")
        val createdStudent = studentService.createStudent(student)

        studentService.deleteStudent(createdStudent.id!!)
        val retrivedStudent = studentService.getStudentById(createdStudent.id!!)

        assertNull(retrivedStudent)

    }











}
