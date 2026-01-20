package Assingment4_observer;

import java.util.ArrayList;

public class WeatherStation extends Thread{

    private long runTimeMilliSeconds;
    private double temperature;
    private ArrayList<Observer> observers;

    public WeatherStation(long runTimeMilliSeconds){
        this.runTimeMilliSeconds = runTimeMilliSeconds;
        this.temperature = (Math.random() * 80) - 40;
        this.observers = new ArrayList<Observer>();
    }

    public void addObserver(Observer observer){
        this.observers.add(observer);
        System.out.println("Added observer "+observer.getName());
    }

    public void removeObserver(Observer observer){
        this.observers.remove(observer);
        System.out.println("Removed observer "+observer.getName());
    }


    @Override
    public void run() {
        try {
            long startTime = System.currentTimeMillis();
            long timePassed = 0;
            while(this.runTimeMilliSeconds > timePassed) {
                timePassed = System.currentTimeMillis() - startTime;

                double maxTemp = 40.0;
                double minTemp = -40.0;
                this.temperature += (Math.random() * 2.0) -1;
                this.temperature = Math.max(minTemp, Math.min(maxTemp, this.temperature));

                System.out.println("Weather station temperature: " + this.temperature + ". Time passed: " +timePassed+"ms.");
                for (Observer o : this.observers) {
                    o.update(this.temperature);
                }
                Thread.sleep((long)(1000 + (Math.random()*2000)) );
            }

            System.out.println("Time limit reached.");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }


    }
}
