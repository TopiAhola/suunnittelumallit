package Assignment15_adapter;

public class Main {
    public static void main(String[] args) {
    /*
        Test the Adapter: In the Main class that acts as the client code, demonstrate the functionality of the adapter
        by creating an instance of CalendarToNewDateAdapter, setting the date, advancing the date with several days,
        and printing the new date.
    */

        //current date
        CalendarToNewDateAdapter calendarToNewDateAdapter = new CalendarToNewDateAdapter();
        System.out.println(
                "Current date: \n"
                        + calendarToNewDateAdapter.getYear() + "\n"
                        + calendarToNewDateAdapter.getMonth() + "\n"
                        + calendarToNewDateAdapter.getDay() + "\n"
        );

        //date 35 days to future
        calendarToNewDateAdapter.advanceDays(35);
        System.out.println(
                "Date 35 days from now: \n"
                        + calendarToNewDateAdapter.getYear() + "\n"
                        + calendarToNewDateAdapter.getMonth() + "\n"
                        + calendarToNewDateAdapter.getDay() + "\n"
        );


        //date in future
        calendarToNewDateAdapter.setYear(6085);
        calendarToNewDateAdapter.setMonth(13); //this overflows to year 6086
        calendarToNewDateAdapter.setDay(35); // this overflows to month 2
        System.out.println(
                "Set date in 6086: \n"
                        + calendarToNewDateAdapter.getYear() + "\n"
                        + calendarToNewDateAdapter.getMonth() + "\n"
                        + calendarToNewDateAdapter.getDay() + "\n"
        );



    }
}
