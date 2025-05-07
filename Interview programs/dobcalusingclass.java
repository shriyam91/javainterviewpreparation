 import java.util.Date;
 import java.time.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;  
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
 class dobcalusingclass
{  
public static void main(String args[])   
{  
    Scanner scan= new Scanner(System.in);
        
    System.out.println("please enter date of birth ");
   // SimpleDateFormat sdf= new SimpleDateFormat("dd-mm-yyyy");
   //DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd-mm-yyyy");
    String dob=scan.nextLine();
    //parse() method of LocalDate class takes String date input as one parameter
    // and object of DateTimeFormatter class to format date string into the 
    //prespecified pattern , note that we cannot use SimpleDateFormat object
    // here(to format the pattern of date) bcz parse() of LocalDate class only 
    //takes DateTimeFormatter object as parameter
  
    LocalDate db= LocalDate.parse(dob,DateTimeFormatter.ofPattern("dd-MM-yyyy"));//converting the string into the object form  so that we can store it in the object form in the object of LocalDate class and so we can directly use the methods of LocalDate class to extract year, month, day.
   System.out.println(db.plus(2, ChronoUnit.YEARS));
  System.out.println(db.plus(2, ChronoUnit.MONTHS));
    System.out.println(db.plus(5,ChronoUnit.WEEKS));
    System.out.println(db.plusMonths(4));
    System.out.println(db.plusYears(4));
    System.out.println(db.plusWeeks(4));
    System.out.println( "days are"+db.getDayOfYear());
    System.out.println("this is the string version"+ db.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
   //format() method converts the date into a string,
   // it also takes the datetimeformatter object as parameter
    LocalDate curdate= LocalDate.now();
    LocalTime curtime= LocalTime.now();//this gives the current time
    Period gap= Period.between(db, curdate);
    System.out.println(gap);
    System.out.println("Age is "+gap.getYears()+" years "+gap.getMonths()+" months and "+gap.getDays()+"days");
    // number of days between two days
    //to get clock from your system:
    Clock clock= Clock.systemUTC();
    System.out.println("current clock is "+clock);
    System.out.println("days between using chronounit"+ChronoUnit.DAYS.between(db, curdate));
    System.out.println("Months between using chronounit"+ChronoUnit.MONTHS.between(db,curdate));
    System.out.println("hours between using chronounit"+ChronoUnit.HOURS.between(db,curdate));

}
}