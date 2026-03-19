package niccolosorrenti.es5;

import niccolosorrenti.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Product> listaProdotti = new ArrayList<>();

        Product product1 = new Product(1, "Prodotto", "Books", 150.0);
        Product product2 = new Product(2, "Prodotto2", "Baby", 15.0);
        Product product3 = new Product(3, "Prodotto3", "Books", 50.0);
        Product product4 = new Product(4, "Prodotto4", "Baby", 210.0);
        Product product5 = new Product(5, "Prodotto5", "Books", 200.0);

        listaProdotti.add(product1);
        listaProdotti.add(product2);
        listaProdotti.add(product3);
        listaProdotti.add(product4);
        listaProdotti.add(product5);

        Map<String, Double> raggruppamentoESomma = listaProdotti.stream()
                .collect(Collectors.groupingBy(product -> product.getCategory(), Collectors.summingDouble(product -> product.getPrice())));

        raggruppamentoESomma.forEach((product, somma) -> System.out.println("La somma del prodotto: " + product + " è " + somma));


    }
}
