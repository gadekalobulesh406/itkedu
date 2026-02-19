package itkedu.com;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOrderAssignment {

    // 1 Order class
    static class Order {
        private String product;
        private double cost;

        public Order(String product, double cost) {
            this.product = product;
            this.cost = cost;
        }

        public String getProduct() {
            return product;
        }

        public double getCost() {
            return cost;
        }

        @Override
        public String toString() {
            return product + " : " + cost;
        }
    }

    public static void main(String[] args) {

        // 2 Create list of orders
        List<Order> orders = Arrays.asList(
                new Order("Laptop", 1200),
                new Order("Phone", 800),
                new Order("Laptop", 1500),
                new Order("Tablet", 600),
                new Order("Phone", 900),
                new Order("Monitor", 400),
                new Order("Tablet", 700),
                new Order("Laptop", 1000),
                new Order("Monitor", 300)
        );

        // 3 Group by product and calculate total cost
        Map<String, Double> totalCostByProduct =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getProduct,
                                Collectors.summingDouble(Order::getCost)
                        ));

        //  Sort by total cost (descending)
        List<Map.Entry<String, Double>> topProducts =
                totalCostByProduct.entrySet()
                        .stream()
                        .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                        .limit(3)
                        .collect(Collectors.toList());

        //  Output result
        System.out.println("Top 3 Most Expensive Products:");
        topProducts.forEach(entry ->
                System.out.println(entry.getKey() + " -> Total Cost: " + entry.getValue()));
    }
}

