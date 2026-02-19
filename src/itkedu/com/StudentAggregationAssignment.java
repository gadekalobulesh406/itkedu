package itkedu.com;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class StudentAggregationAssignment {

    //  Student Class
    static class Student {
        private String name;
        private Map<String, Integer> subjects; // subject -> grade

        public Student(String name, Map<String, Integer> subjects) {
            this.name = name;
            this.subjects = subjects;
        }

        public Map<String, Integer> getSubjects() {
            return subjects;
        }
    }

    public static void main(String[] args) {

        //  Create Students
        List<Student> students = Arrays.asList(
                new Student("Alice", Map.of(
                        "Math", 90,
                        "English", 85,
                        "Physics", 88)),

                new Student("Bob", Map.of(
                        "Math", 78,
                        "English", 82,
                        "Physics", 91)),

                new Student("Charlie", Map.of(
                        "Math", 95,
                        "English", 87,
                        "Physics", 84))
        );

        // 3 Parallel Stream Aggregation
        ConcurrentMap<String, Double> averageBySubject =
                students.parallelStream()
                        .flatMap(student -> student.getSubjects().entrySet().stream())
                        .collect(Collectors.groupingByConcurrent(
                                Map.Entry::getKey,
                                Collectors.averagingInt(Map.Entry::getValue)
                        ));

        //  Output Result
        System.out.println("Average Grade per Subject:");
        averageBySubject.forEach((subject, avg) ->
                System.out.println(subject + " -> " + avg));
    }
}

