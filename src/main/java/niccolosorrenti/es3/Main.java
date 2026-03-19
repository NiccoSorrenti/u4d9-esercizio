package niccolosorrenti.es3;

import niccolosorrenti.entities.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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


//        usare sorted
        List<Product> costoMaxProdotto = listaProdotti.stream().sorted(Comparator.comparing(product -> product.getPrice())).toList().reversed();

        costoMaxProdotto.forEach(product -> System.out.println("Prodotto con prezzo: " + product));

    }
}
