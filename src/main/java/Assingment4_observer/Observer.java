package Assingment4_observer;

public class Observer {

      private String name;

    public Observer(String name){
        this.name = name;
    }

    public void update(double temperature){
        System.out.println("Observer " +this.name +" got tempereture "+temperature+" C.");
    }



}
