package project.modelsEcommerce;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerName;
    private String customerSurname;
    private String customerEmail;
    private String customerAdress;
    private LocalDate dateOfBirth;
    private List<Order> orders = new ArrayList<>();

    public Customer(String customerName, String customerSurname, String customerEmail, String customerAdress,
            LocalDate dateOfBirth) {
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.customerEmail = customerEmail;
        this.customerAdress = customerAdress;
        this.dateOfBirth = dateOfBirth;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerAdress() {
        return customerAdress;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setCustomerAdress(String customerAdress) {
        this.customerAdress = customerAdress;
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return LocalDate.now().getYear() - dateOfBirth.getYear();
    }

    @Override
    public String toString() {
        return "Customer{" + "customerName=" + customerName + ", customerSurname=" + customerSurname
                + ", customerEmail=" + customerEmail + ", customerAdress=" + customerAdress + '}';
    }

}
