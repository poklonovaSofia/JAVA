package org.example.entities;


import java.util.Random;

public class Pier {

    private int maxCountPass;
    private double AvarageAppearencePass = 0;
    private double AvarageAppearenceBoat;
    private boolean TypeStop;


    public Pier(double AAP, double AAB, boolean TS)
    {
        AvarageAppearencePass=AAP;
        AvarageAppearenceBoat = AAB;
        TypeStop = TS;
    }
     public void start()
     {
         Random random = new Random();
         int p = 20;
         int emptyPlace = random.nextInt(p);
         double avarTime =1/(AvarageAppearencePass - p/20);

     }

}
