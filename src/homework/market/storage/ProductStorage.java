package homework.market.storage;


import homework.market.model.order.Order;
import homework.market.model.product.Product;
import homework.market.model.product.ProductType;

public class ProductStorage {
    private Product[] products = new Product[10];
    private int size;

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(products[i]);
        }
    }

    public void add(Product product) {
        if (size == products.length) {
            extend();
        }
        products[++size] = product;
    }

    private void extend() {
        Product[] tmp = new Product[size + 10];
        System.arraycopy(products, 0, tmp, 0, size);
        products = tmp;
    }

    public void removeProductById(String id) {
        boolean found = false;
        if (size < 0) {
            System.out.println("Storage is empty");
        } else {
            for (int i = 0; i < size; i++) {
                if (products[i].getId().equals(id)) {
                    found = true;
                    for (int j = i; j < size; j++) {
                        products[j] = products[j + 1];
                    }
                    products[size] = null;
                    size--;
                    System.out.println("Product with Id " + id + " has been deleted.");
                    break;
                }
            }

            if (!found) {
                System.out.println("Product with Id " + id + " not found.");
            }
        }

    }

    public void printProductType() {
        ProductType[] productTypes = ProductType.values();
        for (ProductType productType : productTypes) {
            System.out.println(productType.name());
        }
    }

    public boolean isEmpty() {
        return size <= -1;
    }

    public Product searchProductById(String id) {
        for (int i = 0; i < size; i++) {
            if (products[i].getId().equals(id)) {
                return products[i];
            }
        }
        return null;
    }

}
