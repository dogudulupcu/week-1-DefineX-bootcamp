package project.main;

import java.time.LocalDate;
import java.util.List;

import project.modelsEcommerce.*;

public class Ecommerce {
    public static void main(String[] args) {
        Customer customer1 = new Customer("John", "Doe", "john@example.com", "123 Main St", LocalDate.of(1985, 3, 15));
        Customer customer2 = new Customer("Cem", "Smith", "cemsmith@example.com", "456 Elm St",LocalDate.of(1990, 8, 20));
        Customer customer3 = new Customer("Bob", "Johnson", "bob@example.com", "789 Oak St", LocalDate.of(1978, 7, 10));
        Customer customer4 = new Customer("Cem", "Yılmaz", "cem@example.com", "101 Pine St",LocalDate.of(1997, 11, 25));
        Customer customer5 = new Customer("Cem", "Brown", "cembrown@example.com", "202 Cedar St",LocalDate.of(1995, 6, 30));

        List<Customer> customers = List.of(customer1, customer2, customer3, customer4, customer5);

        Product product1 = new Product("Laptop", "Electronics", 1500.0, 10);
        Product product2 = new Product("Smartphone", "Electronics", 800.0, 20);
        Product product3 = new Product("Headphones", "Electronics", 100.0, 30);
        Product product4 = new Product("T-Shirt", "Clothing", 20.0, 50);
        Product product5 = new Product("Jeans", "Clothing", 50.0, 40);
        Product product6 = new Product("Sneakers", "Footwear", 80.0, 30);
        Product product7 = new Product("Book", "Books", 15.0, 100);
        Product product8 = new Product("Watch", "Accessories", 200.0, 15);
        Product product9 = new Product("Sunglasses", "Accessories", 50.0, 25);
        Product product10 = new Product("Backpack", "Accessories", 40.0, 20);

        Order order1 = new Order(customer1);
        Order order2 = new Order(customer3);
        Order order3 = new Order(customer3);
        Order order4 = new Order(customer4);
        Order order5 = new Order(customer5);
        Order order6 = new Order(customer4);
        Order order7 = new Order(customer5);
        Order order8 = new Order(customer2);

        order1.addProduct(product1);
        order1.addProduct(product10);
        order1.addProduct(product3);

        order2.addProduct(product4);
        order2.addProduct(product5);
        order2.addProduct(product6);

        order3.addProduct(product7);
        order3.addProduct(product5);
        order3.addProduct(product9);
        order3.addProduct(product10);

        order4.addProduct(product1);
        order4.addProduct(product2);
        order4.addProduct(product8);
        order4.addProduct(product4);
        order4.addProduct(product5);

        order5.addProduct(product6);

        order6.addProduct(product7);
        order6.addProduct(product8);
        order6.addProduct(product9);

        order7.addProduct(product10);
        order7.addProduct(product1);
        order7.addProduct(product2);
        order7.addProduct(product3);
        order7.addProduct(product4);
        order7.addProduct(product5);
        order7.addProduct(product10);

        order8.addProduct(product3);
        order8.addProduct(product7);

        customer1.placeOrder(order1);
        customer2.placeOrder(order2);
        customer3.placeOrder(order3);
        customer4.placeOrder(order4);
        customer5.placeOrder(order5);
        customer4.placeOrder(order6);
        customer5.placeOrder(order7);
        customer2.placeOrder(order8);

        Invoice invoice1 = new Invoice(order1);
        Invoice invoice2 = new Invoice(order2);
        Invoice invoice3 = new Invoice(order3);
        Invoice invoice4 = new Invoice(order4);
        Invoice invoice5 = new Invoice(order5);
        Invoice invoice6 = new Invoice(order6);
        Invoice invoice7 = new Invoice(order7);
        Invoice invoice8 = new Invoice(order8);

        invoice1.addInvoiceToOrder();
        invoice2.addInvoiceToOrder();
        invoice3.addInvoiceToOrder();
        invoice4.addInvoiceToOrder();
        invoice5.addInvoiceToOrder();
        invoice6.addInvoiceToOrder();
        invoice7.addInvoiceToOrder();
        invoice8.addInvoiceToOrder();

        List<Invoice> invoices = List.of(invoice1, invoice2, invoice3, invoice4, invoice5, invoice6, invoice7,
                invoice8);

        System.out.println("Total number of customers: " + customers.size());
        System.out.println("-----------------------------");
        System.out.println("Total products bought by customer named cem: " + customers.stream()
                .filter(customer -> customer.getCustomerName().equalsIgnoreCase("Cem"))
                .flatMapToLong(customer -> customer.getOrders().stream()
                        .flatMapToLong(order -> order.getProducts().stream().mapToLong(product -> 1)))
                .sum());

        System.out.println("-----------------------------");

        List<Customer> aged = customers.stream().filter(customer -> customer.getCustomerName().equalsIgnoreCase("cem"))
                .filter(customer -> customer.getAge() > 25 && customer.getAge() < 30).toList();

        System.out.println("Total amount spent by customers named cem aged between 25 and 30: " + aged.stream()
                .flatMapToDouble(customer -> customer.getOrders().stream()
                        .mapToDouble(order -> order.getInvoice().getTotalAmount()))
                .sum() + " TL");

        System.out.println("-----------------------------");

        System.out.println("Invoice above 1500TL:");
        invoices.stream().filter(amount -> amount.getTotalAmount() > 1500).forEach(amount -> {
            System.out.println();
            System.out.println(amount);
            System.out.println();
        });

        // System.out.println(customer4.getOrders().get(0).getInvoice().getTotalAmount()+customer4.getOrders().get(1).getInvoice().getTotalAmount()+customer5.getOrders().get(0).getInvoice().getTotalAmount()+customer5.getOrders().get(1).getInvoice().getTotalAmount());

    }

}
