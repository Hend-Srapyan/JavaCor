package classwork.classwork7;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        System.out.println("Please input your name: ");
        student.setName(scanner.nextLine());
        System.out.println("Please input your surname: ");
        student.setSurname(scanner.nextLine());
        System.out.println("Please input your age: ");
        student.setAge(Integer.parseInt(scanner.nextLine()));
        System.out.println("Please input your phone number: ");
        student.setPhoneNumber(scanner.nextLine());
        System.out.println("Please input your lesson number: ");
        student.setLessonName(scanner.nextLine());

        System.out.println("Thank you " + student.getName() + " You have registered successfully. Your data is: ");

        student.print();



    }
}
