package org.example.notification;

public class emailService implements notificationService  {
    @Override
    public void sendNotification() {
        System.out.println("email sent");
    }
}
