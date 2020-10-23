package com.episen.AndroidApi.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        Random random = new Random();
        String randomId = String.valueOf(random.nextInt(400));
        Student student = Student.builder()
                .redoublant("true")
                .group("ing1")
                .first_name("Michel")
                .last_name("Blanc")
                .gender("homme")
                .age("55")
                .email("test@gmail.com")
                .id(randomId).build();
        //insertstudent(student);
        return studentList;
    }

    /**
     *
     * @param student
     * @return student if correctly inserted
     */
    public static Student insertStudent(Student student) {
        student.setId(String.valueOf(nextIndex));
        nextIndex++;
        studentList.add(student);
        return student.getId()==studentList.get(studentList.size()-1).getId() ?  studentList.get(studentList.size()-1) : null;
    }

    /**
     *
     * @param id of student to finc
     * @return a student
     */
    public static Student getById(int id){
        for (Student s:studentList){
            if (Integer.parseInt(s.id) == id)
                return s;
        }
        return null;
    }

    static int nextIndex=1;
    String id;
    String age;
    String email;
    String first_name;
    String last_name;
    String redoublant;
    String group;
    String gender;

    /**
     *
     * @param id of Student to suppress
     * @return true if work and false if fail
     */
    public static boolean deleteStudent(String id) {
        for (Student student: studentList
             ) {
            if(student.getId().equals(id)) {
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
            if(student.getId().equals(student1.getId())) {
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
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", redoublant='" + redoublant + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
