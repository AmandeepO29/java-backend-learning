package org.example.notification;

public class smsService implements notificationService{
    @Override
    public void sendNotification() {
        System.out.println("SMS sent");
    }
}
