package homework.market.storage;

import homework.bookStorage.model.Book;
import homework.market.model.order.Order;
import homework.market.model.order.PaymentMethod;

public class OrderStorage {
    private Order[] orders = new Order[10];
    private int size;

    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(orders[i]);
        }
    }

    public void add(Order order){
        if (size == orders.length){
            extend();
        }
        orders[++size] = order;
    }

    private void extend() {
        Order[] tmp = new Order[size + 10];
        System.arraycopy(orders,0,tmp,0, size);
        orders = tmp;
    }

    public Order getOrderById(String id) {
        for (int i = 0; i < size; i++) {
            if (orders[i].getId().equals(id)) {
                return orders[i];
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return size <= -1;
    }

    public void printPaymentMethod(){
        PaymentMethod[] paymentMethods = PaymentMethod.values();
        for (PaymentMethod paymentMethod : paymentMethods) {
            System.out.println(paymentMethod);
        }
    }

    public void getOrdersByUserId(String userId){
        for (int i = 0; i < size; i++) {
            if (orders[i].getUser().getId().equals(userId)){
                System.out.println(orders[i]);
            }
        }
    }

    public boolean isEmpty(String userId){
        for (int i = 0; i < size; i++) {
            if (orders[i].getUser().getId().equals(userId)){
                return false;
            }
        }
        return true;
    }
}
