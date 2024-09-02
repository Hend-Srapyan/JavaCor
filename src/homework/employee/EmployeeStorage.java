package homework.employee;

public class EmployeeStorage {

    private Employee[] employees = new Employee[10];
    private int size;

    public void add(Employee employee) {
        if (employees.length == size) {
            extendStorage();
        }
        employees[size++] = employee;
    }

    private void extendStorage() {
        Employee[] tmp = new Employee[size + 10];
        System.arraycopy(employees, 0, tmp, 0, size);
        employees = tmp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }


    public Employee getEmployeeByID(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equals(id)) {
                return employees[i];
            }
        }
        return null;
    }

    public void searchEmployeeByEmployeeId(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equals(id)) {
                System.out.println(employees[i]);
            }
        }
    }

    public void searchEmployeeByCompanyName(String keyword) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getCompanyName().contains(keyword)) {
                System.out.println(employees[i]);
            }
        }
    }


}
