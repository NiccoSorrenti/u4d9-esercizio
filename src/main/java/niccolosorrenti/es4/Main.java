package niccolosorrenti.es4;

import niccolosorrenti.entities.Customer;
import niccolosorrenti.entities.Order;
import niccolosorrenti.entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();

        List<Product> listaProdottiOrdinati = new ArrayList<>();
        List<Product> listaProdottiOrdinati2 = new ArrayList<>();

        Product product1 = new Product(1, "Prodotto", "Books", 150.0);
        Product product2 = new Product(2, "Prodotto2", "Baby", 15.0);
        Product product3 = new Product(3, "Prodotto3", "Books", 50.0);
        Product product4 = new Product(4, "Prodotto4", "Baby", 10.0);

        listaProdottiOrdinati.add(product1);
        listaProdottiOrdinati.add(product3);

        listaProdottiOrdinati2.add(product4);

        Customer customer = new Customer(1, "Customer", 1);
        Customer customer2 = new Customer(2, "Customer2", 2);

        Order order1 = (new Order(1, "Status", LocalDate.of(2026, 3, 18), LocalDate.of(2026, 4, 18), listaProdottiOrdinati, customer));
        Order order2 = (new Order(2, "Status", LocalDate.of(2026, 3, 18), LocalDate.of(2026, 5, 18), listaProdottiOrdinati2, customer2));

        orders.add(order1);
        orders.add(order2);

        double avg = orders.stream().collect(Collectors.averagingDouble(order -> (int) order.calculateTotal()));
        System.out.println("La media dei prezzi è: " + avg);
    }
}
