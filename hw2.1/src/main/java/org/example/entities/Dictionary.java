package org.example.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {
    public Map<String, Translate> words = new HashMap<>();
    private  Scanner sc = new Scanner(System.in);
    public void run()
    {
        while(true)
        {
            System.out.println("1-Add word; 2-Delete word; 3-Add translate; 4-Delete translate; 5-Show translates; 6-Show popular Word");

            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    addNewWord();
                    break;
                case 2:
                    deleteWord();
                    break;
                case 3:
                    addTranslate();
                    break;
                case 4:
                    deleteTranslate();
                    break;
                case 5:
                    showTranslate();
                    break;
                case 6:
                    showPopularWord();
                    break;
                default:
                    break;
            }
        }
    }
    private void addTranslate()
    {
        System.out.println("Write  word");
        String word = sc.next();
        char[] s2 = word.toCharArray();

        Character.toUpperCase(s2[0]);
        for(int i =1; i < s2.length; i++)
        {
            Character.toLowerCase(s2[i]);
        }
        word = new String(s2);
        if(words.get(word)== null)
        {
            System.out.println("Word not found");
        }
        else {
            System.out.println("Write translate");
            String translate = sc.next();
            s2 = translate.toCharArray();
            Character.toUpperCase(s2[0]);
            for(int i =1; i < s2.length; i++)
            {
                Character.toLowerCase(s2[i]);
            }
            translate=new String(s2);
            Translate t =words.get(word);
            t.addTranslation(translate);

        }
    }
    private void addNewWord()
    {
        System.out.println("Write new word");
        String word = sc.next();
        char[] s2 = word.toCharArray();

        Character.toUpperCase(s2[0]);
        for(int i =1; i < s2.length; i++)
        {
            Character.toLowerCase(s2[i]);
        }
        word = new String(s2);
        if(words.get(word)== null)
        {
            System.out.println("Write translate");
            String translate = sc.next();
            s2 = translate.toCharArray();
            Character.toUpperCase(s2[0]);
            for(int i =1; i < s2.length; i++)
            {
                Character.toLowerCase(s2[i]);
            }
            translate=new String(s2);
            words.put(word, new Translate(translate));
        }



    }
    private void deleteTranslate()
    {
        System.out.println("Write  word");
        String word = sc.next();
        char[] s2 = word.toCharArray();

        Character.toUpperCase(s2[0]);
        for(int i =1; i < s2.length; i++)
        {
            Character.toLowerCase(s2[i]);
        }
        word = new String(s2);
        if(words.get(word)== null)
        {
            System.out.println("Word not found");
        }
        else {
            System.out.println("Write translate");
            String translate = sc.next();
            s2 = translate.toCharArray();
            Character.toUpperCase(s2[0]);
            for(int i =1; i < s2.length; i++)
            {
                Character.toLowerCase(s2[i]);
            }
            translate=new String(s2);
            Translate t =words.get(word);
            t.deleteTranslation(translate);

        }
    }
    private void deleteWord()
    {
        System.out.println("Write new word");
        String word = sc.next();
        char[] s2 = word.toCharArray();

        Character.toUpperCase(s2[0]);
        for(int i =1; i < s2.length; i++)
        {
            Character.toLowerCase(s2[i]);
        }
        word = new String(s2);
        if(words.get(word)== null) {
            System.out.println("Word not found");
        }
        else {
            words.remove(word);
        }
    }
    private void showTranslate()
    {
        System.out.println("Write new word");
        String word = sc.next();
        char[] s2 = word.toCharArray();

        Character.toUpperCase(s2[0]);
        for(int i =1; i < s2.length; i++)
        {
            Character.toLowerCase(s2[i]);
        }
        word = new String(s2);
        if(words.get(word)== null) {
            System.out.println("Word not found");
        }
        else {
            Translate t = words.get(word);
            t.show();
        }

    }
    private void showPopularWord()
    {
        for (Map.Entry<String, Translate> entry : words.entrySet()) {
            String key = entry.getKey();
            Translate value = entry.getValue();
            if(value.getCalled() >10)
            {
                System.out.println(key);
            }
        }
    }
    private void showNorPopularWord()
    {

    }
}
