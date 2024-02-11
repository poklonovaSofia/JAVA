package org.example.works;

public class start implements Runnable{
    @Override
    public void run() {
        getCT();
    }
    private void createThread()
    {
        CalcMeteorJob t=  new CalcMeteorJob("My job");
        t.run();
        Thread k = new Thread(t);
        k.start();
    }
    private void getCT()
    {
        Thread t= Thread.currentThread();
        System.out.println(t);
    }
}
