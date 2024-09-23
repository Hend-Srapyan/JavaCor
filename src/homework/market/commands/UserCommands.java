package homework.market.commands;

public interface UserCommands {

    String LOGOUT = "0";
    String PRINT_ALL_PRODUCTS = "1";
    String BUY_PRODUCT = "2";
    String PRINT_MY_ORDERS = "3";
    String CANCEL_ORDER_BY_ID = "4";

    static void userCommands(){
        System.out.println("Please input " + LOGOUT + " for LOGOUT");
        System.out.println("Please input " + PRINT_ALL_PRODUCTS + " for PRINT_ALL_PRODUCTS");
        System.out.println("Please input " + BUY_PRODUCT + " for BUY_PRODUCT");
        System.out.println("Please input " + PRINT_MY_ORDERS + " for PRINT_MY_ORDERS");
        System.out.println("Please input " + CANCEL_ORDER_BY_ID + " for CANCEL_ORDER_BY_ID");
    }
}
