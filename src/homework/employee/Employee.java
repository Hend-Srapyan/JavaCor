package homework.employee;

import java.util.Objects;

public class Employee {

    private String name;
    private String surname;
    private String employeeID;
    private String companyName;
    private String position;
    private double salary;

    public Employee(String name, String surname, String employeeID, String companyName, String position, double salary) {
        this.name = name;
        this.surname = surname;
        this.employeeID = employeeID;
        this.companyName = companyName;
        this.position = position;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0 && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(employeeID, employee.employeeID) && Objects.equals(companyName, employee.companyName) && Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, employeeID, companyName, position, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name = " + name + '\'' +
                ", surname = " + surname + '\'' +
                ", employeeID = " + employeeID + '\'' +
                ", companyName = " + companyName + '\'' +
                ", position = " + position + '\'' +
                ", salary = " + salary +
                '}';
    }
}
