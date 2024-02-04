package org.example.work;

import org.example.interfaces.*;
import org.example.entities.Fraction;

import java.time.temporal.ChronoUnit;

public class start implements Runnable{
    @Override
    public void run() {

    }
    public static int sumByCondition(int[] array, Interface6 condition) {
        int sum = 0;
        for (int value : array) {
            if (condition.cond(value)) {
                sum += value;
            }
        }
        return sum;
    }
    private void ex()
    {
        Interface1 i;
        i= (year)-> ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));

        Interface2 i2;
        i2 = (l, l1)-> ChronoUnit.DAYS.between(l, l1);

        Interface2 i3;
        i3 = (l, l1)-> ChronoUnit.WEEKS.between(l, l1);

        Interface3 i4;
        i4=date->date.getDayOfWeek().toString();

        Interface4 i5;
        i5= (f1, f2) ->{
            int numerator = f1.getNumerator() * f2.getDenominator() + f2.getNumerator() * f1.getDenominator();
            int denominator = f1.getDenominator() * f2.getDenominator();
            return new Fraction(numerator, denominator);
        };

        Interface4 i6;
        i6= (f1, f2) ->{
            int numerator = f1.getNumerator() * f2.getDenominator() - f2.getNumerator() * f1.getDenominator();
            int denominator = f1.getDenominator() * f2.getDenominator();
            return new Fraction(numerator, denominator);
        };

        Interface4 i7;
        i7= (f1, f2) -> {
            int numerator = f1.getNumerator() * f2.getNumerator();
            int denominator = f1.getDenominator() * f2.getDenominator();
            return new Fraction(numerator, denominator);
        };

        Interface4 i8;
        i8 =  (f1, f2) -> {
            int numerator = f1.getNumerator() * f2.getDenominator();
            int denominator = f1.getDenominator() * f2.getNumerator();
            return new Fraction(numerator, denominator);
        };

        Interface5 i9;
        i9 = (mas) -> {
            int max = mas[0];
            for(int j =1; j<4; j++)
            {
                if(max<mas[j])
                {
                    max=mas[j];
                }
            }
            return max;

        };

        Interface5 i10;
        i9 = (mas) -> {
            int min = mas[0];
            for(int j =1; j<4; j++)
            {
                if(min>mas[j])
                {
                    min=mas[j];
                }
            }
            return min;

        };
        int[] array = {1, 2, 3, 4, 5, 6};
        int specificNumber = 3;
        int sum1 = sumByCondition(array, n->n==specificNumber);

        int st = 2;
        int end=5;
        int sum2 = sumByCondition(array, n-> n<st || n>end);

        int sum3=sumByCondition(array, n-> n>0);
         int sum4 = sumByCondition(array, n->n<0);

    }
}
