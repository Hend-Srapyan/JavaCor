package homework.market;

import homework.market.commands.AdminCommands;
import homework.market.commands.MarketCommands;
import homework.market.commands.UserCommands;
import homework.market.exception.OutOfStockException;
import homework.market.model.order.Order;
import homework.market.model.order.OrderStatus;
import homework.market.model.order.PaymentMethod;
import homework.market.model.product.Product;
import homework.market.model.product.ProductType;
import homework.market.model.user.User;
import homework.market.model.user.UserType;
import homework.market.storage.OrderStorage;
import homework.market.storage.ProductStorage;
import homework.market.storage.UserStorage;


import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


public class MarketDemo implements MarketCommands, AdminCommands, UserCommands {
    private static final Scanner scanner = new Scanner(System.in);
    private static final OrderStorage orderStorage = new OrderStorage();
    private static final ProductStorage productStorage = new ProductStorage();
    private static final UserStorage userStorage = new UserStorage();
    private static final AtomicInteger userIdNumber = new AtomicInteger(100);
    private static final AtomicInteger productIdNumber = new AtomicInteger(100);
    private static final AtomicInteger orderIdNumber = new AtomicInteger(100);
    private static User currentUser;

    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            if (currentUser == null) {
                MarketCommands.marketCommands();
                String marketCommands = scanner.nextLine();
                switch (marketCommands) {
                    case LOGIN -> login();
                    case REGISTER -> register();
                    case EXIT -> isRun = false;
                }
            } else {
                if (currentUser.getUserType().equals(UserType.USER)) {
                    UserCommands.userCommands();
                    String commands = scanner.nextLine();
                    switch (commands) {
                        case UserCommands.LOGOUT -> logout();
                        case PRINT_ALL_PRODUCTS -> printProducts();
                        case BUY_PRODUCT -> buyProduct();
                        case PRINT_MY_ORDERS -> orderStorage.getOrdersByUserId(currentUser.getId());
                        case CANCEL_ORDER_BY_ID -> cancelOrderById();
                    }
                }
            }
            if (currentUser.getUserType().equals(UserType.ADMIN)) {
                AdminCommands.adminCommands();
                String command = scanner.nextLine();
                switch (command) {
                    case AdminCommands.LOGOUT -> logout();
                    case ADD_PRODUCT -> addProduct();
                    case REMOVE_PRODUCT_BY_ID -> removeProductById();
                    case PRINT_PRODUCTS -> printProducts();
                    case PRINT_USERS -> userStorage.print();
                    case PRINT_ORDERS -> orderStorage.print();
                    case CHANGE_ORDER_STATUS -> changeOrderStatusByID();
                }
            }
        }


    }

    private static void changeOrderStatusByID() {
        if (!orderStorage.isEmpty()) {
            System.out.println("Please input order id");
            String orderId = scanner.nextLine();
            Order order = orderStorage.getOrderById(orderId);
            if (order != null) {
                if (order.getOrderStatus() == OrderStatus.NEW) {
                    order.setOrderStatus(OrderStatus.DELIVERED);
                    order.getProduct().setStockQty(order.getProduct().getStockQty() - order.getQty());
                } else {
                    System.err.println("The status of your order doesn't match the description");
                }
            } else {
                System.err.println("Order doesn't exist!!!");
            }
        } else {
            System.err.println("Order storage is empty");
        }
    }

    private static void removeProductById() {
        if (productStorage.isEmpty()){
            System.err.println("Storage is empty");
        }else {
            productStorage.print();
            System.out.println("Please input product id");
            String id = scanner.nextLine();
            productStorage.removeProductById(id);
        }
    }

    private static void addProduct() {
        System.out.println("Please input name,description,price,stockQty,Type");
        productStorage.printProductType();
        String[] productStr = scanner.nextLine().split(",");
        if (productStr.length == 5) {
            try {
                productStorage.add(new Product("P" + productIdNumber.getAndIncrement(), productStr[0], productStr[1], Double.parseDouble(productStr[2]), Integer.parseInt(productStr[3]), ProductType.valueOf(productStr[4].toUpperCase())));
            } catch (NumberFormatException e) {
                System.err.println("Invalid Symbols with number");
            } catch (EnumConstantNotPresentException e) {
                System.err.println("Enum doesn't contains");
            }
        } else {
            System.err.println("Invalid information!");
        }
        
    }

    private static void cancelOrderById() {
        if (!orderStorage.isEmpty(currentUser.getId())){
            orderStorage.getOrderById(currentUser.getId());
            System.err.println("Please input order id for cansel");
            String orderId = scanner.nextLine();
            Order order = orderStorage.getOrderById(orderId);
            if (order != null){
                if (order.getUser().equals(currentUser)){
                    order.setOrderStatus(OrderStatus.CANCELED);
                }
            }else {
                System.err.println("INVALID ID");
            }
        }else {
            System.err.println("EMPTY");
        }
    }

    private static void buyProduct() {
        if (!productStorage.isEmpty()) {
            productStorage.print();
            System.out.println("Please input product id, product count, payment method");
            orderStorage.printPaymentMethod();
            String[] orderArr = scanner.nextLine().split(",");
            Product product = productStorage.searchProductById(orderArr[0]);
            if (product != null) {
                try {
                    if (product.getStockQty() < Integer.parseInt(orderArr[1])) {
                        throw new OutOfStockException();
                    } else {
                        double amount = product.getPrice() * Integer.parseInt(orderArr[1]);
                        System.out.println("The purchase price consists of " + amount);
                        System.out.println("Please confirm input Yes or No");
                        String confirm = scanner.nextLine();
                        switch (confirm) {
                            case "Yes" ->
                                    orderStorage.add(new Order("O001" + orderIdNumber.getAndIncrement(), currentUser, product, new Date(), amount, OrderStatus.NEW, Integer.parseInt(orderArr[1]), PaymentMethod.valueOf(orderArr[2])));
                            case "No" ->
                                    System.out.println("Thank you for using our program,We hope you will change your mind");
                            default -> System.out.println("Invalid text please try again!!!");
                        }
                    }

                } catch (OutOfStockException e) {
                    System.err.println("Sorry but haven't much " + product.getName() + " of this product");
                } catch (NumberFormatException e) {
                    System.err.println("Invalid symbols!");
                }
            } else {
                System.err.println("Invalid product id");
            }
        }
    }

    private static void printProducts() {
        if (!productStorage.isEmpty()) {
            productStorage.print();
        } else {
            System.err.println("STORAGE IS EMPTY");
        }

    }

    private static void register() {
        System.out.println("Please input name, email, password");
        String[] userArr = scanner.nextLine().split(",");
        if (userArr.length == 3) {
            if (!userStorage.getUserByEmail(userArr[0])) {
                userStorage.add(new User("A001" + userIdNumber.getAndIncrement(), userArr[0], userArr[1], userArr[2], UserType.USER));
            }
        }
    }

    private static void login() {
        System.out.println("Please input email, password");
        String[] userArr = scanner.nextLine().split(",");
        if (userArr.length == 2) {
            if (!userStorage.getUserByEmail(userArr[0])) {
                currentUser = userStorage.loginUser(userArr[0], userArr[1]);
            }
            if (currentUser != null) {
                System.err.println("You sign in your account!");
            } else {
                System.err.println("Wrong EMAIL or PASSWORD please try again!");
            }
        }
    }

    private static void logout() {
        System.out.println("Are you want log out of your account ");
        System.err.print(" choose YES or NO");
        String choose = scanner.nextLine();
        switch (choose) {
            case "YES":
                currentUser = null;
                break;
            case "NO":
                System.err.println("The right  choose");
        }
    }
    
}
