interface Observer{
    void update(String msg);
}

interface Publisher{
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String msg);
}

class Subscriber implements Observer{
    String name;
    public Subscriber(String name){
        this.name = name;
    }

    public void update(String msg){
        System.out.println(name + " received: " + msg);
    }

}

class EventPublisher implements Publisher{
    private List<Observer> subscibers= new ArrayList<>();
    public void registerObserver(Observer observer){
        subscibers.add(observer);
    }
    public void removeObserver(Observer observer){
        subscibers.remove(observer);
    }
    public notifyObservers(String msg){
        for(Observer ob : subscibers){
            ob.update(msg);
        }
    }
}


class Main{

    public static void main (String[] args) {
        EventPublisher event = new EventPublisher();

        Subscriber subsciber1 = new Subscriber("Marley");
        Subscriber subsciber2 = new Subscriber("Eldians");

        event.registerObserver(subsciber1);
        event.registerObserver(subsciber2);
        event.notifyObservers("War has been evolved ....");
    }
}