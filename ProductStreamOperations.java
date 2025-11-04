import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.Map.Entry;

class Product {
    String name;
    double price;
    String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String toString() {
        return name + " (" + category + ") - Price: " + price;
    }
}

public class ProductStreamOperations {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 80000, "Electronics"),
            new Product("Phone", 60000, "Electronics"),
            new Product("Table", 12000, "Furniture"),
            new Product("Chair", 5000, "Furniture"),
            new Product("Shoes", 3000, "Fashion"),
            new Product("Jacket", 4500, "Fashion")
        );

        Map<String, List<Product>> groupedByCategory = products.stream()
            .collect(Collectors.groupingBy(p -> p.category));

        System.out.println("Products Grouped by Category:");
        groupedByCategory.forEach((cat, list) -> {
            System.out.println(cat + ": " + list);
        });

        Map<String, Optional<Product>> maxPriceByCategory = products.stream()
            .collect(Collectors.groupingBy(
                p -> p.category,
                Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
            ));

        System.out.println("\nMost Expensive Product in Each Category:");
        maxPriceByCategory.forEach((cat, prod) -> 
            System.out.println(cat + ": " + prod.get())
        );

        double avgPrice = products.stream()
            .collect(Collectors.averagingDouble(p -> p.price));

        System.out.println("\nAverage Price of All Products: " + avgPrice);
    }
}
