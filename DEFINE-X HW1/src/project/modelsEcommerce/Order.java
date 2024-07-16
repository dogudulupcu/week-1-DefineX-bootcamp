package project.modelsEcommerce;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private Invoice invoice;
    private List<Product> products = new ArrayList<>();

    public Order(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void addInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public void addProduct(Product product) {
        if (product.getStock() != 0) {
            products.add(product);
        } else {
            System.out.println("Product out of stock");
            return;
        }
        product.setStock(product.getStock() - 1);
    }

    public void AddOrderToCustomer() {
        customer.placeOrder(this);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" + "customer=" + customer + ", products=" + products + '}';
    }

}
