package Assignment15_adapter;

import java.util.Calendar;

public class CalendarToNewDateAdapter implements NewDateInterface {

    private Calendar calendar;

    private static final int YEAR = 1;
    private static final int MONTH = 2;
    public static final int DAY_OF_MONTH = 5;
    private static final int DAY_OF_YEAR = 6;

    public CalendarToNewDateAdapter() {
        calendar = Calendar.getInstance();
    }



    @Override
    public void setDay(int day) {
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    @Override
    public void setMonth(int month) {
        calendar.set(Calendar.MONTH, month);
    }

    @Override
    public void setYear(int year) {
        calendar.set(Calendar.YEAR, year);
    }

    @Override
    public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getMonth() {
        return calendar.get(Calendar.MONTH);
    }

    @Override
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    @Override
    public void advanceDays(int days) {
        calendar.add(Calendar.DAY_OF_MONTH, days);

    }
}
