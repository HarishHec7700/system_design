// The Facade pattern is a structural pattern that provides a simplified, unified interface to a set of interfaces in a subsystem. 
//It is commonly used to hide complexities and expose only the necessary functionality to the client.

interface Food{
   public void displayName();
}

class Pizza implements Food{
    public String name ="Pizza";
    private String ingredients;
    Pizza( String ingredients){
        this.ingredients= ingredients;
    }
    public void displayName(){
        System.out.println("Here is the Pizza with " + ingredients);
    }
}

class Burger implements Food{
    public String name ="Burger";
    private String ingredients;
    Burger( String ingredients){
        this.ingredients= ingredients;
    }
    public void displayName(){
        System.out.println("Here is the Burger with " + ingredients);
    }
}

class Taco implements Food{
    public String name ="Taco";
    private String ingredients;
    Taco( String ingredients){
        this.ingredients= ingredients;
    }
    public void displayName(){
        System.out.println("Here is the Taco with " + ingredients);
    }
}

class Kitchen{
    public Food prepareFood(String reciepe , String ingredients){
        switch(reciepe.toLowerCase()){
        case "pizza" : return new Pizza(ingredients);
        case "burger" : return new Burger(ingredients);
        case "taco" : return new Taco(ingredients);
        default: return  null;
        }
    }
}

class BillingSystem{
    public void generateBill(String reciepe){
        System.out.println("Generating the bill for : " + reciepe);
    }
}

// Here the Waiter class acts as the Fascade class there by holding multiple complex subsystems and hiding it from the client. 

class Waiter {
    private Kitchen kitchen ;
    private BillingSystem billingSystem ;

    public Waiter(){
        this.kitchen = new Kitchen();
        this.billingSystem = new BillingSystem();
    }    
    public void getOrder(String reciepe,String ingredients) {
        System.out.println("Order has been recieved : " + reciepe);
        Food food = kitchen.prepareFood(reciepe, ingredients);
        if(food == null )
            System.out.println("Sorry, we are not serving " + reciepe );
        else{
            System.out.println("Preparing the " + reciepe);
            food.displayName();
            billingSystem.generateBill(reciepe);
        }
    }
}

class Main{
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        waiter.getOrder("Taco", "hot sauce");
    }
}