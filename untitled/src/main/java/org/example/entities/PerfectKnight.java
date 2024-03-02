package org.example.entities;

import java.util.Random;

public class PerfectKnight extends  Knight{
    void attack(Ogre ogre) {
        Random random = new Random();
        double value  = random.nextDouble();
        ogre.energy = (int) (value * ogre.energy); // (int) just casts a float result into an int
        ogre.revenge(this); // this represents a reference to the current knight object
    }
}

