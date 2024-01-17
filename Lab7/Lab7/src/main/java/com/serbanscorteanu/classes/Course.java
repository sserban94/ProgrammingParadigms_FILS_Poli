package com.serbanscorteanu.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {
    private int courseId;
    private int creditPoints;
    private int year;
    private String fullName;
    protected List<Student> students;

    public Course(int courseId, int creditPoints, int year, String fullName) {
        this.courseId = courseId;
        this.creditPoints = creditPoints;
        this.year = year;
        this.fullName = fullName;
        this.students = new ArrayList<>();
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(int creditPoints) {
        this.creditPoints = creditPoints;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

//    public List<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }

    public void addNewStudent(Student student) {
        if (this.students.contains(student)) {
            return;
        }
        if(!student.courses.contains(this)){
            student.addCourse(this);
        }
        this.students.add(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseId == course.courseId && creditPoints == course.creditPoints && year == course.year && Objects.equals(fullName, course.fullName) && Objects.equals(students, course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, creditPoints, year, fullName, students);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", creditPoints=" + creditPoints +
                ", year=" + year +
                ", fullName='" + fullName + '\'' +
                ", students=" + students +
                '}';
    }
}
