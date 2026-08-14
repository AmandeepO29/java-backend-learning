package org.example;


import org.example.notification.notificationService;
import org.example.notification.popUpNotification;
import org.example.notification.smsService;

public class Main {
    static void main() {
        notificationService notification=new smsService();
        OrderService order = new OrderService();
        order.setNotification(notification);

        order.placeOrder();
    }
}
