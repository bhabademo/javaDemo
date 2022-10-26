package com.example.weatherAlertDemo.notification;

public class NotificationFactory {
    public Notification createNotification(String channel)
    {
        if (channel == null || channel.isEmpty())
            return null;
        switch (channel) {
            case "SMS":
                return new SmsNotification();
            case "EMAIL":
                return new EmailNotification();
            case "APP":
                return new AppNotification();
            default:
                throw new IllegalArgumentException("Unknown channel "+channel);
        }
    }
}
