package homework.employee;

import java.util.Scanner;

public class EmployeeDemo implements EmployeeCommands {
    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeStorage employeeStorage = new EmployeeStorage();

    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            EmployeeCommands.printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_EMPLOYEE:
                    addEmployee();
                    break;
                case PRINT_ALL_EMPLOYEE:
                    employeeStorage.print();
                    break;
                case SEARCH_EMPLOYEE_BY_EMPLOYEE_ID:
                    searchEmployeeByEmployeeId();
                    break;
                case SEARCH_EMPLOYEE_BY_COMPANY_NAME:
                    searchEmployeeByCompanyName();
                    break;
            }
        }
    }

    private static void addEmployee() {
        System.out.println("Please input employee name");
        String name = scanner.nextLine();
        System.out.println("Please input employee surname");
        String surname = scanner.nextLine();
        System.out.println("Please input employee id");
        String employeeID = scanner.nextLine();
        System.out.println("Please input company name");
        String companyName = scanner.nextLine();
        System.out.println("Please input employee position");
        String position = scanner.nextLine();
        System.out.println("Please input employee salary");
        double salary = Double.parseDouble(scanner.nextLine());
        Employee employee = new Employee(name, surname, employeeID, companyName, position, salary);
        Employee employeeById = employeeStorage.getEmployeeByID(employeeID);
        if (employeeById == null) {
            employeeStorage.add(employee);
            System.out.println("Employee added!");
        } else {
            System.out.println("Employee with " + employeeID + " already exists!");
        }
    }

    private static void searchEmployeeByEmployeeId() {
        employeeStorage.print();
        System.out.println("Please input employee Id");
        String id = scanner.nextLine();
        employeeStorage.searchEmployeeByEmployeeId(id);
    }

    private static void searchEmployeeByCompanyName() {
        employeeStorage.print();
        System.out.println("Please input company name");
        String name = scanner.nextLine();
        employeeStorage.searchEmployeeByCompanyName(name);
    }
}
