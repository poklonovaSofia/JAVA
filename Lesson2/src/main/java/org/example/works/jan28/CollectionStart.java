package org.example.works.jan28;

import org.example.entities.baggage.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionStart implements Runnable {
    @Override
    public void run() {
    asInterface();
    }
    private void simpleCollection()
    {
        Collection<BaggageInterface> s= new Collection<BaggageInterface>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<BaggageInterface> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(BaggageInterface baggageInterface) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends BaggageInterface> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
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
