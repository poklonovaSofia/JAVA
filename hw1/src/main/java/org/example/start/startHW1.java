package org.example.start;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class startHW1 implements Runnable{
    private Scanner scanner = new Scanner(System.in);
    @Override
    public void run() {
        //exercise1();
        //exercise2();
        //exercise3();
        //exercise4();
        //exercise5();
        //exercise6();
        //exercise7();
        //exercise8();
        //exercise9();
        //exercise10();
        //exercise11();
        //exercise12();
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
            String newString = new String(s2);
            int res = Integer.parseInt(newString);

            System.out.println("Result: " + res);

        }
    }
    private void exercise5()
    {
        System.out.println("Write a number: ");
        int num = scanner.nextInt();
        switch(num)
        {
            case 1, 2, 12:
                System.out.println("Winter");
                break;
            case 3, 4, 5:
                System.out.println("Spring");
                break;
            case 6, 7, 8:
                System.out.println("Summer");
                break;
            case 9, 10, 11:
                System.out.println("Autumn");
                break;
            default:
                System.out.println("Error");
                break;

        }
    }
    private void exercise6()
    {
        System.out.println("Write a number: ");
        double num = scanner.nextDouble();
        System.out.println("Write a number(1-miles, 2-inches, 3-yards): ");
        int choice = scanner.nextInt();
        double res=0.0;
        switch(choice)
        {
            case 1:
                res= num*0.000621371;
                break;
            case 2:
                res= num*39.3701;
                break;
            case 3:
                res= num*1.09361;
                break;
            default:
                break;

        }
        System.out.println("Result: " + res);
    }
    private void exercise7()
    {
        System.out.println("First number: ");
        int fN = scanner.nextInt();
        System.out.println("Second number: ");
        int sN = scanner.nextInt();
        if(sN<fN)
        {
            int temp = fN;
            fN= sN;
            sN=temp;
        }
        for(int i=fN; i< sN; i++)
        {
            if(i%2 !=0)
                System.out.println(i);
        }
    }
    private void exercise8()
    {
        System.out.println("First number: ");
        int fN = scanner.nextInt();
        System.out.println("Second number: ");
        int sN = scanner.nextInt();
        if(sN<fN)
        {
            int temp = fN;
            fN= sN;
            sN=temp;
        }
        for(int i = fN; i<= sN; i++)
        {
            for(int j =1; j<11; j++)
            {
                System.out.print(i + "*" + j + "=" + (i*j) + " ");
            }
            System.out.print('\n');
        }
    }
    private void exercise9()
    {
        int[] mas = new int[15];
        Random random = new Random();
        int min =0, max=0;
        int countNeg=0;
        int countPos=0;
        int countZero=0;
        for(int i = 0; i<15;i++)
        {
            mas[i]= random.nextInt();
            if(i==0)
            {
                max = mas[0];
                min=mas[0];

            }
            if(mas[i]<0)
            {
                countNeg++;
            }
            else if(mas[i]>0)
            {
                countPos++;
            }
            else{
                countZero++;
            }
            if(mas[i]> max)
            {
                max=mas[i];
            }
            if(mas[i] <min)
                min = mas[i];

        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Count Negative: " + countNeg);
        System.out.println("Count Pozitive: " + countPos);
        System.out.println("Count Zero: " + countZero);

    }
    private void exercise10()
    {
        int[] mas = new int[15];
        Random random = new Random();
        for (int i = 0; i < mas.length; i++) {
            mas[i] = random.nextInt(201) - 100;
        }
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        ArrayList<Integer> positiveNumbers = new ArrayList<>();

        // Розподілення чисел по категоріях
        for (int number : mas) {
            if (number % 2 == 0 && number != 0) {
                evenNumbers.add(number);
            }
            if (number % 2 != 0) {
                oddNumbers.add(number);
            }
            if (number < 0) {
                negativeNumbers.add(number);
            }
            if (number > 0) {
                positiveNumbers.add(number);
            }
        }

        // Перетворення списків у масиви
        int[] evenArray = evenNumbers.stream().mapToInt(i -> i).toArray();
        int[] oddArray = oddNumbers.stream().mapToInt(i -> i).toArray();
        int[] negativeArray = negativeNumbers.stream().mapToInt(i -> i).toArray();
        int[] positiveArray = positiveNumbers.stream().mapToInt(i -> i).toArray();

        // Виведення результатів
        System.out.println("Оригінальний масив: ");
        printArray(mas);

        System.out.println("\nМасив четних чисел: ");
        printArray(evenArray);

        System.out.println("\nМасив нечетних чисел: ");
        printArray(oddArray);

        System.out.println("\nМасив від'ємних чисел: ");
        printArray(negativeArray);

        System.out.println("\nМасив додатніх чисел: ");
        printArray(positiveArray);
    }
    private  void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    private void exercise11()
    {
        System.out.println("Length: ");
        int length = scanner.nextInt();
        System.out.println("Direction(1-vertical; 2-horizontal): ");
        int direction = scanner.nextInt();
        System.out.println("Symbol: ");
        char symbol = scanner.next().charAt(0);
        for(int i =0; i< length;i++)
        {
            if(direction==1)
                System.out.println(symbol);
            else if(direction == 2)
                System.out.print(symbol);
        }
    }
    private void exercise12()
    {
        int[] mas = new int[15];
        Random random = new Random();
        for (int i = 0; i < mas.length; i++) {
            mas[i] = random.nextInt(201) - 100;
        }
        System.out.println("Choose(1-ascending, 2-descending): ");
        int res = scanner.nextInt();
        Arrays.sort(mas);
        if (res==2) {
            reverseArray(mas);
        }
    }
    private static void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
}
