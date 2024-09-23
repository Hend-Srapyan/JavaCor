package homework.market.commands;

public interface AdminCommands {

    String LOGOUT = "0";
    String ADD_PRODUCT = "1";
    String REMOVE_PRODUCT_BY_ID = "2";
    String PRINT_PRODUCTS = "3";
    String PRINT_USERS = "4";
    String PRINT_ORDERS = "5";
    String CHANGE_ORDER_STATUS = "6";

    static void adminCommands() {
        System.out.println("Please input " + LOGOUT + " for LOGOUT");
        System.out.println("Please input " + ADD_PRODUCT + " for ADD_PRODUCT");
        System.out.println("Please input " + REMOVE_PRODUCT_BY_ID + " for REMOVE_PRODUCT_BY_ID");
        System.out.println("Please input " + PRINT_PRODUCTS + " for PRINT_PRODUCTS");
        System.out.println("Please input " + PRINT_USERS + " for PRINT_USERS");
        System.out.println("Please input " + PRINT_ORDERS + " for PRINT_ORDERS");
        System.out.println("Please input " + CHANGE_ORDER_STATUS + " for CHANGE_ORDER_STATUS");
    }
}
