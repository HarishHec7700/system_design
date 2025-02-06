class main {
    interface Notification{
        void sendNotification(String message);
    }

    class SMSNotification implements Notification{
        public void sendNotification(String message) {
            System.out.println("Sending SMS: " + message);
        }
    }

    class EmailNotification implements Notification{
        public void sendNotification(String message) {
            System.out.println("Sending Email:" + message);
        }
    }

    class NotificationFactory {
        public static Notification createNotification(String type) {
            switch(type.toLowercase()){
            case "sms": return new SMSNotification();
            case "email": return new EmailNotification();
            default: return null;
            }
        }
    }
    
    public static void main(String[] args) {
        Notification notifycator = NotificationFactory.createNotification("sms");
        notifycator.sendNotification("Hello, World!");
    }
}