package Assignment4_observer;

public class Observer {

      private String name;

    public Observer(String name){
        this.name = name;
    }

    public void update(double temperature){
        System.out.println(String.format("Observer %s got temperature %.2f C.", this.name, temperature));
    }

    public String getName() {
        return name;
    }
}
