package org.example.start;

import java.util.Scanner;

public class startHW1 implements Runnable{
    private Scanner scanner = new Scanner(System.in);
    @Override
    public void run() {
        //exercise1();
        //exercise2();
        exercise3();
    }
    private void exercise1()
    {
        System.out.println("\"Your time is limited," + '\n' +
        '\t' + "so don’t waste it" + '\n' +
                "\t\t" + "living someone else’s life\"" + '\n'+
                "\t\t\t" + "Steve Jobs"
        );
    }
    private void exercise2()
    {

        System.out.println("First number: ");
        int fN = scanner.nextInt();
        System.out.println("Second number: ");
        int sN = scanner.nextInt();
        System.out.println("Result: " + fN*sN/100);
    }
    private void exercise3()
    {
        System.out.println("First number: ");
        int fN = scanner.nextInt();
        System.out.println("Second number: ");
        int sN = scanner.nextInt();
        System.out.println("Third number: ");
        int tN = scanner.nextInt();
        String resNum = String.valueOf(fN) + String.valueOf(sN) + String.valueOf(tN);
        int res = Integer.parseInt(resNum);
        System.out.println("Result: " +res);
    }
    private void exercise4()
    {
        System.out.println("Write a six-digit number: ");
        int num = scanner.nextInt();
        if(String.valueOf(num).length() != 6)
        {
            System.out.println("Error");

        }
        else {
            String s = String.valueOf(num);
            char[] s2 =s.toCharArray();
            char temp = s2[0];
            s2[0] = s2[s.length()-1];
            s2[s.length()-1] = temp;
            temp= s2[1];
            s2[1]= s2[s.length()-2];
            s2[s.length()-2] = temp;
            int res = Integer.parseInt(s2.toString());
            System.out.println("Result: " + res);

        }
    }
}
