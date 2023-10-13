package pack7a;

import java.util.ArrayList;

public class Shop {
    private String name;
    private Catalog catalog = new Catalog();
    private ArrayList<Basket> ordersToday = new ArrayList<>();

    public Shop(String n) {
        name = n;
        catalog.add(new Drink("mix veggies", "refreshing"), 22);
        catalog.add(new Drink("lactasoy", "less hungry"), 15);
        catalog.add(new Noodles("mama", "classic"), 9);
        catalog.add(new Noodles("korean", "i can afford"), 33);
        // duplicate won't update
        catalog.add(new Noodles("mama", "duplicate"), 11);
        showCatalog();
    }

    private void showCatalog() {
        System.out.println("Welcome to " + name);
        catalog.showCatalog();
    }

    public Basket newCustomerArrives() {
        return new Basket();
    }

    public LineItem generateLineItem(String pName, int q) { // add to UML
        Product product = catalog.getProduct(pName);
        int buyPrice = catalog.getPrice(pName);
        LineItem item = new LineItem(product, q, buyPrice);
        Basket b = new Basket();
        b.putInBasket(item);
        // ordersToday.add(b);
        return item;
    }

    public LineItem generateBuyNowItem(String pName) {
        Product product = catalog.getProduct(pName);
        int buyPrice = catalog.getPrice(pName);
        // assume customer pick only 1 item and checkout.
        int quantity = 1;
        LineItem item = new LineItem(product, quantity, buyPrice);
        Basket b = new Basket();
        b.putInBasket(item);
        ordersToday.add(b);
        return item;
    }

    public void getPayment(Basket b) {
        System.out.println("I am cashier");
        ordersToday.add(b);
        b.printInvoice();
    }

    public void dailySalesReport() {
        // show each bucket sum and sum up every basket
        int grandTotal = 0;
        System.out.println("\n--DAILY SALES REPORT--\n");
        for (Basket basket : ordersToday) {
            basket.printInvoice();
            System.out.println("------------------------");
            grandTotal += basket.basketTotal;
        }
        System.out.printf("Grand total is " + grandTotal);
    }

}
