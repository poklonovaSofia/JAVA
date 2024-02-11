package org.example.works;

public class CalcMeteorJob implements Runnable{
    private String data;
    public CalcMeteorJob(String data)
    {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("Work with: " + data);
        getCurThread();
        try{
            Thread.sleep(5000);
        }
        catch
        {

        }
    }
    private void getCurThread()
    {
        Thread t= Thread.currentThread();
        System.out.println(t);
    }


}
