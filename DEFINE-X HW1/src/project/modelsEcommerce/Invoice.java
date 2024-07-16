package project.modelsEcommerce;

public class Invoice {
    private Order order;
    private Customer customer;
    private double totalAmount = 0.0;

    public Invoice(Order order) {
        this.order = order;
        this.customer = order.getCustomer();
        calculateTotalAmount();
    }

    public Order getOrder() {
        return order;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void addInvoiceToOrder() {
        order.addInvoice(this);

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void calculateTotalAmount() {
        for (Product product : order.getProducts()) {
            totalAmount += product.getPrice();
        }
    }

    @Override
    public String toString() {
        return "Invoice{" + "order=" + order + ", totalAmount=" + totalAmount + '}';
    }

}
