package Factorypattern.WithPattern;

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
        System.out.println("Sending an Push Notification");
    }
}

class NotificationFactory{
    public static Notification getNotification(String type){
        if(type.equalsIgnoreCase("email")){
            return new EmailNotification();
        }else if(type.equalsIgnoreCase("sms")){
            return new SMSNotification();
        }else if(type.equalsIgnoreCase("push")) {
            return new PushNotification();
        }
        throw new IllegalArgumentException("Invalid Notification Type");
    }
}


//Client side code
class NotificationService{
    public static void main(String[] args) {

        String type = "sms";    // May get from the input or config

        try{
            Notification notification=NotificationFactory.getNotification(type);
            notification.notifyUser();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        System.out.println("process completed successfully");


    }
}

/*
* ✅  Benefits of Factory Pattern:
      Encapsulates object creation logic.

      Promotes loose coupling.

      Easier to add new types with minimal changes to existing code.*/