package com.episen.android.mem.back.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data               //getter setter
@AllArgsConstructor //Constructor with fields
@Builder            //Add builder
@NoArgsConstructor  //Constructor without field
public class Student {

    private static List<Student> studentList = new ArrayList<>();

    /**
     *
     * @return list of student
     */
    public static List<Student> getStudentList() {
        return studentList;
    }

    /**
     *
     * @param student to insert
     * @return student if correctly inserted
     */
    public static Student insertStudent(Student student) {
        student.setId(nextIndex);
        nextIndex++;
        studentList.add(student);
        return student.getId()==studentList.get(studentList.size()-1).getId() ?  studentList.get(studentList.size()-1) : null;
    }

    /**
     *
     * @param id of student to find
     * @return a student
     */
    public static Student getById(int id){
        for (Student s:studentList){
            if (s.id == id)
                return s;
        }
        return null;
    }

    static int nextIndex=1;
    int id;
    String age;
    String email;
    String firstName;
    String lastName;
    boolean redoublant;
    String group;
    String gender;

    /**
     *
     * @param id of Student to suppress
     * @return true if work and false if fail
     */
    public static boolean deleteStudent(int id) {
        for (Student student: studentList
        ) {
            if(student.getId()==id) {
                return studentList.remove(student);
            }
        }

        return false;

    }

    /**
     *
     * @param student to edit
     * @return edited student
     */
    public static Student editStudent(Student student) {
        for (Student student1: studentList
        ) {
            if(student.getId() == student1.getId()) {
                studentList.remove(student1);
                studentList.add(student);
                return student;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", redoublant='" + redoublant + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}