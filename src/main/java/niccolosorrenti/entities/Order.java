package niccolosorrenti.entities;

import java.time.LocalDate;
import java.util.List;

public class Order {
    protected List<Product> products;
    private long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private Customer customer;

    public Order(long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }

    public double calculateTotal() {
        return products.stream()
                .mapToDouble(product -> product.getPrice()).sum();
    }

    public List<Product> getProducts() {
        return products;
    }

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "products=" + products +
                ", id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", customer=" + customer +
                '}';
    }
}
