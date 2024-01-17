package com.serbanscorteanu.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
    private int studentId;
    private String name;
    private String group;
    protected List<Course> courses;

    public Student(int studentId, String name, String group) {
        this.studentId = studentId;
        this.name = name;
        this.group = group;
        this.courses = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

//    public List<Course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(List<Course> courses) {
//        this.courses = courses;
//    }

    public void addCourse(Course newCourse) {
        if (this.courses.contains(newCourse)){
            return;
        }
        if (!newCourse.students.contains(this)){
            newCourse.students.add(this);
        }
        this.courses.add(newCourse);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId && Objects.equals(name, student.name) && Objects.equals(group, student.group) && Objects.equals(courses, student.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, name, group, courses);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", courses=" + courses +
                '}';
    }
}
