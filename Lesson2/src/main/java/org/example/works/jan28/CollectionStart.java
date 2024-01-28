package org.example.works.jan28;

import org.example.entities.baggage.*;

import java.util.ArrayList;

public class CollectionStart implements Runnable {
    @Override
    public void run() {
    asInterface();
    }
    private void asObject()
    {
        ArrayList<Object> collection = new ArrayList();

        collection.add(new basket());
        collection.add(new dog());
        collection.add(new painting());
        collection.add(new cardboard());
    }
    private void asChildren()
    {
        ArrayList<AbstractBaggage> collection = new ArrayList();

        collection.add(new basket());
        collection.add(new dog());
        collection.add(new painting());
        collection.add(new cardboard());
        collection.add(new AbstractBaggage());
    }
    private void asInterface()
    {
        ArrayList<BaggageInterface> collection = new ArrayList();

        collection.add(new basket());
        collection.add(new dog());
        collection.add(new painting());
        collection.add(new cardboard());
        collection.add(new BaggageInterface() {
            @Override
            public int getSize() {
                return 0;
            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        for (int i=0; i< collection.size(); i++)
        {
            System.out.println("Size: " + collection.get(i).getSize());
            if(collection.get(i) instanceof  dog)
            {
                System.out.println("Element " + i + " is a dog");
                ((dog)collection.get(i)).eat();
            }
        }
    }


}
