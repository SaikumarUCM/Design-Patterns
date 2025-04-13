package Factorypattern.WithoutPattern;

// Without Factory Pattern


interface Notification{
    void notifyUser();
}

class EmailNotification implements Notification{

    @Override
    public void notifyUser() {
        System.out.println("Sending an Email Notification");
    }
}

class SMSNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Sending an SMS Notification");
    }
}

class PushNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Sending a Push Notification");
    }
}


// Client -Side code

class NotificationService {
    public static void main(String[] args) {

        String type = "EMAIL";   // This could come from the input

        Notification notification;

        if(type.equalsIgnoreCase("email")){
            notification = new EmailNotification();
        }else if(type.equalsIgnoreCase("sms")){
            notification = new SMSNotification();
        }else if(type.equalsIgnoreCase("push")){
            notification = new PushNotification();
        }else{
            throw new IllegalArgumentException("Unknown Notification Type");
        }

        notification.notifyUser();


    }
}

/*
   Client code is tightly coupled with concrete classes.

   Adding a new notification type means modifying the Notification class (violates Open/Closed Principle).
* */



