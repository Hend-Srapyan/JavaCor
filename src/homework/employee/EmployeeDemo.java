package homework.employee;

import homework.employee.model.Company;
import homework.employee.model.Employee;
import homework.employee.storage.CompanyStorage;
import homework.employee.storage.EmployeeStorage;

import java.util.Scanner;

public class EmployeeDemo implements EmployeeCommands {
    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeStorage employeeStorage = new EmployeeStorage();
    private static CompanyStorage companyStorage = new CompanyStorage();

    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            EmployeeCommands.printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
//                case ADD_COMPANY:
//                    addCompany();
//                    break;
//                case ADD_EMPLOYEE:
//                    addEmployee();
//                    break;
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

    private static void addCompany() {
        System.out.println("Please input Company id, name, address, age");
        String companyStr = scanner.nextLine();
        String[] companyArr = companyStr.split(",");
        if (companyArr.length == 4){
            String id = companyArr[0];
            if (companyStorage.getCompanyByID(id) == null){
                Company company = new Company();
                company.setId(id);
                company.setName(companyArr[1]);
                company.setAddress(companyArr[2]);
                company.setAge(Integer.parseInt(companyArr[3]));
                companyStorage.add(company);
                System.out.println("Company added!");
            }else {
                System.out.println("Company with id " + id + " already  exist");
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
