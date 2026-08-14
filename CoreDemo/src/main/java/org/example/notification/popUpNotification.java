package org.example.notification;

public class popUpNotification implements notificationService{
    @Override
    public void sendNotification() {
        System.out.println("POP-UP sent");
    }
}
