package Assingment4_observer;

public class Main {
    public static void main(String[] args) {

        WeatherStation wStation = new WeatherStation(15_000L);

        Observer obs1 = new Observer("Observer 1");
        Observer obs2 = new Observer("Observer 2");
        Observer obs3 = new Observer("Observer 3");

        //run with 3 observers
        wStation.addObserver(obs1);
        wStation.addObserver(obs2);
        wStation.addObserver(obs3);
        wStation.start();

        try {
           Thread.sleep(5000);
            //run with 1 observer
            wStation.removeObserver(obs1);
            wStation.removeObserver(obs2);


        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}
