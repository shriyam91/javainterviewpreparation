import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Scanner ; 
    


class dobcalculate{
    public static void main(String arg[]){
        int yr, mt, dy;
        Scanner scan= new Scanner(System.in);
        
       //SimpleDateFormat sdf= new SimpleDateFormat("dd-mm-yyyy");
       DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd-mm-yyyy");
       System.out.println("Please enter the date of birth");
        String dob=scan.nextLine();
       LocalDate db= LocalDate.parse(dob, dtf);//parse() method of LocalDate class takes String date input as one parameter and object of DateTimeFormatter class to format date string into the prespecified pattern , note that we cannot use SimpleDateFormat object here(to format the pattern of date) bcz parse() of LocalDate class only takes DateTimeFormatter object as parameter
        //converting the string into the object form  so that we can store it in the object form in the object of LocalDate class and so we can directly use the methods of LocalDate class to extract year, month, day.
      //now no matter in whateven pattern the user has input the date, the SimpleDateFormat will convert and store it in the pre-specified formmat dd-mm-yyyy;
        
        int year=db.getYear();
        int month=db.getMonthValue();
        int day=db.getDayOfMonth();
        System.out.println(year);
        System.out.println(month);
        
        System.out.println(day);
        //System.out.println(dtf.format(java.time.LocalDate.now()));
       // System.out.println(dtf.format(db));
       // System.out.println(dtf.toString());
        //for (int i = 0; i < dob.length(); i++) {
 //           if(dob.charAt(i)!='-'){
         //       sb.append(dob.charAt(i));
//
  //          }
    //        else if(dob.charAt(i)=='-' && i==2){
      //      int day= Integer.parseInt(sb.toString());
        //    sb=null;                
          //  }
            //else if( dob.charAt(i)=='-'&& i==5){
              //  int month=Integer.parseInt(sb.toString());
                //sb=null;
           // }//
            //else if(  i==dob.length()-1){
              //  int year=Integer.parseInt(sb.toString());
            //}
            
        //}
        //String currentdate= java.time.LocalDate.now().toString();//bcz jva.time.LocalDate returns an object instance, and to convert an object into a string we always use toString() function.//
       System.out.println(LocalDate.now());
        int year2=LocalDate.now().getYear();
        
        ;
        int month2=LocalDate.now().getMonthValue();
        int day2=LocalDate.now().getDayOfMonth();
        System.out.println(year2);
        System.out.println(month2);
        System.out.println(day2);
        //3 conditions to be checked: 1st:mnth2>mnth1: inside it 2 conditions to be checked: day2>day1 , day2<day1
               //2nd:mnth2<mnth1: inside it 2 conditions to be checked: day2>day1 , day2<day1
             //  3rd:mnth2=mnth1: inside it 2 conditions to be checked: day2>day1 , day2<day1
       if(month2>month){
            yr=year2-year;
           if(day2>=day){
                mt=month2-month;
               dy=day2-day;
               System.out.println("AGE is :"+yr+"years"+mt+"months and "+dy+"days");

           }
          
           else{
                mt=(month2-1)-month;
                
               if(month2-1== 0||month2-1== 1||month2-1==3||month2-1==5||month2-1==7||month2-1==8||month2-1==10){//month2-1==0 is checking for december ie 12 only, so no need to check for month2-1==12
                //
                dy= (31- day)+ day2;
                

               }
               else if(month2-1==2){//if the month prior to the current month is february
                //if(LocalDate.now().isLeapYear()  we can directly use isLeapYear() on date(and not on year) 
                if(year2 %4==0&& year2%400==0 &&year2%100!=0){//condition for a leap year 
                        dy=(29-day)+day2;

                   }
                   else{// if it is not a leap year
                        dy=(28-day)+day2;
                   }
               }
               else{
                    dy=(30-day)+day2;
               }
               System.out.println("AGE is :"+yr+"years"+mt+"months and "+dy+"days");

           }
       }
        else if(month2<month){
            yr= (year2-1)-year;
           if(day2>=day){
                mt=(12-month)+month2;
                dy=day2-day;
                System.out.println("AGE is :"+yr+"years"+mt+"months and "+dy+"days");
           }
           
           else{
             mt=(12-month)+(month2-1);
            if(month2-1== 0||month2-1== 1||month2-1==3||month2-1==5||month2-1==7||month2-1==8||month2-1==10){
                 dy= (31- day)+ day2;

               }
               else if(month2-1==2){//if it is a february
                   //if(year2 %4==0&& year2%400==0 &&year2%100!=0){//if it is a leap year//
                    if(LocalDate.now().isLeapYear()){
                    dy=(29-day)+day2;

                    }
                   else{// if it is not a leap year
                        dy=(28-day)+day2;
                   }
               }
               else{
                    dy=(30-day)+day2;
               }
               System.out.println("AGE is :"+yr+"years"+mt+"months and "+dy+"days");

           }

           }
           else {
               if(day2>=day){
                    yr=year2-year;
                    mt=0;
                    dy=day2-day;
                    System.out.println("AGE is :"+yr+"years"+mt+"months and "+dy+"days");
               }
             
               else{
                    yr=(year2-1)-year;
                    mt=(12-year)+(year-1);
                   if(month2-1== 0||month2-1== 1||month2-1==3||month2-1==5||month2-1==7||month2-1==8||month2-1==10||month2-1==12){
                     dy= (31- day)+ day2;
    
                   }
                   else if(month2-1==2){//when month2-1 is february
                       if(year2 %4==0&& year2%400==0 &&year2%100!=0){//if it is a leap year
                            dy=(29-day)+day2;
    
                       }
                       else{// if it is not a leap year
                            dy=(28-day)+day2;
                       }
                   }
                   else{
                        dy=(30-day)+day2;
                   }
                   System.out.println("AGE is :"+yr+"years"+mt+"months and "+dy+"days");
               }

           }
           
          
        
       }
    }
       //now logic to calculate the age
       
        //int day3=java.time.LocalDate.now().getDayOfMonth();

        //for (int i = 0; i < currentdate.length(); i++) {
          //  if(currentdate.charAt(i)!='-'){
            ///    sb.append(dob.charAt(i));
//
//            }
  //          else if(currentdate.charAt(i)=='-' && i==4){
  //          int year2= Integer.parseInt(sb.toString());
    //        sb=null;                
      //      }
        //    else if( currentdate.charAt(i)=='-'&& i==7){
          //      int month2=Integer.parseInt(sb.toString());
            //    sb=null;
           // }
            //else if(  i==currentdate.length()-1){
              //  int day2=Integer.parseInt(sb.toString());
            //}
            
            
       // }
        //if()
    
    
    
