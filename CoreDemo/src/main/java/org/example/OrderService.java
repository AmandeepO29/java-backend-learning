package org.example;

import org.example.notification.notificationService;

public class OrderService {
     notificationService notification;

    public void setNotification(notificationService notification) {
        this.notification = notification;
    }


    public void placeOrder() {
        System.out.println("Order Placed");
        notification.sendNotification();
    }
}
