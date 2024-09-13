package homework.employee;

public interface EmployeeCommands {

    String EXIT = "0";
    String ADD_COMPANY = "1";
    String ADD_EMPLOYEE = "1";
    String PRINT_ALL_EMPLOYEE = "2";
    String SEARCH_EMPLOYEE_BY_EMPLOYEE_ID = "3";
    String SEARCH_COMPANY_BY_COMPANY_ID = "3";
    String SEARCH_EMPLOYEE_BY_COMPANY_NAME = "4";


    static void printCommands() {
        System.out.println("Please input " + EXIT + " for EXIT");
        System.out.println("Please input " + ADD_COMPANY + " for ADD_COMPANY");
        System.out.println("Please input " + ADD_EMPLOYEE + " for ADD_EMPLOYEE");
        System.out.println("Please input " + PRINT_ALL_EMPLOYEE + " for PRINT_ALL_EMPLOYEE");
        System.out.println("Please input " + SEARCH_EMPLOYEE_BY_EMPLOYEE_ID + " for SEARCH_EMPLOYEE_BY_EMPLOYEE_ID");
        System.out.println("Please input " + SEARCH_COMPANY_BY_COMPANY_ID + " for SEARCH_COMPANY_BY_COMPANY_ID");
        System.out.println("Please input " + SEARCH_EMPLOYEE_BY_COMPANY_NAME + " for SEARCH_EMPLOYEE_BY_COMPANY_NAME");
    }
}
