package niccolosorrenti.es2;

import niccolosorrenti.entities.Customer;
import niccolosorrenti.entities.Order;
import niccolosorrenti.entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Order> listaOrdini = new ArrayList<>();

        List<Product> listaProdottiOrdinati = new ArrayList<>();
        List<Product> listaProdottiOrdinati2 = new ArrayList<>();

        Product product1 = new Product(1, "Prodotto", "Books", 150.0);
        Product product2 = new Product(2, "Prodotto2", "Baby", 15.0);
        Product product3 = new Product(3, "Prodotto3", "Books", 50.0);
        Product product4 = new Product(4, "Prodotto4", "Baby", 10.0);

        listaProdottiOrdinati.add(product1);
        listaProdottiOrdinati.add(product3);

        listaProdottiOrdinati2.add(product4);
        listaProdottiOrdinati2.add(product2);

        Customer customer1 = new Customer(1, "Customer", 1);
        Customer customer2 = new Customer(2, "Customer2", 2);

        Order order1 = (new Order(1, "Status", LocalDate.of(2026, 3, 18), LocalDate.of(2026, 4, 18), listaProdottiOrdinati, customer1));
        Order order2 = (new Order(2, "Status", LocalDate.of(2026, 3, 18), LocalDate.of(2026, 5, 18), listaProdottiOrdinati2, customer2));

        listaOrdini.add(order1);
        listaOrdini.add(order2);

        Map<Customer, Double> totaleVendite = listaOrdini.stream()
                .collect(Collectors.groupingBy(order -> order.getCustomer(), Collectors.summingDouble(order -> order.calculateTotal())));

        totaleVendite.forEach((cliente, totale) -> System.out.println("Cliente: " + cliente + " Totale: " + totale));
    }
}
