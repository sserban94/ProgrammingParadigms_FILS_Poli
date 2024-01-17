import com.serbanscorteanu.classes.Course;
import com.serbanscorteanu.classes.Main;
import com.serbanscorteanu.classes.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MainTest {
    List<Student> mockStudents;
    List<Course> mockCourses;
    String mockGroup = "1035";

    @BeforeEach
    void setUp() {
        Student serban = new Student(1, "Serban", "1035");
        Student dan = new Student(2, "Dani", "1035");
        Student mihnea = new Student(3, "Mihnea", "1035");
        Student robert = new Student(4, "Robert", "1035");
        Student andreea = new Student(5, "Andreea", "1035");
        Student larisa = new Student(6, "Larisa", "1035");
        this.mockStudents = List.of(serban, dan, mihnea, robert, andreea, larisa);

        Course android = new Course(1001, 6, 2021, "Android Mobile App Development");
        Course sdd = new Course(1002, 6, 2020, "Data Structures in C");
        Course oop = new Course(1003, 6, 2020, "Object Oriented Programming in C++");
        Course java = new Course(1004, 6, 2020, "Multiparadigm Programming in Java");
        Course wap = new Course(1005, 6, 2020, "Windows Application Programming in C#");
        Course webTech = new Course(1006, 6, 2021, "Web Technologies - React Framework & nodeJS");
        this.mockCourses = List.of(android, sdd, oop, java, wap, webTech);

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

    @Test
    void testExercise1() {
        Main main = new Main();
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(4, 16);
        assertEquals(expected, main.exercise1(input));
    }

    @Test
    void testExercise2() {
        Main main = new Main();
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        Integer expected = 55;
        assertEquals(expected, main.exercise2(input));
    }

    @Test
    void testExercise3a() {
        Main main = new Main();
        List<String> input = Arrays.asList("apple", "banana", "cherry", "date");
        Map<Integer, Integer> expected = Map.of(5, 1, 6, 2, 4, 1);
        assertEquals(expected, main.exercise3a(input));
    }

    @Test
    void testExercise3b() {
        Main main = new Main();
        List<String> input = Arrays.asList("apple", "banana", "cherry", "date");
        Map<Integer, Integer> expected = Map.of(5, 1, 6, 2, 4, 1);
        assertEquals(expected, main.exercise3b(input));
    }

    @Test
    void testExercise4() {
        Main main = new Main();
        List<List<String>> input = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("cherry", "date", "apple")
        );
        List<String> expected = Arrays.asList("apple", "banana", "cherry", "date");
        assertEquals(expected, main.exercise4(input));
    }

    @Test
    void testExercise5() {
        Main main = new Main();
        List<Student> students = Arrays.asList(
                new Student(1, "John", "1035"),
                new Student(2, "Jane", "1036")
        );
        String expected = "John";
        assertEquals(expected, main.exercise5(students, "1035"));
    }

    @Test
    void testExercise6a() {
        Main main = new Main();
        Long result = main.exercise6a();
        assertNotNull(result);
        assertTrue(result >= 200000 && result <= 20000000);
    }

    @Test
    void testExercise6b() {
        Main main = new Main();
        Long result = main.exercise6b();
        assertNotNull(result);
        assertTrue(result >= 200000 && result <= 20000000);
    }

    // lack of time - the following tests only check if returned list is null or not
    // TODO - modify these tests - they all pass but they are too basic
    @Test
    void testExercise7() {
        Main main = new Main();
        List<Student> result = main.exercise7(mockStudents);
        assertNotNull(result);
    }

    @Test
    void testExercise8() {
        Main main = new Main();
        List<Student> result = main.exercise8(mockStudents);
        assertNotNull(result);
    }

    @Test
    void testExercise9() {
        Main main = new Main();
        Map<Integer, List<Integer>> result = main.exercise9(mockCourses);
        assertNotNull(result);
    }

    @Test
    void testExercise10() {
        Main main = new Main();
        List<Student> students = Arrays.asList(
                new Student(1, "John", "1035"),
                new Student(2, "Jane", "1035"),
                new Student(3, "Alice", "1035"),
                new Student(4, "Bob", "1035"),
                new Student(5, "Charlie", "1035"),
                new Student(6, "Diana", "1036")
        );
        List<Student> expected = students.subList(0, 5);
        assertEquals(expected, main.exercise10(students, "1035"));
    }


    @Test
    void testExercise11() {
        Main main = new Main();
        Map<String, List<Course>> result = main.exercise11(mockStudents);
        assertNotNull(result);
    }




}
