package org.example.work;

import org.example.interfaces.Interface1;
import org.example.interfaces.Interface2;
import org.example.interfaces.Interface3;

public class start implements Runnable{
    @Override
    public void run() {

    }
    private void ex()
    {
        Interface1 i;
        i= (year)-> ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));

        Interface2 i2;
        i2 = (l, l1)->java.time.temporal.ChronoUnit.DAYS.between(l, l1);

        Interface2 i3;
        i3 = (l, l1)->java.time.temporal.ChronoUnit.WEEKS.between(l, l1);

        Interface3 i4;
        i4=date->date.getDayOfWeek().toString();


    }
}
