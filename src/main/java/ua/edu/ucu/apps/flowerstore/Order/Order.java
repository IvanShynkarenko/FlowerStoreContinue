package ua.edu.ucu.apps.flowerstore.Order;

import java.util.LinkedList;

import ua.edu.ucu.apps.flowerstore.Delivery.Delivery;
import ua.edu.ucu.apps.flowerstore.Payment.Payment;
import ua.edu.ucu.apps.flowerstore.flower.Item;

public class Order {
    private LinkedList<Item> items;
    private Payment payment;
    private Delivery delivery;

    public void SetPaymentStrategy(Payment paymentStrategy){
        this.payment = paymentStrategy;
    }

    public void SetDeliveryStrategy(Delivery deliveryStrategy){
        this.delivery = deliveryStrategy;
    }

    public double calculateTotalPrice(){
        double price = 0;
        for(Item item: items){
            price += item.getPrice();
        }
        return price;
    }

    public void processOrder(){
        payment.pay(calculateTotalPrice());
        delivery.deliver(items);
    }
    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }
}
