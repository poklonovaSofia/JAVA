package org.example.entities;

import java.util.ArrayList;

public class Translate {
    private int called;
    public int getCalled(){return called;
    }
    private ArrayList<String> translates;
    public Translate(String tr)
    {
        translates=new ArrayList<>();
        translates.add(tr);
    }
    public void addTranslation(String t)
    {
        translates.add(t);
        called++;
    }
    public void deleteTranslation(String t)
    {
        translates.remove(t);
        called++;
    }
    public void show()
    {
        for( String t: translates)
        {
            System.out.println(t);
        }
        called++;
    }
}
