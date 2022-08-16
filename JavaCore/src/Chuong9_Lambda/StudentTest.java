package Chuong9_Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StudentTest {
    public static List<Student> filter(List<Student> students,Filter<Student> pred){
        List list = new ArrayList();
        for (Student sv:students) {
            if (pred.vaid(sv)){
                list.add(sv);
            };
        };
        return list;
    }

    public static void main(String[] args) {
        example2();
    }

    private static void example2() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Tran Van A",23));
        students.add(new Student("Nguyen Thi B", 34));
        students.add(new Student("Nguyen Thi C", 45));
        students.add(new Student("Ta Van C",46));

        //CÁCH 1
//             students.stream()
//                .filter(student -> student.getAge() >= 30)
//                .forEach(student ->
//                        {System.out.println(student);}
//                );

        //CÁCH 2
//        Collections.sort(students, (Student student1,Student student2) -> {
//           return student1.getAge() - student2.getAge();
//        });
//        students.forEach(student -> System.out.println(student));

        //CÁCH 3
       students.stream()
               .sorted((student1, student2) -> student1.getAge()-student2.getAge())
               .forEach(student -> System.out.println(student));

    }

    private static void example1() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Tran Van A",23));
        students.add(new Student("Nguyen Thi B", 34));
        students.add(new Student("Nguyen Thi C", 45));
        students.add(new Student("Ta Van C",46));

        Filter<Student> older = student -> student.getAge() >= 30;
        List<Student> filtered = filter(students,older);

        for (Student student:filtered) {
            System.out.println(student);
        }

        filtered.forEach(sv -> System.out.println(sv));
    }
}
