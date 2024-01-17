package com.serbanscorteanu.classes;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    // going with getters and setters for everything - not enough time to keep Encapsulation - will come back
    // also could automate courses and student enrollment
    public static void main(String[] args) {
        Student serban = new Student(1, "Serban", "1035");
        Student dan = new Student(2, "Dani", "1035");
        Student mihnea = new Student(3, "Mihnea", "1035");
        Student robert = new Student(4, "Robert", "1035");
        Student andreea = new Student(5, "Andreea", "1035");
        Student larisa = new Student(6, "Larisa", "1035");
        Course android = new Course(1001, 6, 2021, "Android Mobile App Development");
        Course sdd = new Course(1002, 6, 2020, "Data Structures in C");
        Course oop = new Course(1003, 6, 2020, "Object Oriented Programming in C++");
        Course java = new Course(1004, 6, 2020, "Multiparadigm Programming in Java");
        Course wap = new Course(1005, 6, 2020, "Windows Application Programming in C#");
        Course webTech = new Course(1006, 6, 2021, "Web Technologies - React Framework & nodeJS");

        android.addNewStudent(serban);
        android.addNewStudent(dan);
        android.addNewStudent(mihnea);
        android.addNewStudent(larisa);

        sdd.addNewStudent(robert);
        sdd.addNewStudent(andreea);
        sdd.addNewStudent(serban);
        sdd.addNewStudent(dan);
        sdd.addNewStudent(mihnea);

        oop.addNewStudent(serban);
        oop.addNewStudent(robert);

        java.addNewStudent(serban);
        java.addNewStudent(dan);
        java.addNewStudent(mihnea);

        wap.addNewStudent(andreea);
        wap.addNewStudent(robert);
        wap.addNewStudent(mihnea);
        wap.addNewStudent(dan);

        webTech.addNewStudent(robert);
        webTech.addNewStudent(andreea);
        webTech.addNewStudent(larisa);


    }

    public List<Integer> exercise1(List<Integer> integerList) {
        return integerList.stream().filter(x -> x % 2 == 0).map(x -> (int) Math.pow(x, 2)).toList();
    }

    public Integer exercise2(List<Integer> integerList) {
//        return integerList.stream().map(x -> (int) Math.pow(x, 2)).reduce(0, (sum, x) -> sum + x);
        // better yet -> method reference instead of lambda
        return integerList.stream().map(x -> (int) Math.pow(x, 2)).reduce(0, Integer::sum);
    }

    public Map<Integer, Integer> exercise3a(List<String> stringList) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String str : stringList) {
            // if it already has this key - the str length
            if (map.containsKey(str.length())) {
                // +1 for the value
                map.put(str.length(), map.get(str.length()) + 1);
            } else {
                // else put 1 as the value - first occurrence
                map.put(str.length(), 1);
            }
        }
        return map;
    }

    public Map<Integer, Integer> exercise3b(List<String> stringList) {
        Map<Integer, Integer> map = new HashMap<>();
        stringList.stream().forEach((x) -> {
            if (map.containsKey(x.length())) {
                // +1 for the value
                map.put(x.length(), map.get(x.length()) + 1);
            } else {
                // else put 1 as the value - first occurrence
                map.put(x.length(), 1);
            }
        });
        return map;
    }

    public List<String> exercise4(List<List<String>> stringListOfLists) {
        Set<String> tempStringSet = stringListOfLists.stream().flatMap(Collection::stream).collect(Collectors.toSet());
        return tempStringSet.stream().sorted().toList();
    }

    public String exercise5(List<Student> students, String group) {
        return students.stream().filter(student -> student.getGroup().equals(group))
                .map(Student::getName)
                .collect(Collectors.joining(","));
    }

    // for over 100.000 integers I guess a Long would be safer
    public Long exercise6a() {
        int min = 1;
        int max = 100;
        int range = max - min;
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 200000; i++) {
            // why?
            // baeldung explanation
            // 0.0 * (max - min) + min => min                         Lowest value possible here = min
            // 1.0 * (max - min) + min => max - min + min => max      Highest value possible here = max
            integerList.add((int) ((Math.random() * range) + min));
        }
        return integerList
                .stream()
                .mapToLong(Integer::longValue)
                .reduce(Long::sum)
                .orElse(0);
    }

    public Long exercise6b() {
        int min = 1;
        int max = 100;
        int range = max - min;
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 200000; i++) {
            // why?
            // baeldung explanation
            // 0.0 * (max - min) + min => min                         Lowest value possible here = min
            // 1.0 * (max - min) + min => max - min + min => max      Highest value possible here = max
            integerList.add((int) ((Math.random() * range) + min));
        }
        return integerList.stream().parallel()
                .mapToLong(Integer::longValue)
                .reduce(Long::sum)
                .orElse(0);
    }

    public List<Student> exercise7(List<Student> students) {
//        return students.stream().filter(student -> {
//            for (Course course : student.courses) {
//                if (course.getCreditPoints() > 5) {
//                    return true;
//                }
//            }
//            return false;
//        }).toList();
        return students.stream().filter(student -> student.courses.stream().anyMatch(course -> course.getCreditPoints() > 5)).toList();
    }

    public List<Student> exercise8(List<Student> students) {
//        return students.stream().filter(student -> {
//            int totalCreditPoints = 0;
//            for (Course course : student.courses) {
//                totalCreditPoints += course.getCreditPoints();
//            }
//            if (totalCreditPoints > 30){
//                return true;
//            }
//            return false;
//        }).toList();
        return students
                .stream()
                .filter(student -> student.courses.stream()
                        .map(Course::getCreditPoints)
                        .reduce(0, Integer::sum) > 30
                )
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Integer>> exercise9(List<Course> courses) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (Course course : courses) {
            map.put(course.getCourseId(), course.students.stream().map(Student::getStudentId).toList());
        }
        return map;
    }

    public List<Student> exercise10(List<Student> students, String group) {
        return students.stream().filter(student -> student.getGroup().equals(group)).limit(5).toList();
    }

    public Map<String, List<Course>> exercise11(List<Student> students) {
        Map<String, List<Course>> map = new HashMap<>();
        for (Student student : students){
            String group = student.getGroup();
            if (!map.containsKey(group)) {
                map.put(group, student.courses);
            } else {
                map.put(group, Stream.concat(map.get(group).stream(), student.courses.stream()).toList());
            }
        }
        return map;
    }
}
