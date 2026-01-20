package Assingment4_observer;

import java.util.ArrayList;

public class WeatherStation extends Thread{

    private long runTimeNanoSeconds;
    private double temperature;
    private ArrayList<Observer> observers;

    public WeatherStation(long runTimeNanoSeconds){
        this.runTimeNanoSeconds = runTimeNanoSeconds;
        this.temperature = (Math.random() * 80) - 40;
        this.observers = new ArrayList<Observer>();
    }

    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer){
        this.observers.add(observer);
    }


    @Override
    public void run() {
        try {
            long startTime = System.nanoTime();
            long timePassed = 0;
            while(this.runTimeNanoSeconds > timePassed) {
                timePassed = System.nanoTime() - startTime;

                double maxTemp = 40.0;
                double minTemp = -40.0;
                this.temperature += (Math.random() * 2.0) -1;
                this.temperature = Math.max(minTemp, Math.min(maxTemp, this.temperature));

                System.out.println("Weather station temperature: " + this.temperature);
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
