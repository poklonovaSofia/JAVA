package org.example.entities;

public class GoodKnight extends Knight{
    void attack(Ogre ogre) {
        ogre.energy = (int) (0.8 * ogre.energy); // (int) just casts a float result into an int
        ogre.revenge(this); // this represents a reference to the current knight object
    }
}
