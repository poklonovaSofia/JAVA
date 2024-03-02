package org.example.entities;

public class Boss extends BadOgre{
    void revenge(Knight knight) {
        if(hungry)
            eat(knight);
        System.out.println("Eat");
    }
}
